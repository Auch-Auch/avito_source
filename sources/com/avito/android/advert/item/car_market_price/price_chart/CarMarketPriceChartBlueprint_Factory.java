package com.avito.android.advert.item.car_market_price.price_chart;

import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarMarketPriceChartBlueprint_Factory implements Factory<CarMarketPriceChartBlueprint> {
    public final Provider<CarMarketPriceChartPresenter> a;

    public CarMarketPriceChartBlueprint_Factory(Provider<CarMarketPriceChartPresenter> provider) {
        this.a = provider;
    }

    public static CarMarketPriceChartBlueprint_Factory create(Provider<CarMarketPriceChartPresenter> provider) {
        return new CarMarketPriceChartBlueprint_Factory(provider);
    }

    public static CarMarketPriceChartBlueprint newInstance(CarMarketPriceChartPresenter carMarketPriceChartPresenter) {
        return new CarMarketPriceChartBlueprint(carMarketPriceChartPresenter);
    }

    @Override // javax.inject.Provider
    public CarMarketPriceChartBlueprint get() {
        return newInstance(this.a.get());
    }
}
