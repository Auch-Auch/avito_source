package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.Features;
import com.avito.android.basket.checkout.utils.CheckoutCalculator;
import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckoutViewModelFactory_Factory implements Factory<CheckoutViewModelFactory> {
    public final Provider<String> a;
    public final Provider<CheckoutRepository> b;
    public final Provider<CheckoutConverter> c;
    public final Provider<CheckoutCommitConverter> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<StringProvider> f;
    public final Provider<DeepLinkIntentFactory> g;
    public final Provider<CheckoutCalculator> h;
    public final Provider<PriceItemCreator> i;
    public final Provider<Kundle> j;
    public final Provider<Features> k;

    public CheckoutViewModelFactory_Factory(Provider<String> provider, Provider<CheckoutRepository> provider2, Provider<CheckoutConverter> provider3, Provider<CheckoutCommitConverter> provider4, Provider<SchedulersFactory> provider5, Provider<StringProvider> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<CheckoutCalculator> provider8, Provider<PriceItemCreator> provider9, Provider<Kundle> provider10, Provider<Features> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static CheckoutViewModelFactory_Factory create(Provider<String> provider, Provider<CheckoutRepository> provider2, Provider<CheckoutConverter> provider3, Provider<CheckoutCommitConverter> provider4, Provider<SchedulersFactory> provider5, Provider<StringProvider> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<CheckoutCalculator> provider8, Provider<PriceItemCreator> provider9, Provider<Kundle> provider10, Provider<Features> provider11) {
        return new CheckoutViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static CheckoutViewModelFactory newInstance(String str, CheckoutRepository checkoutRepository, CheckoutConverter checkoutConverter, CheckoutCommitConverter checkoutCommitConverter, SchedulersFactory schedulersFactory, StringProvider stringProvider, DeepLinkIntentFactory deepLinkIntentFactory, CheckoutCalculator checkoutCalculator, PriceItemCreator priceItemCreator, Kundle kundle, Features features) {
        return new CheckoutViewModelFactory(str, checkoutRepository, checkoutConverter, checkoutCommitConverter, schedulersFactory, stringProvider, deepLinkIntentFactory, checkoutCalculator, priceItemCreator, kundle, features);
    }

    @Override // javax.inject.Provider
    public CheckoutViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
