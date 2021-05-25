package com.avito.android.advert_core.car_market_price.badge.di;

import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverterImpl;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenterImpl;
import com.avito.android.di.PerScreen;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/badge/di/AdvertDetailsImvBadgeModule;", "", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenterImpl;", "presenter", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "bindPresenter", "(Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenterImpl;)Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverterImpl;", "converter", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "bindItemConverter", "(Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverterImpl;)Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsImvBadgeModule {
    @PerScreen
    @Binds
    @NotNull
    AdvertDetailsImvBadgeItemConverter bindItemConverter(@NotNull AdvertDetailsImvBadgeItemConverterImpl advertDetailsImvBadgeItemConverterImpl);

    @PerScreen
    @Binds
    @NotNull
    AdvertDetailsImvBadgePresenter bindPresenter(@NotNull AdvertDetailsImvBadgePresenterImpl advertDetailsImvBadgePresenterImpl);
}
