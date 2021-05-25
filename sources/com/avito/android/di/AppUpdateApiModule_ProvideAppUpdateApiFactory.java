package com.avito.android.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.service.short_task.app_update.AppUpdateApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppUpdateApiModule_ProvideAppUpdateApiFactory implements Factory<AppUpdateApi> {
    public final Provider<RetrofitFactory> a;

    public AppUpdateApiModule_ProvideAppUpdateApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AppUpdateApiModule_ProvideAppUpdateApiFactory create(Provider<RetrofitFactory> provider) {
        return new AppUpdateApiModule_ProvideAppUpdateApiFactory(provider);
    }

    public static AppUpdateApi provideAppUpdateApi(RetrofitFactory retrofitFactory) {
        return (AppUpdateApi) Preconditions.checkNotNullFromProvides(AppUpdateApiModule.INSTANCE.provideAppUpdateApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AppUpdateApi get() {
        return provideAppUpdateApi(this.a.get());
    }
}
