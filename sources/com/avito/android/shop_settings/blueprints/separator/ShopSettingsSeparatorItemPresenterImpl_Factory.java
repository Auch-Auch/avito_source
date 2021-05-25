package com.avito.android.shop_settings.blueprints.separator;

import dagger.internal.Factory;
public final class ShopSettingsSeparatorItemPresenterImpl_Factory implements Factory<ShopSettingsSeparatorItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsSeparatorItemPresenterImpl_Factory a = new ShopSettingsSeparatorItemPresenterImpl_Factory();
    }

    public static ShopSettingsSeparatorItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsSeparatorItemPresenterImpl newInstance() {
        return new ShopSettingsSeparatorItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsSeparatorItemPresenterImpl get() {
        return newInstance();
    }
}
