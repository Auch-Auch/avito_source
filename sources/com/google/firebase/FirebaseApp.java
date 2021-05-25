package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;
public class FirebaseApp {
    @NonNull
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    public static final Object j = new Object();
    public static final Executor k = new c(null);
    @GuardedBy("LOCK")
    public static final Map<String, FirebaseApp> l = new ArrayMap();
    public final Context a;
    public final String b;
    public final FirebaseOptions c;
    public final ComponentRuntime d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final Lazy<DataCollectionConfigStorage> g;
    public final List<BackgroundStateChangeListener> h = new CopyOnWriteArrayList();
    public final List<FirebaseAppLifecycleListener> i = new CopyOnWriteArrayList();

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    public static class b implements BackgroundDetector.BackgroundStateChangeListener {
        public static AtomicReference<b> a = new AtomicReference<>();

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z) {
            String str = FirebaseApp.DEFAULT_APP_NAME;
            synchronized (FirebaseApp.j) {
                Iterator it = new ArrayList(FirebaseApp.l.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.e.get()) {
                        firebaseApp.d(z);
                    }
                }
            }
        }
    }

    public static class c implements Executor {
        public static final Handler a = new Handler(Looper.getMainLooper());

        public c(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            a.post(runnable);
        }
    }

    @TargetApi(24)
    public static class d extends BroadcastReceiver {
        public static AtomicReference<d> b = new AtomicReference<>();
        public final Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = FirebaseApp.DEFAULT_APP_NAME;
            synchronized (FirebaseApp.j) {
                for (FirebaseApp firebaseApp : FirebaseApp.l.values()) {
                    firebaseApp.c();
                }
            }
            this.a.unregisterReceiver(this);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x008d: APUT  
      (r4v1 com.google.firebase.components.Component[])
      (5 ??[int, float, short, byte, char])
      (r10v6 com.google.firebase.components.Component<?>)
     */
    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.a = (Context) Preconditions.checkNotNull(context);
        this.b = Preconditions.checkNotEmpty(str);
        this.c = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        List<ComponentRegistrar> discover = ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discover();
        String detectVersion = KotlinDetector.detectVersion();
        Executor executor = k;
        Component[] componentArr = new Component[8];
        componentArr[0] = Component.of(context, Context.class, new Class[0]);
        componentArr[1] = Component.of(this, FirebaseApp.class, new Class[0]);
        componentArr[2] = Component.of(firebaseOptions, FirebaseOptions.class, new Class[0]);
        componentArr[3] = LibraryVersionComponent.create("fire-android", "");
        componentArr[4] = LibraryVersionComponent.create("fire-core", BuildConfig.VERSION_NAME);
        componentArr[5] = detectVersion != null ? LibraryVersionComponent.create("kotlin", detectVersion) : null;
        componentArr[6] = DefaultUserAgentPublisher.component();
        componentArr[7] = DefaultHeartBeatInfo.component();
        this.d = new ComponentRuntime(executor, discover, componentArr);
        this.g = new Lazy<>(new Provider(this, context) { // from class: a2.j.e.a
            public final FirebaseApp a;
            public final Context b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.google.firebase.inject.Provider
            public Object get() {
                FirebaseApp firebaseApp = this.a;
                Context context2 = this.b;
                String str2 = FirebaseApp.DEFAULT_APP_NAME;
                return new DataCollectionConfigStorage(context2, firebaseApp.getPersistenceKey(), (Publisher) firebaseApp.d.get(Publisher.class));
            }
        });
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        synchronized (j) {
            for (FirebaseApp firebaseApp : l.values()) {
                arrayList.add(firebaseApp.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @VisibleForTesting
    public static void clearInstancesForTest() {
        synchronized (j) {
            l.clear();
        }
    }

    @NonNull
    public static List<FirebaseApp> getApps(@NonNull Context context) {
        ArrayList arrayList;
        synchronized (j) {
            arrayList = new ArrayList(l.values());
        }
        return arrayList;
    }

    @NonNull
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (j) {
            firebaseApp = l.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        FirebaseApp firebaseApp;
        AtomicReference<b> atomicReference = b.a;
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            Application application = (Application) context.getApplicationContext();
            if (b.a.get() == null) {
                b bVar = new b();
                if (b.a.compareAndSet(null, bVar)) {
                    BackgroundDetector.initialize(application);
                    BackgroundDetector.getInstance().addListener(bVar);
                }
            }
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (j) {
            Map<String, FirebaseApp> map = l;
            boolean z = !map.containsKey(trim);
            Preconditions.checkState(z, "FirebaseApp name " + trim + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, trim, firebaseOptions);
            map.put(trim, firebaseApp);
        }
        firebaseApp.c();
        return firebaseApp;
    }

    public final void a() {
        Preconditions.checkState(!this.f.get(), "FirebaseApp was deleted");
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        a();
        if (this.e.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.h.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        a();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.i.add(firebaseAppLifecycleListener);
    }

    public final void c() {
        if (!UserManagerCompat.isUserUnlocked(this.a)) {
            getName();
            Context context = this.a;
            if (d.b.get() == null) {
                d dVar = new d(context);
                if (d.b.compareAndSet(null, dVar)) {
                    context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        getName();
        this.d.initializeEagerComponents(isDefaultApp());
    }

    public final void d(boolean z) {
        for (BackgroundStateChangeListener backgroundStateChangeListener : this.h) {
            backgroundStateChangeListener.onBackgroundStateChanged(z);
        }
    }

    public void delete() {
        if (this.f.compareAndSet(false, true)) {
            synchronized (j) {
                l.remove(this.b);
            }
            for (FirebaseAppLifecycleListener firebaseAppLifecycleListener : this.i) {
                firebaseAppLifecycleListener.onDeleted(this.b, this.c);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.b.equals(((FirebaseApp) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        a();
        return (T) this.d.get(cls);
    }

    @NonNull
    public Context getApplicationContext() {
        a();
        return this.a;
    }

    @NonNull
    public String getName() {
        a();
        return this.b;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        a();
        return this.c;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        a();
        return this.g.get().isEnabled();
    }

    @KeepForSdk
    @VisibleForTesting
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        a();
        this.h.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        a();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.i.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        a();
        if (this.e.compareAndSet(!z, z)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && isInBackground) {
                d(true);
            } else if (!z && isInBackground) {
                d(false);
            }
        }
    }

    @KeepForSdk
    public void setDataCollectionDefaultEnabled(Boolean bool) {
        a();
        this.g.get().setEnabled(bool);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.b).add("options", this.c).toString();
    }

    @KeepForSdk
    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z));
    }

    @KeepForSdk
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    @NonNull
    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (j) {
            firebaseApp = l.get(str.trim());
            if (firebaseApp == null) {
                List<String> b2 = b();
                if (((ArrayList) b2).isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", b2);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(@NonNull Context context) {
        synchronized (j) {
            if (l.containsKey(DEFAULT_APP_NAME)) {
                return getInstance();
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            return initializeApp(context, fromResource);
        }
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }
}
