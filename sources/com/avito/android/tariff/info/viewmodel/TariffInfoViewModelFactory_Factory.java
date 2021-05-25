package com.avito.android.tariff.info.viewmodel;

import com.avito.android.tariff.StringProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffInfoViewModelFactory_Factory implements Factory<TariffInfoViewModelFactory> {
    public final Provider<String> a;
    public final Provider<TariffInfoRepository> b;
    public final Provider<TariffInfoConverter> c;
    public final Provider<StringProvider> d;
    public final Provider<SchedulersFactory> e;

    public TariffInfoViewModelFactory_Factory(Provider<String> provider, Provider<TariffInfoRepository> provider2, Provider<TariffInfoConverter> provider3, Provider<StringProvider> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static TariffInfoViewModelFactory_Factory create(Provider<String> provider, Provider<TariffInfoRepository> provider2, Provider<TariffInfoConverter> provider3, Provider<StringProvider> provider4, Provider<SchedulersFactory> provider5) {
        return new TariffInfoViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TariffInfoViewModelFactory newInstance(String str, TariffInfoRepository tariffInfoRepository, TariffInfoConverter tariffInfoConverter, StringProvider stringProvider, SchedulersFactory schedulersFactory) {
        return new TariffInfoViewModelFactory(str, tariffInfoRepository, tariffInfoConverter, stringProvider, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public TariffInfoViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
