package com.avito.android.shop.detailed.di;

import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopDetailedModule_ProvideShowcaseCallableResponsiveItemPresenterRegistry$shop_releaseFactory implements Factory<CallableResponsiveItemPresenterRegistry> {
    public final ShopDetailedModule a;
    public final Provider<ShowcaseItemPresenter> b;

    public ShopDetailedModule_ProvideShowcaseCallableResponsiveItemPresenterRegistry$shop_releaseFactory(ShopDetailedModule shopDetailedModule, Provider<ShowcaseItemPresenter> provider) {
        this.a = shopDetailedModule;
        this.b = provider;
    }

    public static ShopDetailedModule_ProvideShowcaseCallableResponsiveItemPresenterRegistry$shop_releaseFactory create(ShopDetailedModule shopDetailedModule, Provider<ShowcaseItemPresenter> provider) {
        return new ShopDetailedModule_ProvideShowcaseCallableResponsiveItemPresenterRegistry$shop_releaseFactory(shopDetailedModule, provider);
    }

    public static CallableResponsiveItemPresenterRegistry provideShowcaseCallableResponsiveItemPresenterRegistry$shop_release(ShopDetailedModule shopDetailedModule, ShowcaseItemPresenter showcaseItemPresenter) {
        return (CallableResponsiveItemPresenterRegistry) Preconditions.checkNotNullFromProvides(shopDetailedModule.provideShowcaseCallableResponsiveItemPresenterRegistry$shop_release(showcaseItemPresenter));
    }

    @Override // javax.inject.Provider
    public CallableResponsiveItemPresenterRegistry get() {
        return provideShowcaseCallableResponsiveItemPresenterRegistry$shop_release(this.a, this.b.get());
    }
}
