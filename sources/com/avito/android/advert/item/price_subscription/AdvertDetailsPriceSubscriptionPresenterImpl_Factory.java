package com.avito.android.advert.item.price_subscription;

import dagger.internal.Factory;
public final class AdvertDetailsPriceSubscriptionPresenterImpl_Factory implements Factory<AdvertDetailsPriceSubscriptionPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsPriceSubscriptionPresenterImpl_Factory a = new AdvertDetailsPriceSubscriptionPresenterImpl_Factory();
    }

    public static AdvertDetailsPriceSubscriptionPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsPriceSubscriptionPresenterImpl newInstance() {
        return new AdvertDetailsPriceSubscriptionPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPriceSubscriptionPresenterImpl get() {
        return newInstance();
    }
}
