package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffCountRepositoryImpl_Factory implements Factory<TariffCountRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory> b;

    public TariffCountRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffCountRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        return new TariffCountRepositoryImpl_Factory(provider, provider2);
    }

    public static TariffCountRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory schedulersFactory) {
        return new TariffCountRepositoryImpl(tariffApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public TariffCountRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
