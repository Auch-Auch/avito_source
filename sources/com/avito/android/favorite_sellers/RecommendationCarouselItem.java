package com.avito.android.favorite_sellers;

import android.os.Parcelable;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", "Lcom/avito/conveyor_item/Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface RecommendationCarouselItem extends Item, Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static int describeContents(@NotNull RecommendationCarouselItem recommendationCarouselItem) {
            return 0;
        }

        public static long getId(@NotNull RecommendationCarouselItem recommendationCarouselItem) {
            return Item.DefaultImpls.getId(recommendationCarouselItem);
        }
    }

    @Override // android.os.Parcelable
    int describeContents();
}
