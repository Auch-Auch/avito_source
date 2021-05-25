package com.avito.android.favorite_sellers;

import android.annotation.SuppressLint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorite_sellers/AdvertDetailsRecommendationItem;", "Lcom/avito/android/favorite_sellers/RecommendationItem;", "", "stringId", "", "Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", "carousel", "title", "", "spanCount", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ParcelCreator"})
public final class AdvertDetailsRecommendationItem extends RecommendationItem {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsRecommendationItem(@NotNull String str, @NotNull List<? extends RecommendationCarouselItem> list, @Nullable String str2, int i) {
        super(str, list, str2, i, null, 16, null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "carousel");
    }
}
