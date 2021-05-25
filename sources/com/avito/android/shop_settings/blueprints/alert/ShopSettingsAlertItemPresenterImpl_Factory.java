package com.avito.android.shop_settings.blueprints.alert;

import dagger.internal.Factory;
public final class ShopSettingsAlertItemPresenterImpl_Factory implements Factory<ShopSettingsAlertItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsAlertItemPresenterImpl_Factory a = new ShopSettingsAlertItemPresenterImpl_Factory();
    }

    public static ShopSettingsAlertItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsAlertItemPresenterImpl newInstance() {
        return new ShopSettingsAlertItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsAlertItemPresenterImpl get() {
        return newInstance();
    }
}
