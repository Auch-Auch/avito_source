package com.avito.android.shop.list.presentation.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopItemBlueprint_Factory implements Factory<ShopItemBlueprint> {
    public final Provider<ShopItemPresenter> a;

    public ShopItemBlueprint_Factory(Provider<ShopItemPresenter> provider) {
        this.a = provider;
    }

    public static ShopItemBlueprint_Factory create(Provider<ShopItemPresenter> provider) {
        return new ShopItemBlueprint_Factory(provider);
    }

    public static ShopItemBlueprint newInstance(ShopItemPresenter shopItemPresenter) {
        return new ShopItemBlueprint(shopItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShopItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
