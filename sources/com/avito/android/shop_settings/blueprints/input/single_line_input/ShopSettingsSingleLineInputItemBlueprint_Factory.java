package com.avito.android.shop_settings.blueprints.input.single_line_input;

import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSingleLineInputItemBlueprint_Factory implements Factory<ShopSettingsSingleLineInputItemBlueprint> {
    public final Provider<ShopSettingsInputItemPresenter> a;

    public ShopSettingsSingleLineInputItemBlueprint_Factory(Provider<ShopSettingsInputItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsSingleLineInputItemBlueprint_Factory create(Provider<ShopSettingsInputItemPresenter> provider) {
        return new ShopSettingsSingleLineInputItemBlueprint_Factory(provider);
    }

    public static ShopSettingsSingleLineInputItemBlueprint newInstance(ShopSettingsInputItemPresenter shopSettingsInputItemPresenter) {
        return new ShopSettingsSingleLineInputItemBlueprint(shopSettingsInputItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSingleLineInputItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
