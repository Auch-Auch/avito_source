package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.ShopSettingsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopSettingsApiModule_ProvideShopSettingsApiFactory implements Factory<ShopSettingsApi> {
    public final Provider<RetrofitFactory> a;

    public ShopSettingsApiModule_ProvideShopSettingsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ShopSettingsApiModule_ProvideShopSettingsApiFactory create(Provider<RetrofitFactory> provider) {
        return new ShopSettingsApiModule_ProvideShopSettingsApiFactory(provider);
    }

    public static ShopSettingsApi provideShopSettingsApi(RetrofitFactory retrofitFactory) {
        return (ShopSettingsApi) Preconditions.checkNotNullFromProvides(ShopSettingsApiModule.INSTANCE.provideShopSettingsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ShopSettingsApi get() {
        return provideShopSettingsApi(this.a.get());
    }
}
