package com.avito.android.version_conflict;

import android.os.Build;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.remote.ConfigApi;
import com.avito.android.remote.config.AppConfig;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/version_conflict/CheckConfigTask;", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "", "execute", "()V", "Lcom/avito/android/version_conflict/ConfigUpdatedRouter;", "configUpdatedRouter", "Lcom/avito/android/version_conflict/ConfigUpdatedRouter;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/version_conflict/MutableConfigStorage;", "configStorage", "Lcom/avito/android/version_conflict/MutableConfigStorage;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/remote/ConfigApi;", "api", "Lcom/avito/android/remote/ConfigApi;", "<init>", "(Lcom/avito/android/remote/ConfigApi;Lcom/avito/android/version_conflict/MutableConfigStorage;Lcom/avito/android/version_conflict/ConfigUpdatedRouter;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/util/SchedulersFactory;)V", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
public final class CheckConfigTask implements ApplicationForegroundStartupTask {
    public final ConfigApi api;
    public final BuildInfo buildInfo;
    public final MutableConfigStorage configStorage;
    public final ConfigUpdatedRouter configUpdatedRouter;
    public final SchedulersFactory schedulers;

    public static final class a<T> implements Consumer<AppConfig> {
        public final /* synthetic */ CheckConfigTask a;

        public a(CheckConfigTask checkConfigTask) {
            this.a = checkConfigTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AppConfig appConfig) {
            AppConfig appConfig2 = appConfig;
            CheckConfigTask checkConfigTask = this.a;
            Intrinsics.checkNotNullExpressionValue(appConfig2, "it");
            CheckConfigTask.access$processConfig(checkConfigTask, appConfig2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ CheckConfigTask a;

        public b(CheckConfigTask checkConfigTask) {
            this.a = checkConfigTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            CheckConfigTask checkConfigTask = this.a;
            CheckConfigTask.access$processConfig(checkConfigTask, CheckConfigTask.access$getConfig(checkConfigTask));
        }
    }

    public CheckConfigTask(@NotNull ConfigApi configApi, @NotNull MutableConfigStorage mutableConfigStorage, @NotNull ConfigUpdatedRouter configUpdatedRouter2, @NotNull BuildInfo buildInfo2, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(configApi, "api");
        Intrinsics.checkNotNullParameter(mutableConfigStorage, "configStorage");
        Intrinsics.checkNotNullParameter(configUpdatedRouter2, "configUpdatedRouter");
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.api = configApi;
        this.configStorage = mutableConfigStorage;
        this.configUpdatedRouter = configUpdatedRouter2;
        this.buildInfo = buildInfo2;
        this.schedulers = schedulersFactory;
    }

    public static final AppConfig access$getConfig(CheckConfigTask checkConfigTask) {
        AppConfig config = checkConfigTask.configStorage.getConfig();
        return config != null ? config : CheckConfigTaskKt.getDefaultAppConfig();
    }

    public static final void access$processConfig(CheckConfigTask checkConfigTask, AppConfig appConfig) {
        checkConfigTask.configStorage.saveConfig(appConfig);
        int validateVersion = appConfig.validateVersion(checkConfigTask.buildInfo.getVersionCode(), Build.VERSION.SDK_INT);
        if (validateVersion == 1) {
            checkConfigTask.configUpdatedRouter.openUpdateProposalScreen();
        } else if (validateVersion == 2) {
            checkConfigTask.configUpdatedRouter.openUpdateRequiredScreen();
        } else if (validateVersion == 3) {
            checkConfigTask.configUpdatedRouter.openUpgradeWithDeviceWarningScreen();
        } else if (validateVersion == 4) {
            checkConfigTask.configUpdatedRouter.openDeviceNotSupportedScreen();
        }
    }

    @Override // com.avito.android.app.task.ApplicationForegroundStartupTask
    public void execute() {
        InteropKt.toV2(this.api.getConfig()).subscribeOn(this.schedulers.io()).observeOn(this.schedulers.io()).subscribe(new a(this), new b(this));
    }
}
