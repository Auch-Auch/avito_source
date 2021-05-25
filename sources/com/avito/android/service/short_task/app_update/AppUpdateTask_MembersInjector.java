package com.avito.android.service.short_task.app_update;

import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.VersionStorage;
import com.avito.android.util.BuildInfo;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AppUpdateTask_MembersInjector implements MembersInjector<AppUpdateTask> {
    public final Provider<VersionStorage> a;
    public final Provider<AppUpdateInteractor> b;
    public final Provider<Analytics> c;
    public final Provider<BuildInfo> d;

    public AppUpdateTask_MembersInjector(Provider<VersionStorage> provider, Provider<AppUpdateInteractor> provider2, Provider<Analytics> provider3, Provider<BuildInfo> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<AppUpdateTask> create(Provider<VersionStorage> provider, Provider<AppUpdateInteractor> provider2, Provider<Analytics> provider3, Provider<BuildInfo> provider4) {
        return new AppUpdateTask_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.app_update.AppUpdateTask.analytics")
    public static void injectAnalytics(AppUpdateTask appUpdateTask, Analytics analytics) {
        appUpdateTask.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.app_update.AppUpdateTask.appUpdateInteractor")
    public static void injectAppUpdateInteractor(AppUpdateTask appUpdateTask, AppUpdateInteractor appUpdateInteractor) {
        appUpdateTask.appUpdateInteractor = appUpdateInteractor;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.app_update.AppUpdateTask.buildInfo")
    public static void injectBuildInfo(AppUpdateTask appUpdateTask, BuildInfo buildInfo) {
        appUpdateTask.buildInfo = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.app_update.AppUpdateTask.versionStorage")
    public static void injectVersionStorage(AppUpdateTask appUpdateTask, VersionStorage versionStorage) {
        appUpdateTask.versionStorage = versionStorage;
    }

    public void injectMembers(AppUpdateTask appUpdateTask) {
        injectVersionStorage(appUpdateTask, this.a.get());
        injectAppUpdateInteractor(appUpdateTask, this.b.get());
        injectAnalytics(appUpdateTask, this.c.get());
        injectBuildInfo(appUpdateTask, this.d.get());
    }
}
