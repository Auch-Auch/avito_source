package com.avito.android.advert.item.sellerprofile;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerStatusProviderImpl_Factory implements Factory<SellerStatusProviderImpl> {
    public final Provider<AdvertSellerStatusInteractor> a;
    public final Provider<Resources> b;

    public SellerStatusProviderImpl_Factory(Provider<AdvertSellerStatusInteractor> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SellerStatusProviderImpl_Factory create(Provider<AdvertSellerStatusInteractor> provider, Provider<Resources> provider2) {
        return new SellerStatusProviderImpl_Factory(provider, provider2);
    }

    public static SellerStatusProviderImpl newInstance(AdvertSellerStatusInteractor advertSellerStatusInteractor, Resources resources) {
        return new SellerStatusProviderImpl(advertSellerStatusInteractor, resources);
    }

    @Override // javax.inject.Provider
    public SellerStatusProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
