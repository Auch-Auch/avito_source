package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckoutConverterImpl_Factory implements Factory<CheckoutConverterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<PriceItemCreator> b;

    public CheckoutConverterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<PriceItemCreator> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CheckoutConverterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<PriceItemCreator> provider2) {
        return new CheckoutConverterImpl_Factory(provider, provider2);
    }

    public static CheckoutConverterImpl newInstance(AttributedTextFormatter attributedTextFormatter, PriceItemCreator priceItemCreator) {
        return new CheckoutConverterImpl(attributedTextFormatter, priceItemCreator);
    }

    @Override // javax.inject.Provider
    public CheckoutConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
