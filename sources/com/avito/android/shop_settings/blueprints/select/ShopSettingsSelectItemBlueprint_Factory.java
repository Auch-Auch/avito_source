package com.avito.android.shop_settings.blueprints.select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSelectItemBlueprint_Factory implements Factory<ShopSettingsSelectItemBlueprint> {
    public final Provider<ShopSettingsSelectItemPresenter> a;

    public ShopSettingsSelectItemBlueprint_Factory(Provider<ShopSettingsSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSelectItemBlueprint_Factory create(Provider<ShopSettingsSelectItemPresenter> provider) {
        return new ShopSettingsSelectItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSelectItemBlueprint newInstance(ShopSettingsSelectItemPresenter shopSettingsSelectItemPresenter) {
        return new ShopSettingsSelectItemBlueprint(shopSettingsSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
