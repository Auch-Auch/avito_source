package com.avito.android.shop.detailed;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopAdvertsResourceProviderImpl_Factory implements Factory<ShopAdvertsResourceProviderImpl> {
    public final Provider<Resources> a;

    public ShopAdvertsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ShopAdvertsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ShopAdvertsResourceProviderImpl_Factory(provider);
    }

    public static ShopAdvertsResourceProviderImpl newInstance(Resources resources) {
        return new ShopAdvertsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ShopAdvertsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
