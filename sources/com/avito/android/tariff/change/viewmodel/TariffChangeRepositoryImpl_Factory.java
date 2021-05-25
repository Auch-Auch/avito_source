package com.avito.android.tariff.change.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffChangeRepositoryImpl_Factory implements Factory<TariffChangeRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory> b;

    public TariffChangeRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffChangeRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        return new TariffChangeRepositoryImpl_Factory(provider, provider2);
    }

    public static TariffChangeRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory schedulersFactory) {
        return new TariffChangeRepositoryImpl(tariffApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public TariffChangeRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
