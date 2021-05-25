package com.avito.android.shop.detailed.item;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopGoldResourceProviderImpl_Factory implements Factory<ShopGoldResourceProviderImpl> {
    public final Provider<Context> a;

    public ShopGoldResourceProviderImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ShopGoldResourceProviderImpl_Factory create(Provider<Context> provider) {
        return new ShopGoldResourceProviderImpl_Factory(provider);
    }

    public static ShopGoldResourceProviderImpl newInstance(Context context) {
        return new ShopGoldResourceProviderImpl(context);
    }

    @Override // javax.inject.Provider
    public ShopGoldResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
