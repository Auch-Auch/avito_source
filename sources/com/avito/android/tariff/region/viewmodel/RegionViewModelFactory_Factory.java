package com.avito.android.tariff.region.viewmodel;

import com.avito.android.tariff.StringProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RegionViewModelFactory_Factory implements Factory<RegionViewModelFactory> {
    public final Provider<String> a;
    public final Provider<TariffRegionRepository> b;
    public final Provider<RegionConverter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<StringProvider> e;
    public final Provider<Kundle> f;

    public RegionViewModelFactory_Factory(Provider<String> provider, Provider<TariffRegionRepository> provider2, Provider<RegionConverter> provider3, Provider<SchedulersFactory> provider4, Provider<StringProvider> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static RegionViewModelFactory_Factory create(Provider<String> provider, Provider<TariffRegionRepository> provider2, Provider<RegionConverter> provider3, Provider<SchedulersFactory> provider4, Provider<StringProvider> provider5, Provider<Kundle> provider6) {
        return new RegionViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static RegionViewModelFactory newInstance(String str, TariffRegionRepository tariffRegionRepository, RegionConverter regionConverter, SchedulersFactory schedulersFactory, StringProvider stringProvider, Kundle kundle) {
        return new RegionViewModelFactory(str, tariffRegionRepository, regionConverter, schedulersFactory, stringProvider, kundle);
    }

    @Override // javax.inject.Provider
    public RegionViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
