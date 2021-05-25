package com.avito.android.shop_settings_select;

import com.avito.android.remote.ShopSettingsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSelectRepositoryImpl_Factory implements Factory<ShopSettingsSelectRepositoryImpl> {
    public final Provider<ShopSettingsApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<String> c;
    public final Provider<String> d;

    public ShopSettingsSelectRepositoryImpl_Factory(Provider<ShopSettingsApi> provider, Provider<SchedulersFactory> provider2, Provider<String> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ShopSettingsSelectRepositoryImpl_Factory create(Provider<ShopSettingsApi> provider, Provider<SchedulersFactory> provider2, Provider<String> provider3, Provider<String> provider4) {
        return new ShopSettingsSelectRepositoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ShopSettingsSelectRepositoryImpl newInstance(ShopSettingsApi shopSettingsApi, SchedulersFactory schedulersFactory, String str, String str2) {
        return new ShopSettingsSelectRepositoryImpl(shopSettingsApi, schedulersFactory, str, str2);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
