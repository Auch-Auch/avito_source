package com.avito.android.tariff.tariff_package_info.viewmodel;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffPackageInfoViewModelFactory_Factory implements Factory<TariffPackageInfoViewModelFactory> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<TariffPackageInfoConverter> c;
    public final Provider<TariffPackageInfoRepository> d;
    public final Provider<SchedulersFactory3> e;

    public TariffPackageInfoViewModelFactory_Factory(Provider<String> provider, Provider<String> provider2, Provider<TariffPackageInfoConverter> provider3, Provider<TariffPackageInfoRepository> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static TariffPackageInfoViewModelFactory_Factory create(Provider<String> provider, Provider<String> provider2, Provider<TariffPackageInfoConverter> provider3, Provider<TariffPackageInfoRepository> provider4, Provider<SchedulersFactory3> provider5) {
        return new TariffPackageInfoViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TariffPackageInfoViewModelFactory newInstance(String str, String str2, TariffPackageInfoConverter tariffPackageInfoConverter, TariffPackageInfoRepository tariffPackageInfoRepository, SchedulersFactory3 schedulersFactory3) {
        return new TariffPackageInfoViewModelFactory(str, str2, tariffPackageInfoConverter, tariffPackageInfoRepository, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public TariffPackageInfoViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
