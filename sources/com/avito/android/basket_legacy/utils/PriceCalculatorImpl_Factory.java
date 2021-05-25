package com.avito.android.basket_legacy.utils;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PriceCalculatorImpl_Factory implements Factory<PriceCalculatorImpl> {
    public final Provider<StringProvider> a;
    public final Provider<PriceFormatter> b;

    public PriceCalculatorImpl_Factory(Provider<StringProvider> provider, Provider<PriceFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PriceCalculatorImpl_Factory create(Provider<StringProvider> provider, Provider<PriceFormatter> provider2) {
        return new PriceCalculatorImpl_Factory(provider, provider2);
    }

    public static PriceCalculatorImpl newInstance(StringProvider stringProvider, PriceFormatter priceFormatter) {
        return new PriceCalculatorImpl(stringProvider, priceFormatter);
    }

    @Override // javax.inject.Provider
    public PriceCalculatorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
