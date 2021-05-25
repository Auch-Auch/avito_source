package com.avito.android.shop.detailed;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.SpannedItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;", "", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "shopDetailedData", "", "isQueryEmpty", "isFiltersApplied", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "convertToItems", "(Lcom/avito/android/shop/detailed/ShopDetailedData;ZZLcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopDetailedItemsConverter {
    @NotNull
    Observable<List<SpannedItem>> convertToItems(@NotNull ShopDetailedData shopDetailedData, boolean z, boolean z2, @NotNull SerpDisplayType serpDisplayType);
}
