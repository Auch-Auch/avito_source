package com.avito.android.shop_settings.blueprints.title_subtitle;

import dagger.internal.Factory;
public final class ShopSettingsTitleSubtitleItemPresenterImpl_Factory implements Factory<ShopSettingsTitleSubtitleItemPresenterImpl> {

    public static final class a {
        public static final ShopSettingsTitleSubtitleItemPresenterImpl_Factory a = new ShopSettingsTitleSubtitleItemPresenterImpl_Factory();
    }

    public static ShopSettingsTitleSubtitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ShopSettingsTitleSubtitleItemPresenterImpl newInstance() {
        return new ShopSettingsTitleSubtitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ShopSettingsTitleSubtitleItemPresenterImpl get() {
        return newInstance();
    }
}
