package com.avito.android.advert.item.car_market_price.price_description;

import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarMarketPriceDescriptionBlueprint_Factory implements Factory<CarMarketPriceDescriptionBlueprint> {
    public final Provider<CarMarketPriceDescriptionPresenter> a;

    public CarMarketPriceDescriptionBlueprint_Factory(Provider<CarMarketPriceDescriptionPresenter> provider) {
        this.a = provider;
    }

    public static CarMarketPriceDescriptionBlueprint_Factory create(Provider<CarMarketPriceDescriptionPresenter> provider) {
        return new CarMarketPriceDescriptionBlueprint_Factory(provider);
    }

    public static CarMarketPriceDescriptionBlueprint newInstance(CarMarketPriceDescriptionPresenter carMarketPriceDescriptionPresenter) {
        return new CarMarketPriceDescriptionBlueprint(carMarketPriceDescriptionPresenter);
    }

    @Override // javax.inject.Provider
    public CarMarketPriceDescriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
