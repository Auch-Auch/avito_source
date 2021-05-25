package com.avito.android.shop_settings.blueprints.alert;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsAlertItemBlueprint_Factory implements Factory<ShopSettingsAlertItemBlueprint> {
    public final Provider<ShopSettingsAlertItemPresenter> a;

    public ShopSettingsAlertItemBlueprint_Factory(Provider<ShopSettingsAlertItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsAlertItemBlueprint_Factory create(Provider<ShopSettingsAlertItemPresenter> provider) {
        return new ShopSettingsAlertItemBlueprint_Factory(provider);
    }

    public static ShopSettingsAlertItemBlueprint newInstance(ShopSettingsAlertItemPresenter shopSettingsAlertItemPresenter) {
        return new ShopSettingsAlertItemBlueprint(shopSettingsAlertItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsAlertItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
