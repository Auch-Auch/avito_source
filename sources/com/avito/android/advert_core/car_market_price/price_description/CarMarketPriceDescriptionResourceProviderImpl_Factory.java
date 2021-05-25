package com.avito.android.advert_core.car_market_price.price_description;

import dagger.internal.Factory;
public final class CarMarketPriceDescriptionResourceProviderImpl_Factory implements Factory<CarMarketPriceDescriptionResourceProviderImpl> {

    public static final class a {
        public static final CarMarketPriceDescriptionResourceProviderImpl_Factory a = new CarMarketPriceDescriptionResourceProviderImpl_Factory();
    }

    public static CarMarketPriceDescriptionResourceProviderImpl_Factory create() {
        return a.a;
    }

    public static CarMarketPriceDescriptionResourceProviderImpl newInstance() {
        return new CarMarketPriceDescriptionResourceProviderImpl();
    }

    @Override // javax.inject.Provider
    public CarMarketPriceDescriptionResourceProviderImpl get() {
        return newInstance();
    }
}
