package com.avito.android.serp.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.SerpBannerContainer;
import com.avito.android.remote.model.SerpBannerContainerKt;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SerpBannerContainer;", "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "toSerpCommercialBanner", "(Lcom/avito/android/remote/model/SerpBannerContainer;)Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "Lcom/avito/android/remote/model/CommercialBanner;", "Lcom/avito/android/remote/model/AdSize;", "adSize", "(Lcom/avito/android/remote/model/CommercialBanner;Lcom/avito/android/remote/model/AdSize;)Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "toEmptyBanner", "(Lcom/avito/android/serp/adapter/SerpCommercialBanner;)Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class SerpCommercialBannerKt {
    @NotNull
    public static final SerpCommercialBanner toEmptyBanner(@NotNull SerpCommercialBanner serpCommercialBanner) {
        Intrinsics.checkNotNullParameter(serpCommercialBanner, "$this$toEmptyBanner");
        return new SerpCommercialBanner(serpCommercialBanner.getId(), serpCommercialBanner.getStringId(), serpCommercialBanner.getViewType(), serpCommercialBanner.getDisplayType(), serpCommercialBanner.getSpanCount(), serpCommercialBanner.getAdSize(), null);
    }

    @NotNull
    public static final SerpCommercialBanner toSerpCommercialBanner(@NotNull SerpBannerContainer serpBannerContainer) {
        Intrinsics.checkNotNullParameter(serpBannerContainer, "$this$toSerpCommercialBanner");
        List<SerpElement> elements = serpBannerContainer.getElements();
        ArrayList arrayList = new ArrayList();
        for (T t : elements) {
            if (t instanceof AdNetworkBannerItem) {
                arrayList.add(t);
            }
        }
        String I2 = a.I2("UUID.randomUUID().toString()");
        Boolean enableEventSampling = serpBannerContainer.getEnableEventSampling();
        return toSerpCommercialBanner(new CommercialBanner(I2, arrayList, enableEventSampling != null ? enableEventSampling.booleanValue() : false, 0, null, 24, null), SerpBannerContainerKt.getAdSize(serpBannerContainer));
    }

    @NotNull
    public static final SerpCommercialBanner toSerpCommercialBanner(@NotNull CommercialBanner commercialBanner, @NotNull AdSize adSize) {
        Intrinsics.checkNotNullParameter(commercialBanner, "$this$toSerpCommercialBanner");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        return new SerpCommercialBanner(0, "", SerpViewType.SINGLE, SerpDisplayType.Grid, 0, adSize, commercialBanner);
    }
}
