package com.avito.android.shop_settings.blueprints.form_title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsFormTitleItemBlueprint_Factory implements Factory<ShopSettingsFormTitleItemBlueprint> {
    public final Provider<ShopSettingsFormTitleItemPresenter> a;

    public ShopSettingsFormTitleItemBlueprint_Factory(Provider<ShopSettingsFormTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsFormTitleItemBlueprint_Factory create(Provider<ShopSettingsFormTitleItemPresenter> provider) {
        return new ShopSettingsFormTitleItemBlueprint_Factory(provider);
    }

    public static ShopSettingsFormTitleItemBlueprint newInstance(ShopSettingsFormTitleItemPresenter shopSettingsFormTitleItemPresenter) {
        return new ShopSettingsFormTitleItemBlueprint(shopSettingsFormTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsFormTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
