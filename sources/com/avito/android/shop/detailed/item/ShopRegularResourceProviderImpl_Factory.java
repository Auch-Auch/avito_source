package com.avito.android.shop.detailed.item;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopRegularResourceProviderImpl_Factory implements Factory<ShopRegularResourceProviderImpl> {
    public final Provider<Context> a;

    public ShopRegularResourceProviderImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ShopRegularResourceProviderImpl_Factory create(Provider<Context> provider) {
        return new ShopRegularResourceProviderImpl_Factory(provider);
    }

    public static ShopRegularResourceProviderImpl newInstance(Context context) {
        return new ShopRegularResourceProviderImpl(context);
    }

    @Override // javax.inject.Provider
    public ShopRegularResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
