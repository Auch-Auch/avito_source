package com.avito.android.shop_settings_select;

import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class ShopSettingsSelectConverterImpl_Factory implements Factory<ShopSettingsSelectConverterImpl> {
    public final Provider<List<String>> a;

    public ShopSettingsSelectConverterImpl_Factory(Provider<List<String>> provider) {
        this.a = provider;
    }

    public static ShopSettingsSelectConverterImpl_Factory create(Provider<List<String>> provider) {
        return new ShopSettingsSelectConverterImpl_Factory(provider);
    }

    public static ShopSettingsSelectConverterImpl newInstance(List<String> list) {
        return new ShopSettingsSelectConverterImpl(list);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectConverterImpl get() {
        return newInstance(this.a.get());
    }
}
