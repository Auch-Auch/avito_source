package com.avito.android.tariff.count.viewmodel;

import com.avito.android.tariff.StringProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffCountViewModelFactory_Factory implements Factory<TariffCountViewModelFactory> {
    public final Provider<String> a;
    public final Provider<TariffCountRepository> b;
    public final Provider<TariffCountConverter> c;
    public final Provider<PriceConverter> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<StringProvider> f;
    public final Provider<Kundle> g;

    public TariffCountViewModelFactory_Factory(Provider<String> provider, Provider<TariffCountRepository> provider2, Provider<TariffCountConverter> provider3, Provider<PriceConverter> provider4, Provider<SchedulersFactory> provider5, Provider<StringProvider> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static TariffCountViewModelFactory_Factory create(Provider<String> provider, Provider<TariffCountRepository> provider2, Provider<TariffCountConverter> provider3, Provider<PriceConverter> provider4, Provider<SchedulersFactory> provider5, Provider<StringProvider> provider6, Provider<Kundle> provider7) {
        return new TariffCountViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static TariffCountViewModelFactory newInstance(String str, TariffCountRepository tariffCountRepository, TariffCountConverter tariffCountConverter, PriceConverter priceConverter, SchedulersFactory schedulersFactory, StringProvider stringProvider, Kundle kundle) {
        return new TariffCountViewModelFactory(str, tariffCountRepository, tariffCountConverter, priceConverter, schedulersFactory, stringProvider, kundle);
    }

    @Override // javax.inject.Provider
    public TariffCountViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
