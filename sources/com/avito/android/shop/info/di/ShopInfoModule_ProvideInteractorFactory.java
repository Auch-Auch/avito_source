package com.avito.android.shop.info.di;

import com.avito.android.shop.info.ShopInfoInteractor;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopInfoModule_ProvideInteractorFactory implements Factory<ShopInfoInteractor> {
    public final ShopInfoModule a;
    public final Provider<ShopsApi> b;
    public final Provider<SchedulersFactory3> c;

    public ShopInfoModule_ProvideInteractorFactory(ShopInfoModule shopInfoModule, Provider<ShopsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = shopInfoModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ShopInfoModule_ProvideInteractorFactory create(ShopInfoModule shopInfoModule, Provider<ShopsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new ShopInfoModule_ProvideInteractorFactory(shopInfoModule, provider, provider2);
    }

    public static ShopInfoInteractor provideInteractor(ShopInfoModule shopInfoModule, ShopsApi shopsApi, SchedulersFactory3 schedulersFactory3) {
        return (ShopInfoInteractor) Preconditions.checkNotNullFromProvides(shopInfoModule.provideInteractor(shopsApi, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ShopInfoInteractor get() {
        return provideInteractor(this.a, this.b.get(), this.c.get());
    }
}
