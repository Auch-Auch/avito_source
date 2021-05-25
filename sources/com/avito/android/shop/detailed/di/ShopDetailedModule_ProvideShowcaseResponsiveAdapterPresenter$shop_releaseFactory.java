package com.avito.android.shop.detailed.di;

import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopDetailedModule_ProvideShowcaseResponsiveAdapterPresenter$shop_releaseFactory implements Factory<ResponsiveAdapterPresenter> {
    public final ShopDetailedModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<CallableResponsiveItemPresenterRegistry> c;

    public ShopDetailedModule_ProvideShowcaseResponsiveAdapterPresenter$shop_releaseFactory(ShopDetailedModule shopDetailedModule, Provider<AdapterPresenter> provider, Provider<CallableResponsiveItemPresenterRegistry> provider2) {
        this.a = shopDetailedModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ShopDetailedModule_ProvideShowcaseResponsiveAdapterPresenter$shop_releaseFactory create(ShopDetailedModule shopDetailedModule, Provider<AdapterPresenter> provider, Provider<CallableResponsiveItemPresenterRegistry> provider2) {
        return new ShopDetailedModule_ProvideShowcaseResponsiveAdapterPresenter$shop_releaseFactory(shopDetailedModule, provider, provider2);
    }

    public static ResponsiveAdapterPresenter provideShowcaseResponsiveAdapterPresenter$shop_release(ShopDetailedModule shopDetailedModule, AdapterPresenter adapterPresenter, CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        return (ResponsiveAdapterPresenter) Preconditions.checkNotNullFromProvides(shopDetailedModule.provideShowcaseResponsiveAdapterPresenter$shop_release(adapterPresenter, callableResponsiveItemPresenterRegistry));
    }

    @Override // javax.inject.Provider
    public ResponsiveAdapterPresenter get() {
        return provideShowcaseResponsiveAdapterPresenter$shop_release(this.a, this.b.get(), this.c.get());
    }
}
