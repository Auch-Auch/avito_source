package com.avito.android.shop.detailed.item;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSubscriptionsResourceProvider_Factory implements Factory<ShopSubscriptionsResourceProvider> {
    public final Provider<Resources> a;

    public ShopSubscriptionsResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ShopSubscriptionsResourceProvider_Factory create(Provider<Resources> provider) {
        return new ShopSubscriptionsResourceProvider_Factory(provider);
    }

    public static ShopSubscriptionsResourceProvider newInstance(Resources resources) {
        return new ShopSubscriptionsResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public ShopSubscriptionsResourceProvider get() {
        return newInstance(this.a.get());
    }
}
