package com.avito.android.shop_settings.blueprints.moderation_error;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsModerationErrorItemBlueprint_Factory implements Factory<ShopSettingsModerationErrorItemBlueprint> {
    public final Provider<ShopSettingsModerationErrorItemPresenter> a;

    public ShopSettingsModerationErrorItemBlueprint_Factory(Provider<ShopSettingsModerationErrorItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsModerationErrorItemBlueprint_Factory create(Provider<ShopSettingsModerationErrorItemPresenter> provider) {
        return new ShopSettingsModerationErrorItemBlueprint_Factory(provider);
    }

    public static ShopSettingsModerationErrorItemBlueprint newInstance(ShopSettingsModerationErrorItemPresenter shopSettingsModerationErrorItemPresenter) {
        return new ShopSettingsModerationErrorItemBlueprint(shopSettingsModerationErrorItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsModerationErrorItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
