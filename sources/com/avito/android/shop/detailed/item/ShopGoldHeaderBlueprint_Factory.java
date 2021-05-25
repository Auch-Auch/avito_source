package com.avito.android.shop.detailed.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopGoldHeaderBlueprint_Factory implements Factory<ShopGoldHeaderBlueprint> {
    public final Provider<ShopGoldHeaderItemPresenter> a;

    public ShopGoldHeaderBlueprint_Factory(Provider<ShopGoldHeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopGoldHeaderBlueprint_Factory create(Provider<ShopGoldHeaderItemPresenter> provider) {
        return new ShopGoldHeaderBlueprint_Factory(provider);
    }

    public static ShopGoldHeaderBlueprint newInstance(ShopGoldHeaderItemPresenter shopGoldHeaderItemPresenter) {
        return new ShopGoldHeaderBlueprint(shopGoldHeaderItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopGoldHeaderBlueprint get() {
        return newInstance(this.a.get());
    }
}
