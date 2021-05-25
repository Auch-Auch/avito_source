package com.avito.android.advert.item.sellerprofile;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSellerProfileBlueprint_Factory implements Factory<AdvertDetailsSellerProfileBlueprint> {
    public final Provider<AdvertDetailsSellerProfilePresenter> a;

    public AdvertDetailsSellerProfileBlueprint_Factory(Provider<AdvertDetailsSellerProfilePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSellerProfileBlueprint_Factory create(Provider<AdvertDetailsSellerProfilePresenter> provider) {
        return new AdvertDetailsSellerProfileBlueprint_Factory(provider);
    }

    public static AdvertDetailsSellerProfileBlueprint newInstance(AdvertDetailsSellerProfilePresenter advertDetailsSellerProfilePresenter) {
        return new AdvertDetailsSellerProfileBlueprint(advertDetailsSellerProfilePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSellerProfileBlueprint get() {
        return newInstance(this.a.get());
    }
}
