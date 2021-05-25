package com.avito.android.advert_core.car_market_price.price_chart.di;

import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenterImpl;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProvider;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProviderImpl;
import com.avito.android.di.PerScreen;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_chart/di/CarMarketPriceChartModule;", "", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenterImpl;", "presenter", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "bindCarMarketPriceChartPresenter", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenterImpl;)Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProvider;", "bindCarMarketPriceChartResourceProvider", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProviderImpl;)Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartResourceProvider;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface CarMarketPriceChartModule {
    @PerScreen
    @Binds
    @NotNull
    CarMarketPriceChartPresenter bindCarMarketPriceChartPresenter(@NotNull CarMarketPriceChartPresenterImpl carMarketPriceChartPresenterImpl);

    @PerScreen
    @Binds
    @NotNull
    CarMarketPriceChartResourceProvider bindCarMarketPriceChartResourceProvider(@NotNull CarMarketPriceChartResourceProviderImpl carMarketPriceChartResourceProviderImpl);
}
