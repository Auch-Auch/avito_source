package com.avito.android.shop_settings.blueprints.separator;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSeparatorItemBlueprint_Factory implements Factory<ShopSettingsSeparatorItemBlueprint> {
    public final Provider<ShopSettingsSeparatorItemPresenter> a;

    public ShopSettingsSeparatorItemBlueprint_Factory(Provider<ShopSettingsSeparatorItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSeparatorItemBlueprint_Factory create(Provider<ShopSettingsSeparatorItemPresenter> provider) {
        return new ShopSettingsSeparatorItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSeparatorItemBlueprint newInstance(ShopSettingsSeparatorItemPresenter shopSettingsSeparatorItemPresenter) {
        return new ShopSettingsSeparatorItemBlueprint(shopSettingsSeparatorItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSeparatorItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
