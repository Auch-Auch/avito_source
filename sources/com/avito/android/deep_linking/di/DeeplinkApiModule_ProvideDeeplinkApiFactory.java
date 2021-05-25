package com.avito.android.deep_linking.di;

import com.avito.android.deep_linking.remote.DeeplinkApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeeplinkApiModule_ProvideDeeplinkApiFactory implements Factory<DeeplinkApi> {
    public final Provider<RetrofitFactory> a;

    public DeeplinkApiModule_ProvideDeeplinkApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static DeeplinkApiModule_ProvideDeeplinkApiFactory create(Provider<RetrofitFactory> provider) {
        return new DeeplinkApiModule_ProvideDeeplinkApiFactory(provider);
    }

    public static DeeplinkApi provideDeeplinkApi(RetrofitFactory retrofitFactory) {
        return (DeeplinkApi) Preconditions.checkNotNullFromProvides(DeeplinkApiModule.INSTANCE.provideDeeplinkApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public DeeplinkApi get() {
        return provideDeeplinkApi(this.a.get());
    }
}
