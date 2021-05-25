package com.avito.android.shop_settings_select.blueprints.shop_settings_selection;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSelectionItemBlueprint_Factory implements Factory<ShopSettingsSelectionItemBlueprint> {
    public final Provider<ShopSettingsSelectionItemPresenter> a;

    public ShopSettingsSelectionItemBlueprint_Factory(Provider<ShopSettingsSelectionItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSelectionItemBlueprint_Factory create(Provider<ShopSettingsSelectionItemPresenter> provider) {
        return new ShopSettingsSelectionItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSelectionItemBlueprint newInstance(ShopSettingsSelectionItemPresenter shopSettingsSelectionItemPresenter) {
        return new ShopSettingsSelectionItemBlueprint(shopSettingsSelectionItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
