package com.avito.android.shop_settings;

import dagger.internal.Factory;
public final class ShopSettingsConverterImpl_Factory implements Factory<ShopSettingsConverterImpl> {

    public static final class a {
        public static final ShopSettingsConverterImpl_Factory a = new ShopSettingsConverterImpl_Factory();
    }

    public static ShopSettingsConverterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsConverterImpl newInstance() {
        return new ShopSettingsConverterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsConverterImpl get() {
        return newInstance();
    }
}
