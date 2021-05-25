package com.avito.android.advert_core.car_market_price.price_chart;

import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarMarketPriceChartPresenterImpl_Factory implements Factory<CarMarketPriceChartPresenterImpl> {
    public final Provider<CarMarketPriceChartResourceProvider> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<DeviceMetrics> c;

    public CarMarketPriceChartPresenterImpl_Factory(Provider<CarMarketPriceChartResourceProvider> provider, Provider<AttributedTextFormatter> provider2, Provider<DeviceMetrics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CarMarketPriceChartPresenterImpl_Factory create(Provider<CarMarketPriceChartResourceProvider> provider, Provider<AttributedTextFormatter> provider2, Provider<DeviceMetrics> provider3) {
        return new CarMarketPriceChartPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static CarMarketPriceChartPresenterImpl newInstance(CarMarketPriceChartResourceProvider carMarketPriceChartResourceProvider, AttributedTextFormatter attributedTextFormatter, DeviceMetrics deviceMetrics) {
        return new CarMarketPriceChartPresenterImpl(carMarketPriceChartResourceProvider, attributedTextFormatter, deviceMetrics);
    }

    @Override // javax.inject.Provider
    public CarMarketPriceChartPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
