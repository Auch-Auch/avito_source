package com.avito.android.advert_core.car_market_price.price_chart;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarMarketPriceChartResourceProviderImpl_Factory implements Factory<CarMarketPriceChartResourceProviderImpl> {
    public final Provider<Resources> a;

    public CarMarketPriceChartResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static CarMarketPriceChartResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new CarMarketPriceChartResourceProviderImpl_Factory(provider);
    }

    public static CarMarketPriceChartResourceProviderImpl newInstance(Resources resources) {
        return new CarMarketPriceChartResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public CarMarketPriceChartResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
