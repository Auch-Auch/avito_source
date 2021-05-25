package com.avito.android.basket_legacy.di.checkout;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.DisclaimerProvider;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverter;
import com.avito.android.basket_legacy.utils.PriceCalculator;
import com.avito.android.basket_legacy.utils.StringProvider;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverter;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModelFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyCheckoutViewModelModule_ProvideViewModelFactoryFactory implements Factory<LegacyCheckoutViewModelFactory> {
    public final LegacyCheckoutViewModelModule a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<Boolean> d;
    public final Provider<BasketRepository> e;
    public final Provider<VasToBasketItemConverter> f;
    public final Provider<FeesToBasketItemConverter> g;
    public final Provider<DeepLinkIntentFactory> h;
    public final Provider<ActivityIntentFactory> i;
    public final Provider<PriceCalculator> j;
    public final Provider<StringProvider> k;
    public final Provider<DisclaimerProvider> l;
    public final Provider<Features> m;
    public final Provider<SchedulersFactory> n;

    public LegacyCheckoutViewModelModule_ProvideViewModelFactoryFactory(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<String> provider, Provider<String> provider2, Provider<Boolean> provider3, Provider<BasketRepository> provider4, Provider<VasToBasketItemConverter> provider5, Provider<FeesToBasketItemConverter> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<ActivityIntentFactory> provider8, Provider<PriceCalculator> provider9, Provider<StringProvider> provider10, Provider<DisclaimerProvider> provider11, Provider<Features> provider12, Provider<SchedulersFactory> provider13) {
        this.a = legacyCheckoutViewModelModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
    }

    public static LegacyCheckoutViewModelModule_ProvideViewModelFactoryFactory create(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<String> provider, Provider<String> provider2, Provider<Boolean> provider3, Provider<BasketRepository> provider4, Provider<VasToBasketItemConverter> provider5, Provider<FeesToBasketItemConverter> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<ActivityIntentFactory> provider8, Provider<PriceCalculator> provider9, Provider<StringProvider> provider10, Provider<DisclaimerProvider> provider11, Provider<Features> provider12, Provider<SchedulersFactory> provider13) {
        return new LegacyCheckoutViewModelModule_ProvideViewModelFactoryFactory(legacyCheckoutViewModelModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static LegacyCheckoutViewModelFactory provideViewModelFactory(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, String str, String str2, boolean z, BasketRepository basketRepository, VasToBasketItemConverter vasToBasketItemConverter, FeesToBasketItemConverter feesToBasketItemConverter, DeepLinkIntentFactory deepLinkIntentFactory, ActivityIntentFactory activityIntentFactory, PriceCalculator priceCalculator, StringProvider stringProvider, DisclaimerProvider disclaimerProvider, Features features, SchedulersFactory schedulersFactory) {
        return (LegacyCheckoutViewModelFactory) Preconditions.checkNotNullFromProvides(legacyCheckoutViewModelModule.provideViewModelFactory(str, str2, z, basketRepository, vasToBasketItemConverter, feesToBasketItemConverter, deepLinkIntentFactory, activityIntentFactory, priceCalculator, stringProvider, disclaimerProvider, features, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public LegacyCheckoutViewModelFactory get() {
        return provideViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get().booleanValue(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get());
    }
}
