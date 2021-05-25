package com.avito.android.advert.item.marketplace_quantity;

import dagger.internal.Factory;
public final class MarketplaceQuantityPresenterImpl_Factory implements Factory<MarketplaceQuantityPresenterImpl> {

    public static final class a {
        public static final MarketplaceQuantityPresenterImpl_Factory a = new MarketplaceQuantityPresenterImpl_Factory();
    }

    public static MarketplaceQuantityPresenterImpl_Factory create() {
        return a.a;
    }

    public static MarketplaceQuantityPresenterImpl newInstance() {
        return new MarketplaceQuantityPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MarketplaceQuantityPresenterImpl get() {
        return newInstance();
    }
}
