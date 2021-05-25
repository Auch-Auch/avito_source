package com.avito.android.shop_settings_select;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSelectViewModelFactory_Factory implements Factory<ShopSettingsSelectViewModelFactory> {
    public final Provider<ShopSettingsSelectRepository> a;
    public final Provider<ShopSettingsSelectConverter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Kundle> d;

    public ShopSettingsSelectViewModelFactory_Factory(Provider<ShopSettingsSelectRepository> provider, Provider<ShopSettingsSelectConverter> provider2, Provider<SchedulersFactory> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ShopSettingsSelectViewModelFactory_Factory create(Provider<ShopSettingsSelectRepository> provider, Provider<ShopSettingsSelectConverter> provider2, Provider<SchedulersFactory> provider3, Provider<Kundle> provider4) {
        return new ShopSettingsSelectViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static ShopSettingsSelectViewModelFactory newInstance(ShopSettingsSelectRepository shopSettingsSelectRepository, ShopSettingsSelectConverter shopSettingsSelectConverter, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new ShopSettingsSelectViewModelFactory(shopSettingsSelectRepository, shopSettingsSelectConverter, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
