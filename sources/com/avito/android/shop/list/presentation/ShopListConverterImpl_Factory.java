package com.avito.android.shop.list.presentation;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopListConverterImpl_Factory implements Factory<ShopListConverterImpl> {
    public final Provider<Integer> a;

    public ShopListConverterImpl_Factory(Provider<Integer> provider) {
        this.a = provider;
    }

    public static ShopListConverterImpl_Factory create(Provider<Integer> provider) {
        return new ShopListConverterImpl_Factory(provider);
    }

    public static ShopListConverterImpl newInstance(int i) {
        return new ShopListConverterImpl(i);
    }

    @Override // javax.inject.Provider
    public ShopListConverterImpl get() {
        return newInstance(this.a.get().intValue());
    }
}
