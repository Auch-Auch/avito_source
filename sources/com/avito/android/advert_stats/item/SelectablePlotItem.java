package com.avito.android.advert_stats.item;

import com.avito.android.db.FavoritesContract;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_stats/item/SelectablePlotItem;", "Lcom/avito/conveyor_item/Item;", "", "getPeriod", "()Ljava/lang/String;", "period", "", "getViews", "()Ljava/lang/Integer;", "views", "getFavorites", FavoritesContract.TABLE_NAME, "getStatus", "status", "getContacts", "contacts", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface SelectablePlotItem extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull SelectablePlotItem selectablePlotItem) {
            return Item.DefaultImpls.getId(selectablePlotItem);
        }
    }

    @Nullable
    Integer getContacts();

    @Nullable
    Integer getFavorites();

    @NotNull
    String getPeriod();

    @Nullable
    String getStatus();

    @Nullable
    Integer getViews();
}
