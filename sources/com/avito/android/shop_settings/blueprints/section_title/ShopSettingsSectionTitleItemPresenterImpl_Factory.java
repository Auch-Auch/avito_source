package com.avito.android.shop_settings.blueprints.section_title;

import dagger.internal.Factory;
public final class ShopSettingsSectionTitleItemPresenterImpl_Factory implements Factory<ShopSettingsSectionTitleItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsSectionTitleItemPresenterImpl_Factory a = new ShopSettingsSectionTitleItemPresenterImpl_Factory();
    }

    public static ShopSettingsSectionTitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsSectionTitleItemPresenterImpl newInstance() {
        return new ShopSettingsSectionTitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsSectionTitleItemPresenterImpl get() {
        return newInstance();
    }
}
