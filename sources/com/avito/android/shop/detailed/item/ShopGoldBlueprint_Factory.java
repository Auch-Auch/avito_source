package com.avito.android.shop.detailed.item;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopGoldBlueprint_Factory implements Factory<ShopGoldBlueprint> {
    public final Provider<ShopGoldItemPresenter> a;
    public final Provider<Features> b;

    public ShopGoldBlueprint_Factory(Provider<ShopGoldItemPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopGoldBlueprint_Factory create(Provider<ShopGoldItemPresenter> provider, Provider<Features> provider2) {
        return new ShopGoldBlueprint_Factory(provider, provider2);
    }

    public static ShopGoldBlueprint newInstance(ShopGoldItemPresenter shopGoldItemPresenter, Features features) {
        return new ShopGoldBlueprint(shopGoldItemPresenter, features);
    }

    @Override // javax.inject.Provider
    public ShopGoldBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
