package com.avito.android.advert.item.sellersubscription;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerSubscriptionResourceProviderImpl_Factory implements Factory<SellerSubscriptionResourceProviderImpl> {
    public final Provider<Resources> a;

    public SellerSubscriptionResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SellerSubscriptionResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SellerSubscriptionResourceProviderImpl_Factory(provider);
    }

    public static SellerSubscriptionResourceProviderImpl newInstance(Resources resources) {
        return new SellerSubscriptionResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SellerSubscriptionResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
