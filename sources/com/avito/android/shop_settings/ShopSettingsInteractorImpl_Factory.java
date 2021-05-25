package com.avito.android.shop_settings;

import com.avito.android.remote.ShopSettingsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsInteractorImpl_Factory implements Factory<ShopSettingsInteractorImpl> {
    public final Provider<ShopSettingsApi> a;
    public final Provider<SchedulersFactory> b;

    public ShopSettingsInteractorImpl_Factory(Provider<ShopSettingsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopSettingsInteractorImpl_Factory create(Provider<ShopSettingsApi> provider, Provider<SchedulersFactory> provider2) {
        return new ShopSettingsInteractorImpl_Factory(provider, provider2);
    }

    public static ShopSettingsInteractorImpl newInstance(ShopSettingsApi shopSettingsApi, SchedulersFactory schedulersFactory) {
        return new ShopSettingsInteractorImpl(shopSettingsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ShopSettingsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
