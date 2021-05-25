package com.avito.android.advert_core.car_market_price.price_description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarMarketPriceSwitchConverterImpl_Factory implements Factory<CarMarketPriceSwitchConverterImpl> {
    public final Provider<CarMarketPriceDescriptionResourceProvider> a;

    public CarMarketPriceSwitchConverterImpl_Factory(Provider<CarMarketPriceDescriptionResourceProvider> provider) {
        this.a = provider;
    }

    public static CarMarketPriceSwitchConverterImpl_Factory create(Provider<CarMarketPriceDescriptionResourceProvider> provider) {
        return new CarMarketPriceSwitchConverterImpl_Factory(provider);
    }

    public static CarMarketPriceSwitchConverterImpl newInstance(CarMarketPriceDescriptionResourceProvider carMarketPriceDescriptionResourceProvider) {
        return new CarMarketPriceSwitchConverterImpl(carMarketPriceDescriptionResourceProvider);
    }

    @Override // javax.inject.Provider
    public CarMarketPriceSwitchConverterImpl get() {
        return newInstance(this.a.get());
    }
}
