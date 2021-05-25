package com.avito.android.serp.adapter;

import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/adapter/FavorableItem;", "Lcom/avito/conveyor_item/Item;", "", "isFavorite", "()Z", "setFavorite", "(Z)V", "", "getAnalyticsContext", "()Ljava/lang/String;", "analyticsContext", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavorableItem extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull FavorableItem favorableItem) {
            return Item.DefaultImpls.getId(favorableItem);
        }
    }

    @Nullable
    String getAnalyticsContext();

    boolean isFavorite();

    void setFavorite(boolean z);
}
