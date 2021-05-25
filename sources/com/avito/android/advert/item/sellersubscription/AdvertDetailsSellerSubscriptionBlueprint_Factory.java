package com.avito.android.advert.item.sellersubscription;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSellerSubscriptionBlueprint_Factory implements Factory<AdvertDetailsSellerSubscriptionBlueprint> {
    public final Provider<AdvertDetailsSellerSubscriptionPresenter> a;
    public final Provider<SellerSubscriptionResourceProvider> b;

    public AdvertDetailsSellerSubscriptionBlueprint_Factory(Provider<AdvertDetailsSellerSubscriptionPresenter> provider, Provider<SellerSubscriptionResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsSellerSubscriptionBlueprint_Factory create(Provider<AdvertDetailsSellerSubscriptionPresenter> provider, Provider<SellerSubscriptionResourceProvider> provider2) {
        return new AdvertDetailsSellerSubscriptionBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsSellerSubscriptionBlueprint newInstance(AdvertDetailsSellerSubscriptionPresenter advertDetailsSellerSubscriptionPresenter, SellerSubscriptionResourceProvider sellerSubscriptionResourceProvider) {
        return new AdvertDetailsSellerSubscriptionBlueprint(advertDetailsSellerSubscriptionPresenter, sellerSubscriptionResourceProvider);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSellerSubscriptionBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
