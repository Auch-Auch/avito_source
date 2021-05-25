package com.facebook.appevents.codeless;

import a2.g.k.x.b;
import a2.g.k.x.c;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class CodelessManager {
    public static final ViewIndexingTrigger a = new ViewIndexingTrigger();
    @Nullable
    public static SensorManager b;
    @Nullable
    public static ViewIndexer c;
    @Nullable
    public static String d;
    public static final AtomicBoolean e = new AtomicBoolean(true);
    public static Boolean f;
    public static volatile Boolean g;

    public static class a implements ViewIndexingTrigger.OnShakeListener {
        public final /* synthetic */ FetchedAppSettings a;
        public final /* synthetic */ String b;

        public a(FetchedAppSettings fetchedAppSettings, String str) {
            this.a = fetchedAppSettings;
            this.b = str;
        }

        @Override // com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener
        public void onShake() {
            FetchedAppSettings fetchedAppSettings = this.a;
            boolean z = true;
            boolean z2 = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
            if (!FacebookSdk.getCodelessSetupEnabled()) {
                z = false;
            }
            if (z2 && z) {
                String str = this.b;
                if (!CodelessManager.g.booleanValue()) {
                    CodelessManager.g = Boolean.TRUE;
                    FacebookSdk.getExecutor().execute(new b(str));
                }
            }
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        f = bool;
        g = bool;
    }

    public static void disable() {
        e.set(false);
    }

    public static void enable() {
        e.set(true);
    }

    public static void onActivityDestroyed(Activity activity) {
        CodelessMatcher.a().e.remove(Integer.valueOf(activity.hashCode()));
    }

    public static void onActivityPaused(Activity activity) {
        if (e.get()) {
            CodelessMatcher a3 = CodelessMatcher.a();
            Objects.requireNonNull(a3);
            if (!InternalSettings.isUnityApp()) {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    a3.b.remove(activity);
                    a3.c.clear();
                    a3.e.put(Integer.valueOf(activity.hashCode()), (HashSet) a3.d.clone());
                    a3.d.clear();
                } else {
                    throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
                }
            }
            ViewIndexer viewIndexer = c;
            if (viewIndexer != null) {
                viewIndexer.unschedule();
            }
            SensorManager sensorManager = b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(a);
            }
        }
    }

    public static void onActivityResumed(Activity activity) {
        if (e.get()) {
            CodelessMatcher a3 = CodelessMatcher.a();
            Objects.requireNonNull(a3);
            if (!InternalSettings.isUnityApp()) {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    a3.b.add(activity);
                    a3.d.clear();
                    if (a3.e.containsKey(Integer.valueOf(activity.hashCode()))) {
                        a3.d = a3.e.get(Integer.valueOf(activity.hashCode()));
                    }
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        a3.c();
                    } else {
                        a3.a.post(new c(a3));
                    }
                } else {
                    throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
                }
            }
            Context applicationContext = activity.getApplicationContext();
            String applicationId = FacebookSdk.getApplicationId();
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                b = sensorManager;
                if (sensorManager != null) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                    c = new ViewIndexer(activity);
                    ViewIndexingTrigger viewIndexingTrigger = a;
                    viewIndexingTrigger.a = new a(appSettingsWithoutQuery, applicationId);
                    b.registerListener(viewIndexingTrigger, defaultSensor, 2);
                    if (appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        c.schedule();
                    }
                }
            }
        }
    }
}
