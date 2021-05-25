package com.avito.android.serp.adapter.item_sorter;

import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "T", "", "list", "", "columns", "sort", "(Ljava/util/List;I)Ljava/util/List;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpItemSorter {
    @NotNull
    <T extends ViewTypeSerpItem> List<T> sort(@NotNull List<? extends T> list, int i);
}
