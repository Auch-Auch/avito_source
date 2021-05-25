package com.avito.android.shop_settings.blueprints.form_title;

import dagger.internal.Factory;
public final class ShopSettingsFormTitleItemPresenterImpl_Factory implements Factory<ShopSettingsFormTitleItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsFormTitleItemPresenterImpl_Factory a = new ShopSettingsFormTitleItemPresenterImpl_Factory();
    }

    public static ShopSettingsFormTitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsFormTitleItemPresenterImpl newInstance() {
        return new ShopSettingsFormTitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsFormTitleItemPresenterImpl get() {
        return newInstance();
    }
}
