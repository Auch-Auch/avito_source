package com.avito.android.user_adverts.tab_screens.converters;

import com.avito.android.remote.model.user_adverts.DiscountBanner;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;", "", "Lcom/avito/android/remote/model/user_adverts/DiscountBanner;", FirebaseAnalytics.Param.DISCOUNT, "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;", "convert", "(Lcom/avito/android/remote/model/user_adverts/DiscountBanner;)Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface DiscountBannerConverter {
    @NotNull
    DiscountBannerItem convert(@NotNull DiscountBanner discountBanner);
}
