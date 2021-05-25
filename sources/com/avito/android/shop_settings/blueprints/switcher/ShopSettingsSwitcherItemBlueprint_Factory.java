package com.avito.android.shop_settings.blueprints.switcher;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSwitcherItemBlueprint_Factory implements Factory<ShopSettingsSwitcherItemBlueprint> {
    public final Provider<ShopSettingsSwitcherItemPresenter> a;

    public ShopSettingsSwitcherItemBlueprint_Factory(Provider<ShopSettingsSwitcherItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSwitcherItemBlueprint_Factory create(Provider<ShopSettingsSwitcherItemPresenter> provider) {
        return new ShopSettingsSwitcherItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSwitcherItemBlueprint newInstance(ShopSettingsSwitcherItemPresenter shopSettingsSwitcherItemPresenter) {
        return new ShopSettingsSwitcherItemBlueprint(shopSettingsSwitcherItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSwitcherItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
