package com.facebook.appevents.internal;

import a2.g.k.y.e;
import a2.g.k.y.f;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
public class ActivityLifecycleTracker {
    public static final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();
    public static volatile ScheduledFuture b;
    public static final Object c = new Object();
    public static AtomicInteger d = new AtomicInteger(0);
    public static volatile e e;
    public static AtomicBoolean f = new AtomicBoolean(false);
    public static String g;
    public static long h;
    public static int i = 0;
    public static WeakReference<Activity> j;

    public static class a implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                CodelessManager.enable();
            } else {
                CodelessManager.disable();
            }
        }
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivityCreated");
            AppEventUtility.assertIsMainThread();
            ActivityLifecycleTracker.onActivityCreated(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivityDestroyed");
            CodelessManager.onActivityDestroyed(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivityPaused");
            AppEventUtility.assertIsMainThread();
            if (ActivityLifecycleTracker.d.decrementAndGet() < 0) {
                ActivityLifecycleTracker.d.set(0);
            }
            ActivityLifecycleTracker.b();
            long currentTimeMillis = System.currentTimeMillis();
            String activityName = Utility.getActivityName(activity);
            CodelessManager.onActivityPaused(activity);
            ActivityLifecycleTracker.a.execute(new a2.g.k.y.a(currentTimeMillis, activityName));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivityResumed");
            AppEventUtility.assertIsMainThread();
            ActivityLifecycleTracker.onActivityResumed(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivitySaveInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ActivityLifecycleTracker.i++;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.a;
            Logger.log(loggingBehavior, "com.facebook.appevents.internal.ActivityLifecycleTracker", "onActivityStopped");
            AppEventsLogger.onContextStop();
            ActivityLifecycleTracker.i--;
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (ActivityLifecycleTracker.e == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0);
                long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0);
                e eVar = null;
                SourceApplicationInfo sourceApplicationInfo = null;
                eVar = null;
                eVar = null;
                String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
                if (!(j == 0 || j2 == 0 || string == null)) {
                    e eVar2 = new e(Long.valueOf(j), Long.valueOf(j2));
                    eVar2.c = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
                    SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                    if (defaultSharedPreferences2.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
                        sourceApplicationInfo = new SourceApplicationInfo(defaultSharedPreferences2.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences2.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
                    }
                    eVar2.e = sourceApplicationInfo;
                    eVar2.d = Long.valueOf(System.currentTimeMillis());
                    eVar2.f = UUID.fromString(string);
                    eVar = eVar2;
                }
                ActivityLifecycleTracker.e = eVar;
            }
        }
    }

    public static class d implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;

        public d(long j, String str, Context context) {
            this.a = j;
            this.b = str;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityLifecycleTracker.e == null) {
                ActivityLifecycleTracker.e = new e(Long.valueOf(this.a), null);
                f.a(this.b, null, ActivityLifecycleTracker.g, this.c);
            } else if (ActivityLifecycleTracker.e.b != null) {
                long longValue = this.a - ActivityLifecycleTracker.e.b.longValue();
                if (longValue > ((long) (ActivityLifecycleTracker.a() * 1000))) {
                    f.b(this.b, ActivityLifecycleTracker.e, ActivityLifecycleTracker.g);
                    f.a(this.b, null, ActivityLifecycleTracker.g, this.c);
                    ActivityLifecycleTracker.e = new e(Long.valueOf(this.a), null);
                } else if (longValue > 1000) {
                    ActivityLifecycleTracker.e.c++;
                }
            }
            ActivityLifecycleTracker.e.b = Long.valueOf(this.a);
            ActivityLifecycleTracker.e.a();
        }
    }

    public static int a() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
        }
        return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    public static void b() {
        synchronized (c) {
            if (b != null) {
                b.cancel(false);
            }
            b = null;
        }
    }

    @Nullable
    public static Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static UUID getCurrentSessionGuid() {
        if (e != null) {
            return e.f;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isInBackground() {
        return i == 0;
    }

    public static boolean isTracking() {
        return f.get();
    }

    public static void onActivityCreated(Activity activity) {
        a.execute(new c());
    }

    public static void onActivityResumed(Activity activity) {
        j = new WeakReference<>(activity);
        d.incrementAndGet();
        b();
        long currentTimeMillis = System.currentTimeMillis();
        h = currentTimeMillis;
        String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager.trackActivity(activity);
        a.execute(new d(currentTimeMillis, activityName, activity.getApplicationContext()));
    }

    public static void startTracking(Application application, String str) {
        if (f.compareAndSet(false, true)) {
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new a());
            g = str;
            application.registerActivityLifecycleCallbacks(new b());
        }
    }
}
