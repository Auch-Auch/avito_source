package com.avito.android.advert_core.car_market_price.price_description.di;

import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenterImpl;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionResourceProvider;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionResourceProviderImpl;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverterImpl;
import com.avito.android.di.PerScreen;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/di/CarMarketPriceDescriptionModule;", "", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenterImpl;", "presenter", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenter;", "bindCarMarketPriceDescriptionPresenter", "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenterImpl;)Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenter;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverterImpl;", "blueprint", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;", "bindCarMarketPriceSwitchConverter", "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverterImpl;)Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProvider;", "bindCarMarketPriceChartResourceProvider", "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProviderImpl;)Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProvider;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface CarMarketPriceDescriptionModule {
    @PerScreen
    @Binds
    @NotNull
    CarMarketPriceDescriptionResourceProvider bindCarMarketPriceChartResourceProvider(@NotNull CarMarketPriceDescriptionResourceProviderImpl carMarketPriceDescriptionResourceProviderImpl);

    @PerScreen
    @Binds
    @NotNull
    CarMarketPriceDescriptionPresenter bindCarMarketPriceDescriptionPresenter(@NotNull CarMarketPriceDescriptionPresenterImpl carMarketPriceDescriptionPresenterImpl);

    @PerScreen
    @Binds
    @NotNull
    CarMarketPriceSwitchConverter bindCarMarketPriceSwitchConverter(@NotNull CarMarketPriceSwitchConverterImpl carMarketPriceSwitchConverterImpl);
}
