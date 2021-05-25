package com.avito.android.shop_settings.blueprints.input.multi_line_input;

import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsMultiLineInputItemBlueprint_Factory implements Factory<ShopSettingsMultiLineInputItemBlueprint> {
    public final Provider<ShopSettingsInputItemPresenter> a;

    public ShopSettingsMultiLineInputItemBlueprint_Factory(Provider<ShopSettingsInputItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopSettingsMultiLineInputItemBlueprint_Factory create(Provider<ShopSettingsInputItemPresenter> provider) {
        return new ShopSettingsMultiLineInputItemBlueprint_Factory(provider);
    }

    public static ShopSettingsMultiLineInputItemBlueprint newInstance(ShopSettingsInputItemPresenter shopSettingsInputItemPresenter) {
        return new ShopSettingsMultiLineInputItemBlueprint(shopSettingsInputItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsMultiLineInputItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
