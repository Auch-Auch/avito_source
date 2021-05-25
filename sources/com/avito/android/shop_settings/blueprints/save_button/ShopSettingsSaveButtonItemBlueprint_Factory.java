package com.avito.android.shop_settings.blueprints.save_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSaveButtonItemBlueprint_Factory implements Factory<ShopSettingsSaveButtonItemBlueprint> {
    public final Provider<ShopSettingsSaveButtonItemPresenter> a;

    public ShopSettingsSaveButtonItemBlueprint_Factory(Provider<ShopSettingsSaveButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSaveButtonItemBlueprint_Factory create(Provider<ShopSettingsSaveButtonItemPresenter> provider) {
        return new ShopSettingsSaveButtonItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSaveButtonItemBlueprint newInstance(ShopSettingsSaveButtonItemPresenter shopSettingsSaveButtonItemPresenter) {
        return new ShopSettingsSaveButtonItemBlueprint(shopSettingsSaveButtonItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSaveButtonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
