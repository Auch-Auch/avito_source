package com.avito.android.shop.list.business;

import dagger.internal.Factory;
public final class ShopListResultConverterImpl_Factory implements Factory<ShopListResultConverterImpl> {

    public static final class a {
        public static final ShopListResultConverterImpl_Factory a = new ShopListResultConverterImpl_Factory();
    }

    public static ShopListResultConverterImpl_Factory create() {
        return a.a;
    }

    public static ShopListResultConverterImpl newInstance() {
        return new ShopListResultConverterImpl();
    }

    @Override // javax.inject.Provider
    public ShopListResultConverterImpl get() {
        return newInstance();
    }
}
