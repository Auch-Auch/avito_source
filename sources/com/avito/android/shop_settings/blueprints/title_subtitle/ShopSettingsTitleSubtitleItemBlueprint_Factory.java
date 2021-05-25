package com.avito.android.shop_settings.blueprints.title_subtitle;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsTitleSubtitleItemBlueprint_Factory implements Factory<ShopSettingsTitleSubtitleItemBlueprint> {
    public final Provider<ShopSettingsTitleSubtitleItemPresenter> a;

    public ShopSettingsTitleSubtitleItemBlueprint_Factory(Provider<ShopSettingsTitleSubtitleItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsTitleSubtitleItemBlueprint_Factory create(Provider<ShopSettingsTitleSubtitleItemPresenter> provider) {
        return new ShopSettingsTitleSubtitleItemBlueprint_Factory(provider);
    }

    public static ShopSettingsTitleSubtitleItemBlueprint newInstance(ShopSettingsTitleSubtitleItemPresenter shopSettingsTitleSubtitleItemPresenter) {
        return new ShopSettingsTitleSubtitleItemBlueprint(shopSettingsTitleSubtitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsTitleSubtitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
