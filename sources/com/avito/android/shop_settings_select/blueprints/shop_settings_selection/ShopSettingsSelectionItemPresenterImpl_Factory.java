package com.avito.android.shop_settings_select.blueprints.shop_settings_selection;

import dagger.internal.Factory;
public final class ShopSettingsSelectionItemPresenterImpl_Factory implements Factory<ShopSettingsSelectionItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsSelectionItemPresenterImpl_Factory a = new ShopSettingsSelectionItemPresenterImpl_Factory();
    }

    public static ShopSettingsSelectionItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsSelectionItemPresenterImpl newInstance() {
        return new ShopSettingsSelectionItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectionItemPresenterImpl get() {
        return newInstance();
    }
}
