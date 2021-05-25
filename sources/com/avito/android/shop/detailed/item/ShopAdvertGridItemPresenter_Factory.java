package com.avito.android.shop.detailed.item;

import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.shop.detailed.ShopItemVisibilityRecorder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopAdvertGridItemPresenter_Factory implements Factory<ShopAdvertGridItemPresenter> {
    public final Provider<AdvertGridItemPresenter> a;
    public final Provider<ShopItemVisibilityRecorder> b;

    public ShopAdvertGridItemPresenter_Factory(Provider<AdvertGridItemPresenter> provider, Provider<ShopItemVisibilityRecorder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopAdvertGridItemPresenter_Factory create(Provider<AdvertGridItemPresenter> provider, Provider<ShopItemVisibilityRecorder> provider2) {
        return new ShopAdvertGridItemPresenter_Factory(provider, provider2);
    }

    public static ShopAdvertGridItemPresenter newInstance(AdvertGridItemPresenter advertGridItemPresenter, ShopItemVisibilityRecorder shopItemVisibilityRecorder) {
        return new ShopAdvertGridItemPresenter(advertGridItemPresenter, shopItemVisibilityRecorder);
    }

    @Override // javax.inject.Provider
    public ShopAdvertGridItemPresenter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
