package com.avito.android.serp.ad;

import com.my.target.common.models.ImageData;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.banners.NativePromoCard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/my/target/nativeads/NativeAd;", "Lcom/my/target/common/models/ImageData;", "bgImageData", "(Lcom/my/target/nativeads/NativeAd;)Lcom/my/target/common/models/ImageData;", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class MyTargetBannerKt {
    @Nullable
    public static final ImageData bgImageData(@NotNull NativeAd nativeAd) {
        NativePromoBanner banner;
        ArrayList<NativePromoCard> cards;
        Intrinsics.checkNotNullParameter(nativeAd, "$this$bgImageData");
        NativePromoBanner banner2 = nativeAd.getBanner();
        boolean z = false;
        if (!(banner2 == null || (cards = banner2.getCards()) == null || cards.size() <= 0)) {
            z = true;
        }
        if (!z && (banner = nativeAd.getBanner()) != null) {
            return banner.getImage();
        }
        return null;
    }
}
