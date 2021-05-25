package com.avito.android.advert.item.price_marketplace;

import dagger.internal.Factory;
public final class AdvertDetailsPriceMarketplacePresenterImpl_Factory implements Factory<AdvertDetailsPriceMarketplacePresenterImpl> {

    public static final class a {
        public static final AdvertDetailsPriceMarketplacePresenterImpl_Factory a = new AdvertDetailsPriceMarketplacePresenterImpl_Factory();
    }

    public static AdvertDetailsPriceMarketplacePresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsPriceMarketplacePresenterImpl newInstance() {
        return new AdvertDetailsPriceMarketplacePresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPriceMarketplacePresenterImpl get() {
        return newInstance();
    }
}
