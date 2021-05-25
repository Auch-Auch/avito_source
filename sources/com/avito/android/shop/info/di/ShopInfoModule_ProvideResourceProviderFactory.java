package com.avito.android.shop.info.di;

import com.avito.android.shop.info.ShopInfoResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ShopInfoModule_ProvideResourceProviderFactory implements Factory<ShopInfoResourceProvider> {
    public final ShopInfoModule a;

    public ShopInfoModule_ProvideResourceProviderFactory(ShopInfoModule shopInfoModule) {
        this.a = shopInfoModule;
    }

    public static ShopInfoModule_ProvideResourceProviderFactory create(ShopInfoModule shopInfoModule) {
        return new ShopInfoModule_ProvideResourceProviderFactory(shopInfoModule);
    }

    public static ShopInfoResourceProvider provideResourceProvider(ShopInfoModule shopInfoModule) {
        return (ShopInfoResourceProvider) Preconditions.checkNotNullFromProvides(shopInfoModule.provideResourceProvider());
    }

    @Override // javax.inject.Provider
    public ShopInfoResourceProvider get() {
        return provideResourceProvider(this.a);
    }
}
