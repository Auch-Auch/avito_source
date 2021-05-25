package com.google.firebase.crashlytics.internal.common;

import a2.j.e.d.d.a.f;
import a2.j.e.d.d.a.g;
import a2.j.e.d.d.a.h0;
import a2.j.e.d.d.a.k;
import a2.j.e.d.d.a.l;
import a2.j.e.d.d.a.m;
import a2.j.e.d.d.a.n;
import a2.j.e.d.d.a.p;
import a2.j.e.d.d.a.u;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class CrashlyticsCore {
    public final Context a;
    public final FirebaseApp b;
    public final DataCollectionArbiter c;
    public final long d = System.currentTimeMillis();
    public h0 e;
    public h0 f;
    public boolean g;
    public u h;
    public final IdManager i;
    public final BreadcrumbSource j;
    public final AnalyticsEventLogger k;
    public ExecutorService l;
    public f m;
    public CrashlyticsNativeComponent n;

    public class a implements Callable<Task<Void>> {
        public final /* synthetic */ SettingsDataProvider a;

        public a(SettingsDataProvider settingsDataProvider) {
            this.a = settingsDataProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CrashlyticsCore.a(CrashlyticsCore.this, this.a);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ SettingsDataProvider a;

        public b(SettingsDataProvider settingsDataProvider) {
            this.a = settingsDataProvider;
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashlyticsCore.a(CrashlyticsCore.this, this.a);
        }
    }

    public class c implements Callable<Boolean> {
        public c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                boolean delete = CrashlyticsCore.this.e.b().delete();
                Logger logger = Logger.getLogger();
                logger.d("Initialization marker file removed: " + delete);
                return Boolean.valueOf(delete);
            } catch (Exception e) {
                Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.FALSE;
            }
        }
    }

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, ExecutorService executorService) {
        this.b = firebaseApp;
        this.c = dataCollectionArbiter;
        this.a = firebaseApp.getApplicationContext();
        this.i = idManager;
        this.n = crashlyticsNativeComponent;
        this.j = breadcrumbSource;
        this.k = analyticsEventLogger;
        this.l = executorService;
        this.m = new f(executorService);
    }

    public static Task a(CrashlyticsCore crashlyticsCore, SettingsDataProvider settingsDataProvider) {
        Task<Void> task;
        crashlyticsCore.m.a();
        crashlyticsCore.e.a();
        Logger.getLogger().d("Initialization marker file created.");
        u uVar = crashlyticsCore.h;
        f fVar = uVar.f;
        fVar.b(new g(fVar, new p(uVar)));
        try {
            crashlyticsCore.j.registerBreadcrumbHandler(new BreadcrumbHandler(crashlyticsCore) { // from class: a2.j.e.d.d.a.f0
                public final CrashlyticsCore a;

                {
                    this.a = r1;
                }

                @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                public void handleBreadcrumb(String str) {
                    this.a.log(str);
                }
            });
            Settings settings = settingsDataProvider.getSettings();
            if (!settings.getFeaturesData().collectReports) {
                Logger.getLogger().d("Collection of crash reports disabled in Crashlytics settings.");
                task = Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            } else {
                if (!crashlyticsCore.h.f(settings.getSessionData().maxCustomExceptionEvents)) {
                    Logger.getLogger().d("Could not finalize previous sessions.");
                }
                task = crashlyticsCore.h.r(1.0f, settingsDataProvider.getAppSettings());
            }
        } catch (Exception e2) {
            Logger.getLogger().e("Crashlytics encountered a problem during asynchronous initialization.", e2);
            task = Tasks.forException(e2);
        } catch (Throwable th) {
            crashlyticsCore.c();
            throw th;
        }
        crashlyticsCore.c();
        return task;
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public final void b(SettingsDataProvider settingsDataProvider) {
        Future<?> submit = this.l.submit(new b(settingsDataProvider));
        Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Logger.getLogger().e("Crashlytics was interrupted during initialization.", e2);
        } catch (ExecutionException e3) {
            Logger.getLogger().e("Problem encountered during Crashlytics initialization.", e3);
        } catch (TimeoutException e4) {
            Logger.getLogger().e("Crashlytics timed out during initialization.", e4);
        }
    }

    public void c() {
        this.m.b(new c());
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        u uVar = this.h;
        if (uVar.y.compareAndSet(false, true)) {
            return uVar.v.getTask();
        }
        Logger.getLogger().d("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(Boolean.FALSE);
    }

    public Task<Void> deleteUnsentReports() {
        u uVar = this.h;
        uVar.w.trySetResult(Boolean.FALSE);
        return uVar.x.getTask();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.g;
    }

    public Task<Void> doBackgroundInitializationAsync(SettingsDataProvider settingsDataProvider) {
        return Utils.callTask(this.l, new a(settingsDataProvider));
    }

    public void log(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.d;
        u uVar = this.h;
        uVar.f.b(new k(uVar, currentTimeMillis, str));
    }

    public void logException(@NonNull Throwable th) {
        u uVar = this.h;
        Thread currentThread = Thread.currentThread();
        Objects.requireNonNull(uVar);
        Date date = new Date();
        f fVar = uVar.f;
        fVar.b(new g(fVar, new l(uVar, date, th, currentThread)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreExecute(com.google.firebase.crashlytics.internal.settings.SettingsDataProvider r27) {
        /*
        // Method dump skipped, instructions count: 374
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.onPreExecute(com.google.firebase.crashlytics.internal.settings.SettingsDataProvider):boolean");
    }

    public Task<Void> sendUnsentReports() {
        u uVar = this.h;
        uVar.w.trySetResult(Boolean.TRUE);
        return uVar.x.getTask();
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.c.setCrashlyticsDataCollectionEnabled(bool);
    }

    public void setCustomKey(String str, String str2) {
        u uVar = this.h;
        Objects.requireNonNull(uVar);
        try {
            uVar.e.setCustomKey(str, str2);
            uVar.f.b(new n(uVar, uVar.e.getCustomKeys()));
        } catch (IllegalArgumentException e2) {
            Context context = uVar.b;
            if (context == null || !CommonUtils.isAppDebuggable(context)) {
                Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e2;
        }
    }

    public void setUserId(String str) {
        u uVar = this.h;
        uVar.e.setUserId(str);
        uVar.f.b(new m(uVar, uVar.e));
    }
}
