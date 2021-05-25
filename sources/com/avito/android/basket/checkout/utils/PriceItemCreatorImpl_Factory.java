package com.avito.android.basket.checkout.utils;

import com.avito.android.basket_legacy.utils.PriceFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PriceItemCreatorImpl_Factory implements Factory<PriceItemCreatorImpl> {
    public final Provider<PriceFormatter> a;

    public PriceItemCreatorImpl_Factory(Provider<PriceFormatter> provider) {
        this.a = provider;
    }

    public static PriceItemCreatorImpl_Factory create(Provider<PriceFormatter> provider) {
        return new PriceItemCreatorImpl_Factory(provider);
    }

    public static PriceItemCreatorImpl newInstance(PriceFormatter priceFormatter) {
        return new PriceItemCreatorImpl(priceFormatter);
    }

    @Override // javax.inject.Provider
    public PriceItemCreatorImpl get() {
        return newInstance(this.a.get());
    }
}
