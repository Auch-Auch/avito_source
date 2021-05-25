package com.avito.android.advert.item.sellerprofile;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertSellerStatusInteractorImpl_Factory implements Factory<AdvertSellerStatusInteractorImpl> {
    public final Provider<AdvertDetailsApi> a;
    public final Provider<SchedulersFactory3> b;

    public AdvertSellerStatusInteractorImpl_Factory(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertSellerStatusInteractorImpl_Factory create(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new AdvertSellerStatusInteractorImpl_Factory(provider, provider2);
    }

    public static AdvertSellerStatusInteractorImpl newInstance(AdvertDetailsApi advertDetailsApi, SchedulersFactory3 schedulersFactory3) {
        return new AdvertSellerStatusInteractorImpl(advertDetailsApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AdvertSellerStatusInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
