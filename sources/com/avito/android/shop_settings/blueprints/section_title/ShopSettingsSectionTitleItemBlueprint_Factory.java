package com.avito.android.shop_settings.blueprints.section_title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSectionTitleItemBlueprint_Factory implements Factory<ShopSettingsSectionTitleItemBlueprint> {
    public final Provider<ShopSettingsSectionTitleItemPresenter> a;

    public ShopSettingsSectionTitleItemBlueprint_Factory(Provider<ShopSettingsSectionTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSectionTitleItemBlueprint_Factory create(Provider<ShopSettingsSectionTitleItemPresenter> provider) {
        return new ShopSettingsSectionTitleItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSectionTitleItemBlueprint newInstance(ShopSettingsSectionTitleItemPresenter shopSettingsSectionTitleItemPresenter) {
        return new ShopSettingsSectionTitleItemBlueprint(shopSettingsSectionTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSectionTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
