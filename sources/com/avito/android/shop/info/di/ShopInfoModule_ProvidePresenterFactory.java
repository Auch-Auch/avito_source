package com.avito.android.shop.info.di;

import com.avito.android.shop.info.ShopInfoInteractor;
import com.avito.android.shop.info.ShopInfoPresenter;
import com.avito.android.shop.info.ShopInfoResourceProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopInfoModule_ProvidePresenterFactory implements Factory<ShopInfoPresenter> {
    public final ShopInfoModule a;
    public final Provider<ShopInfoInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ShopInfoResourceProvider> d;

    public ShopInfoModule_ProvidePresenterFactory(ShopInfoModule shopInfoModule, Provider<ShopInfoInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ShopInfoResourceProvider> provider3) {
        this.a = shopInfoModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ShopInfoModule_ProvidePresenterFactory create(ShopInfoModule shopInfoModule, Provider<ShopInfoInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ShopInfoResourceProvider> provider3) {
        return new ShopInfoModule_ProvidePresenterFactory(shopInfoModule, provider, provider2, provider3);
    }

    public static ShopInfoPresenter providePresenter(ShopInfoModule shopInfoModule, ShopInfoInteractor shopInfoInteractor, SchedulersFactory3 schedulersFactory3, ShopInfoResourceProvider shopInfoResourceProvider) {
        return (ShopInfoPresenter) Preconditions.checkNotNullFromProvides(shopInfoModule.providePresenter(shopInfoInteractor, schedulersFactory3, shopInfoResourceProvider));
    }

    @Override // javax.inject.Provider
    public ShopInfoPresenter get() {
        return providePresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
