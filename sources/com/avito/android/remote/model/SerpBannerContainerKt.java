package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/SerpBannerContainer;", "Lcom/avito/android/remote/model/AdSize;", "getAdSize", "(Lcom/avito/android/remote/model/SerpBannerContainer;)Lcom/avito/android/remote/model/AdSize;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class SerpBannerContainerKt {
    @NotNull
    public static final AdSize getAdSize(@NotNull SerpBannerContainer serpBannerContainer) {
        Intrinsics.checkNotNullParameter(serpBannerContainer, "$this$getAdSize");
        AdSize[] values = AdSize.values();
        for (int i = 0; i < 3; i++) {
            AdSize adSize = values[i];
            if (Intrinsics.areEqual(adSize.getServerName(), serpBannerContainer.getSize())) {
                return adSize;
            }
        }
        return AdSize.SMALL;
    }
}
