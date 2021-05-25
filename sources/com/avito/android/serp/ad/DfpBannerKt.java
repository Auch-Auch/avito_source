package com.avito.android.serp.ad;

import com.google.android.gms.ads.formats.UnifiedNativeAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "", "isApplicationAd", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAd;)Z", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class DfpBannerKt {
    public static final boolean isApplicationAd(@NotNull UnifiedNativeAd unifiedNativeAd) {
        Intrinsics.checkNotNullParameter(unifiedNativeAd, "$this$isApplicationAd");
        Double starRating = unifiedNativeAd.getStarRating();
        if (starRating == null) {
            return false;
        }
        if (starRating.doubleValue() <= 0.0d) {
            String price = unifiedNativeAd.getPrice();
            if (!(!(price == null || m.isBlank(price)))) {
                String store = unifiedNativeAd.getStore();
                if (!(!(store == null || m.isBlank(store)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
