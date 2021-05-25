package com.avito.android.tariff.info.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffInfoRepositoryImpl_Factory implements Factory<TariffInfoRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory> b;

    public TariffInfoRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffInfoRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        return new TariffInfoRepositoryImpl_Factory(provider, provider2);
    }

    public static TariffInfoRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory schedulersFactory) {
        return new TariffInfoRepositoryImpl(tariffApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public TariffInfoRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
