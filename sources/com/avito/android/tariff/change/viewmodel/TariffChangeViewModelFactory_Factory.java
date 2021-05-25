package com.avito.android.tariff.change.viewmodel;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffChangeViewModelFactory_Factory implements Factory<TariffChangeViewModelFactory> {
    public final Provider<TariffChangeRepository> a;
    public final Provider<TariffChangeConverter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Kundle> d;

    public TariffChangeViewModelFactory_Factory(Provider<TariffChangeRepository> provider, Provider<TariffChangeConverter> provider2, Provider<SchedulersFactory> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static TariffChangeViewModelFactory_Factory create(Provider<TariffChangeRepository> provider, Provider<TariffChangeConverter> provider2, Provider<SchedulersFactory> provider3, Provider<Kundle> provider4) {
        return new TariffChangeViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static TariffChangeViewModelFactory newInstance(TariffChangeRepository tariffChangeRepository, TariffChangeConverter tariffChangeConverter, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new TariffChangeViewModelFactory(tariffChangeRepository, tariffChangeConverter, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public TariffChangeViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
