package com.avito.android.advert.item.sellerprofile;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSellerProfilePresenterImpl_Factory implements Factory<AdvertDetailsSellerProfilePresenterImpl> {
    public final Provider<AdvertSellerPresenter> a;

    public AdvertDetailsSellerProfilePresenterImpl_Factory(Provider<AdvertSellerPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSellerProfilePresenterImpl_Factory create(Provider<AdvertSellerPresenter> provider) {
        return new AdvertDetailsSellerProfilePresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSellerProfilePresenterImpl newInstance(AdvertSellerPresenter advertSellerPresenter) {
        return new AdvertDetailsSellerProfilePresenterImpl(advertSellerPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSellerProfilePresenterImpl get() {
        return newInstance(this.a.get());
    }
}
