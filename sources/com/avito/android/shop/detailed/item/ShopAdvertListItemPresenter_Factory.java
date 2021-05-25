package com.avito.android.shop.detailed.item;

import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.shop.detailed.ShopItemVisibilityRecorder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopAdvertListItemPresenter_Factory implements Factory<ShopAdvertListItemPresenter> {
    public final Provider<AdvertListItemPresenter> a;
    public final Provider<ShopItemVisibilityRecorder> b;

    public ShopAdvertListItemPresenter_Factory(Provider<AdvertListItemPresenter> provider, Provider<ShopItemVisibilityRecorder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopAdvertListItemPresenter_Factory create(Provider<AdvertListItemPresenter> provider, Provider<ShopItemVisibilityRecorder> provider2) {
        return new ShopAdvertListItemPresenter_Factory(provider, provider2);
    }

    public static ShopAdvertListItemPresenter newInstance(AdvertListItemPresenter advertListItemPresenter, ShopItemVisibilityRecorder shopItemVisibilityRecorder) {
        return new ShopAdvertListItemPresenter(advertListItemPresenter, shopItemVisibilityRecorder);
    }

    @Override // javax.inject.Provider
    public ShopAdvertListItemPresenter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
