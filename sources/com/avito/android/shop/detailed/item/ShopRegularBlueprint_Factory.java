package com.avito.android.shop.detailed.item;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopRegularBlueprint_Factory implements Factory<ShopRegularBlueprint> {
    public final Provider<ShopRegularItemPresenter> a;
    public final Provider<Features> b;

    public ShopRegularBlueprint_Factory(Provider<ShopRegularItemPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopRegularBlueprint_Factory create(Provider<ShopRegularItemPresenter> provider, Provider<Features> provider2) {
        return new ShopRegularBlueprint_Factory(provider, provider2);
    }

    public static ShopRegularBlueprint newInstance(ShopRegularItemPresenter shopRegularItemPresenter, Features features) {
        return new ShopRegularBlueprint(shopRegularItemPresenter, features);
    }

    @Override // javax.inject.Provider
    public ShopRegularBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
