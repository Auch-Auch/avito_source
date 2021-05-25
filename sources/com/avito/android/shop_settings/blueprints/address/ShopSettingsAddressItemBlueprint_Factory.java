package com.avito.android.shop_settings.blueprints.address;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsAddressItemBlueprint_Factory implements Factory<ShopSettingsAddressItemBlueprint> {
    public final Provider<ShopSettingsAddressItemPresenter> a;

    public ShopSettingsAddressItemBlueprint_Factory(Provider<ShopSettingsAddressItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsAddressItemBlueprint_Factory create(Provider<ShopSettingsAddressItemPresenter> provider) {
        return new ShopSettingsAddressItemBlueprint_Factory(provider);
    }

    public static ShopSettingsAddressItemBlueprint newInstance(ShopSettingsAddressItemPresenter shopSettingsAddressItemPresenter) {
        return new ShopSettingsAddressItemBlueprint(shopSettingsAddressItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsAddressItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
