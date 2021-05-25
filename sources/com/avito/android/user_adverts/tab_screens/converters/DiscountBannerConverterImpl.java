package com.avito.android.user_adverts.tab_screens.converters;

import a2.b.a.a.a;
import com.avito.android.remote.model.user_adverts.DiscountBanner;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;", "Lcom/avito/android/remote/model/user_adverts/DiscountBanner;", FirebaseAnalytics.Param.DISCOUNT, "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;", "convert", "(Lcom/avito/android/remote/model/user_adverts/DiscountBanner;)Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountBannerConverterImpl implements DiscountBannerConverter {
    @Override // com.avito.android.user_adverts.tab_screens.converters.DiscountBannerConverter
    @NotNull
    public DiscountBannerItem convert(@NotNull DiscountBanner discountBanner) {
        Intrinsics.checkNotNullParameter(discountBanner, FirebaseAnalytics.Param.DISCOUNT);
        String I2 = a.I2("UUID.randomUUID().toString()");
        String title = discountBanner.getTitle();
        String title2 = discountBanner.getLimit().getTitle();
        String discount = discountBanner.getDiscount();
        Long dueDate = discountBanner.getLimit().getDueDate();
        return new DiscountBannerItem(I2, title, title2, discount, dueDate != null ? Long.valueOf(dueDate.longValue() * ((long) 1000)) : null, discountBanner.getUri(), 0, 64, null);
    }
}
