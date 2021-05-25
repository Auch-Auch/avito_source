package com.avito.android.tariff.tariff_package_info.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffPackageInfoRepositoryImpl_Factory implements Factory<TariffPackageInfoRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory3> b;

    public TariffPackageInfoRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffPackageInfoRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory3> provider2) {
        return new TariffPackageInfoRepositoryImpl_Factory(provider, provider2);
    }

    public static TariffPackageInfoRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory3 schedulersFactory3) {
        return new TariffPackageInfoRepositoryImpl(tariffApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public TariffPackageInfoRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
