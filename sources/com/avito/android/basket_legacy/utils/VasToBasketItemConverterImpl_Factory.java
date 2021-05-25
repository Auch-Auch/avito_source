package com.avito.android.basket_legacy.utils;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasToBasketItemConverterImpl_Factory implements Factory<VasToBasketItemConverterImpl> {
    public final Provider<StringProvider> a;

    public VasToBasketItemConverterImpl_Factory(Provider<StringProvider> provider) {
        this.a = provider;
    }

    public static VasToBasketItemConverterImpl_Factory create(Provider<StringProvider> provider) {
        return new VasToBasketItemConverterImpl_Factory(provider);
    }

    public static VasToBasketItemConverterImpl newInstance(StringProvider stringProvider) {
        return new VasToBasketItemConverterImpl(stringProvider);
    }

    @Override // javax.inject.Provider
    public VasToBasketItemConverterImpl get() {
        return newInstance(this.a.get());
    }
}
