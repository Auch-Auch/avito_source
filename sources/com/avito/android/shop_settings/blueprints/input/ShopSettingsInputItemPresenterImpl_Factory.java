package com.avito.android.shop_settings.blueprints.input;

import dagger.internal.Factory;
public final class ShopSettingsInputItemPresenterImpl_Factory implements Factory<ShopSettingsInputItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsInputItemPresenterImpl_Factory a = new ShopSettingsInputItemPresenterImpl_Factory();
    }

    public static ShopSettingsInputItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsInputItemPresenterImpl newInstance() {
        return new ShopSettingsInputItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsInputItemPresenterImpl get() {
        return newInstance();
    }
}
