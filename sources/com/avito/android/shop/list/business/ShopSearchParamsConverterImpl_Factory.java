package com.avito.android.shop.list.business;

import dagger.internal.Factory;
public final class ShopSearchParamsConverterImpl_Factory implements Factory<ShopSearchParamsConverterImpl> {

    public static final class a {
        public static final ShopSearchParamsConverterImpl_Factory a = new ShopSearchParamsConverterImpl_Factory();
    }

    public static ShopSearchParamsConverterImpl_Factory create() {
        return a.a;
    }

    public static ShopSearchParamsConverterImpl newInstance() {
        return new ShopSearchParamsConverterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSearchParamsConverterImpl get() {
        return newInstance();
    }
}
