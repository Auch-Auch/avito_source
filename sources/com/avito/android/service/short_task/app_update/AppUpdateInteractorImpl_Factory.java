package com.avito.android.service.short_task.app_update;

import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppUpdateInteractorImpl_Factory implements Factory<AppUpdateInteractorImpl> {
    public final Provider<AppUpdateApi> a;
    public final Provider<TokenStorage> b;
    public final Provider<BuildInfo> c;
    public final Provider<Analytics> d;

    public AppUpdateInteractorImpl_Factory(Provider<AppUpdateApi> provider, Provider<TokenStorage> provider2, Provider<BuildInfo> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AppUpdateInteractorImpl_Factory create(Provider<AppUpdateApi> provider, Provider<TokenStorage> provider2, Provider<BuildInfo> provider3, Provider<Analytics> provider4) {
        return new AppUpdateInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AppUpdateInteractorImpl newInstance(AppUpdateApi appUpdateApi, TokenStorage tokenStorage, BuildInfo buildInfo, Analytics analytics) {
        return new AppUpdateInteractorImpl(appUpdateApi, tokenStorage, buildInfo, analytics);
    }

    @Override // javax.inject.Provider
    public AppUpdateInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
