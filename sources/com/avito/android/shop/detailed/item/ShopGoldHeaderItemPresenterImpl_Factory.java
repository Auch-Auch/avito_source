package com.avito.android.shop.detailed.item;

import com.avito.android.shop.detailed.ShopDetailedImageHeightProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopGoldHeaderItemPresenterImpl_Factory implements Factory<ShopGoldHeaderItemPresenterImpl> {
    public final Provider<ShopDetailedImageHeightProvider> a;

    public ShopGoldHeaderItemPresenterImpl_Factory(Provider<ShopDetailedImageHeightProvider> provider) {
        this.a = provider;
    }

    public static ShopGoldHeaderItemPresenterImpl_Factory create(Provider<ShopDetailedImageHeightProvider> provider) {
        return new ShopGoldHeaderItemPresenterImpl_Factory(provider);
    }

    public static ShopGoldHeaderItemPresenterImpl newInstance(ShopDetailedImageHeightProvider shopDetailedImageHeightProvider) {
        return new ShopGoldHeaderItemPresenterImpl(shopDetailedImageHeightProvider);
    }

    @Override // javax.inject.Provider
    public ShopGoldHeaderItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
