package com.avito.android.tariff.region.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffRegionRepositoryImpl_Factory implements Factory<TariffRegionRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory> b;

    public TariffRegionRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffRegionRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        return new TariffRegionRepositoryImpl_Factory(provider, provider2);
    }

    public static TariffRegionRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory schedulersFactory) {
        return new TariffRegionRepositoryImpl(tariffApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public TariffRegionRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
