package com.avito.android.remote.di;

import com.avito.android.remote.ConfigApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ConfigApiModule_ProvideConfigApiFactory implements Factory<ConfigApi> {
    public final Provider<RetrofitFactory> a;

    public ConfigApiModule_ProvideConfigApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ConfigApiModule_ProvideConfigApiFactory create(Provider<RetrofitFactory> provider) {
        return new ConfigApiModule_ProvideConfigApiFactory(provider);
    }

    public static ConfigApi provideConfigApi(RetrofitFactory retrofitFactory) {
        return (ConfigApi) Preconditions.checkNotNullFromProvides(ConfigApiModule.INSTANCE.provideConfigApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ConfigApi get() {
        return provideConfigApi(this.a.get());
    }
}
