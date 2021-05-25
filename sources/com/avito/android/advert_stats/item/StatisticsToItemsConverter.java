package com.avito.android.advert_stats.item;

import com.avito.android.advert_stats.remote.model.AdvertStatistics;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "", "Lcom/avito/android/advert_stats/remote/model/AdvertStatistics;", "stat", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/advert_stats/remote/model/AdvertStatistics;)Ljava/util/List;", "items", "Lcom/avito/android/advert_stats/item/SelectablePlotItem;", "selectedItem", "updateItems", "(Ljava/util/List;Lcom/avito/android/advert_stats/item/SelectablePlotItem;)Ljava/util/List;", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface StatisticsToItemsConverter {
    @NotNull
    List<Item> convert(@NotNull AdvertStatistics advertStatistics);

    @NotNull
    List<Item> updateItems(@NotNull List<? extends Item> list, @NotNull SelectablePlotItem selectablePlotItem);
}
