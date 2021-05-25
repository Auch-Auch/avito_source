package com.avito.android.serp.adapter;

import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "isBig", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/SerpViewType;", "getSerpViewType", "(ZLcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/SerpViewType;", "Lcom/avito/android/remote/model/AdSize;", "adSize", "getIsRedesign", "(Lcom/avito/android/remote/model/AdSize;Lcom/avito/android/remote/model/SerpDisplayType;)Z", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class SerpItemUtilsKt {
    public static final boolean getIsRedesign(@NotNull AdSize adSize, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        return adSize == AdSize.SMALL_NEW && !serpDisplayType.isList();
    }

    @NotNull
    public static final SerpViewType getSerpViewType(boolean z, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        if (z) {
            return SerpViewType.BIG;
        }
        if (serpDisplayType.isGrid()) {
            return SerpViewType.GRID;
        }
        return SerpViewType.LIST;
    }
}
