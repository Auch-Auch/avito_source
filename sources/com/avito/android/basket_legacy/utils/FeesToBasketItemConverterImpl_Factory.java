package com.avito.android.basket_legacy.utils;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeesToBasketItemConverterImpl_Factory implements Factory<FeesToBasketItemConverterImpl> {
    public final Provider<StringProvider> a;

    public FeesToBasketItemConverterImpl_Factory(Provider<StringProvider> provider) {
        this.a = provider;
    }

    public static FeesToBasketItemConverterImpl_Factory create(Provider<StringProvider> provider) {
        return new FeesToBasketItemConverterImpl_Factory(provider);
    }

    public static FeesToBasketItemConverterImpl newInstance(StringProvider stringProvider) {
        return new FeesToBasketItemConverterImpl(stringProvider);
    }

    @Override // javax.inject.Provider
    public FeesToBasketItemConverterImpl get() {
        return newInstance(this.a.get());
    }
}
