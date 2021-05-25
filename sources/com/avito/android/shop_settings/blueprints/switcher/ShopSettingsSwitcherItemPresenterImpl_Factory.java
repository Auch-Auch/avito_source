package com.avito.android.shop_settings.blueprints.switcher;

import dagger.internal.Factory;
public final class ShopSettingsSwitcherItemPresenterImpl_Factory implements Factory<ShopSettingsSwitcherItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsSwitcherItemPresenterImpl_Factory a = new ShopSettingsSwitcherItemPresenterImpl_Factory();
    }

    public static ShopSettingsSwitcherItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsSwitcherItemPresenterImpl newInstance() {
        return new ShopSettingsSwitcherItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsSwitcherItemPresenterImpl get() {
        return newInstance();
    }
}
