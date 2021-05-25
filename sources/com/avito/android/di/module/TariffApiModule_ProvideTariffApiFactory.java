package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.TariffApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffApiModule_ProvideTariffApiFactory implements Factory<TariffApi> {
    public final Provider<RetrofitFactory> a;

    public TariffApiModule_ProvideTariffApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static TariffApiModule_ProvideTariffApiFactory create(Provider<RetrofitFactory> provider) {
        return new TariffApiModule_ProvideTariffApiFactory(provider);
    }

    public static TariffApi provideTariffApi(RetrofitFactory retrofitFactory) {
        return (TariffApi) Preconditions.checkNotNullFromProvides(TariffApiModule.INSTANCE.provideTariffApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public TariffApi get() {
        return provideTariffApi(this.a.get());
    }
}
