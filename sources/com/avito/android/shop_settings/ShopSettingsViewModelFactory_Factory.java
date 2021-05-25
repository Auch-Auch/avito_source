package com.avito.android.shop_settings;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsViewModelFactory_Factory implements Factory<ShopSettingsViewModelFactory> {
    public final Provider<ShopSettingsConverter> a;
    public final Provider<ShopSettingsInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ShopSettingsStringProvider> d;
    public final Provider<Kundle> e;
    public final Provider<AccountStateProvider> f;

    public ShopSettingsViewModelFactory_Factory(Provider<ShopSettingsConverter> provider, Provider<ShopSettingsInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<ShopSettingsStringProvider> provider4, Provider<Kundle> provider5, Provider<AccountStateProvider> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ShopSettingsViewModelFactory_Factory create(Provider<ShopSettingsConverter> provider, Provider<ShopSettingsInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<ShopSettingsStringProvider> provider4, Provider<Kundle> provider5, Provider<AccountStateProvider> provider6) {
        return new ShopSettingsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ShopSettingsViewModelFactory newInstance(ShopSettingsConverter shopSettingsConverter, ShopSettingsInteractor shopSettingsInteractor, SchedulersFactory schedulersFactory, ShopSettingsStringProvider shopSettingsStringProvider, Kundle kundle, AccountStateProvider accountStateProvider) {
        return new ShopSettingsViewModelFactory(shopSettingsConverter, shopSettingsInteractor, schedulersFactory, shopSettingsStringProvider, kundle, accountStateProvider);
    }

    @Override // javax.inject.Provider
    public ShopSettingsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
