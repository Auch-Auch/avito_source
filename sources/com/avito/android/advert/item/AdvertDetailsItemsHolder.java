package com.avito.android.advert.item;

import com.avito.android.serp.adapter.PersistableSpannedItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0007*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;", "", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "item", "", "getItemPosition", "(Lcom/avito/android/serp/adapter/PersistableSpannedItem;)I", "T", "Ljava/lang/Class;", "type", "", "getItemsWithType", "(Ljava/lang/Class;)Ljava/util/List;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsItemsHolder {
    int getItemPosition(@NotNull PersistableSpannedItem persistableSpannedItem);

    @NotNull
    <T extends PersistableSpannedItem> List<T> getItemsWithType(@NotNull Class<T> cls);
}
