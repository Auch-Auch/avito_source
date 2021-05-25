package com.avito.android.shop_settings;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsStringProviderImpl_Factory implements Factory<ShopSettingsStringProviderImpl> {
    public final Provider<Resources> a;

    public ShopSettingsStringProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ShopSettingsStringProviderImpl_Factory create(Provider<Resources> provider) {
        return new ShopSettingsStringProviderImpl_Factory(provider);
    }

    public static ShopSettingsStringProviderImpl newInstance(Resources resources) {
        return new ShopSettingsStringProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ShopSettingsStringProviderImpl get() {
        return newInstance(this.a.get());
    }
}
