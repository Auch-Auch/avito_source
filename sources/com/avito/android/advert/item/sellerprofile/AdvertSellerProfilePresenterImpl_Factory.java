package com.avito.android.advert.item.sellerprofile;

import com.avito.android.Features;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertSellerProfilePresenterImpl_Factory implements Factory<AdvertSellerProfilePresenterImpl> {
    public final Provider<AdvertDetailsResourcesProvider> a;
    public final Provider<Features> b;

    public AdvertSellerProfilePresenterImpl_Factory(Provider<AdvertDetailsResourcesProvider> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertSellerProfilePresenterImpl_Factory create(Provider<AdvertDetailsResourcesProvider> provider, Provider<Features> provider2) {
        return new AdvertSellerProfilePresenterImpl_Factory(provider, provider2);
    }

    public static AdvertSellerProfilePresenterImpl newInstance(AdvertDetailsResourcesProvider advertDetailsResourcesProvider, Features features) {
        return new AdvertSellerProfilePresenterImpl(advertDetailsResourcesProvider, features);
    }

    @Override // javax.inject.Provider
    public AdvertSellerProfilePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
