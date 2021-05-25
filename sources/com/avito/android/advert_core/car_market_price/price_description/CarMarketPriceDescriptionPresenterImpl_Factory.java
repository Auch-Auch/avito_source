package com.avito.android.advert_core.car_market_price.price_description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarMarketPriceDescriptionPresenterImpl_Factory implements Factory<CarMarketPriceDescriptionPresenterImpl> {
    public final Provider<CarMarketPriceSwitchConverter> a;

    public CarMarketPriceDescriptionPresenterImpl_Factory(Provider<CarMarketPriceSwitchConverter> provider) {
        this.a = provider;
    }

    public static CarMarketPriceDescriptionPresenterImpl_Factory create(Provider<CarMarketPriceSwitchConverter> provider) {
        return new CarMarketPriceDescriptionPresenterImpl_Factory(provider);
    }

    public static CarMarketPriceDescriptionPresenterImpl newInstance(CarMarketPriceSwitchConverter carMarketPriceSwitchConverter) {
        return new CarMarketPriceDescriptionPresenterImpl(carMarketPriceSwitchConverter);
    }

    @Override // javax.inject.Provider
    public CarMarketPriceDescriptionPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
