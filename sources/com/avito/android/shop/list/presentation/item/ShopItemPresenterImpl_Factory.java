package com.avito.android.shop.list.presentation.item;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopItemPresenterImpl_Factory implements Factory<ShopItemPresenterImpl> {
    public final Provider<ShopClickListener> a;

    public ShopItemPresenterImpl_Factory(Provider<ShopClickListener> provider) {
        this.a = provider;
    }

    public static ShopItemPresenterImpl_Factory create(Provider<ShopClickListener> provider) {
        return new ShopItemPresenterImpl_Factory(provider);
    }

    public static ShopItemPresenterImpl newInstance(Lazy<ShopClickListener> lazy) {
        return new ShopItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public ShopItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
