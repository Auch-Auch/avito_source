package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.network.CreateAppSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.UpdateAppSpiCall;
import java.util.Objects;
import java.util.concurrent.Executor;
public class Onboarding {
    public final HttpRequestFactory a = new HttpRequestFactory();
    public final FirebaseApp b;
    public final Context c;
    public PackageManager d;
    public String e;
    public PackageInfo f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public IdManager l;
    public DataCollectionArbiter m;

    public class a implements SuccessContinuation<AppSettingsData, Void> {
        public final /* synthetic */ String a;
        public final /* synthetic */ SettingsController b;
        public final /* synthetic */ Executor c;

        public a(String str, SettingsController settingsController, Executor executor) {
            this.a = str;
            this.b = settingsController;
            this.c = executor;
        }

        /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        public Task<Void> then(@Nullable AppSettingsData appSettingsData) throws Exception {
            try {
                Onboarding.a(Onboarding.this, appSettingsData, this.a, this.b, this.c, true);
                return null;
            } catch (Exception e) {
                Logger.getLogger().e("Error performing auto configuration.", e);
                throw e;
            }
        }
    }

    public class b implements SuccessContinuation<Void, AppSettingsData> {
        public final /* synthetic */ SettingsController a;

        public b(Onboarding onboarding, SettingsController settingsController) {
            this.a = settingsController;
        }

        /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        public Task<AppSettingsData> then(@Nullable Void r1) throws Exception {
            return this.a.getAppSettings();
        }
    }

    public class c implements Continuation<Void, Object> {
        public c(Onboarding onboarding) {
        }

        @Override // com.google.android.gms.tasks.Continuation
        public Object then(@NonNull Task<Void> task) throws Exception {
            if (task.isSuccessful()) {
                return null;
            }
            Logger.getLogger().e("Error fetching settings.", task.getException());
            return null;
        }
    }

    public Onboarding(FirebaseApp firebaseApp, Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter) {
        this.b = firebaseApp;
        this.c = context;
        this.l = idManager;
        this.m = dataCollectionArbiter;
    }

    public static void a(Onboarding onboarding, AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z) {
        Objects.requireNonNull(onboarding);
        if (AppSettingsData.STATUS_NEW.equals(appSettingsData.status)) {
            if (new CreateAppSpiCall(onboarding.c(), appSettingsData.url, onboarding.a, CrashlyticsCore.getVersion()).invoke(onboarding.b(appSettingsData.organizationId, str), z)) {
                settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
            } else {
                Logger.getLogger().e("Failed to create app with Crashlytics service.", null);
            }
        } else if (AppSettingsData.STATUS_CONFIGURED.equals(appSettingsData.status)) {
            settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
        } else if (appSettingsData.updateRequired) {
            Logger.getLogger().d("Server says an update is required - forcing a full App update.");
            new UpdateAppSpiCall(onboarding.c(), appSettingsData.url, onboarding.a, CrashlyticsCore.getVersion()).invoke(onboarding.b(appSettingsData.organizationId, str), z);
        }
    }

    public final AppRequestData b(String str, String str2) {
        return new AppRequestData(str, str2, this.l.getAppIdentifier(), this.h, this.g, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(getContext()), str2, this.h, this.g), this.j, DeliveryMechanism.determineFrom(this.i).getId(), this.k, "0");
    }

    public String c() {
        return CommonUtils.getStringsFileValue(this.c, "com.crashlytics.ApiEndpoint");
    }

    public void doOnboarding(Executor executor, SettingsController settingsController) {
        this.m.waitForDataCollectionPermission().onSuccessTask(executor, new b(this, settingsController)).onSuccessTask(executor, new a(this.b.getOptions().getApplicationId(), settingsController, executor));
    }

    public Context getContext() {
        return this.c;
    }

    public boolean onPreExecute() {
        try {
            this.i = this.l.getInstallerPackageName();
            this.d = this.c.getPackageManager();
            String packageName = this.c.getPackageName();
            this.e = packageName;
            PackageInfo packageInfo = this.d.getPackageInfo(packageName, 0);
            this.f = packageInfo;
            this.g = Integer.toString(packageInfo.versionCode);
            String str = this.f.versionName;
            if (str == null) {
                str = IdManager.DEFAULT_VERSION_NAME;
            }
            this.h = str;
            this.j = this.d.getApplicationLabel(this.c.getApplicationInfo()).toString();
            this.k = Integer.toString(this.c.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.getLogger().e("Failed init", e2);
            return false;
        }
    }

    public SettingsController retrieveSettingsData(Context context, FirebaseApp firebaseApp, Executor executor) {
        SettingsController create = SettingsController.create(context, firebaseApp.getOptions().getApplicationId(), this.l, this.a, this.g, this.h, c(), this.m);
        create.loadSettingsData(executor).continueWith(executor, new c(this));
        return create;
    }
}
