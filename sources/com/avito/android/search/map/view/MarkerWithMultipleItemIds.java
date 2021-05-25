package com.avito.android.search.map.view;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/search/map/view/MarkerWithMultipleItemIds;", "", "", "", "getListIds", "()Ljava/util/List;", "setListIds", "(Ljava/util/List;)V", "listIds", "map_release"}, k = 1, mv = {1, 4, 2})
public interface MarkerWithMultipleItemIds {
    @NotNull
    List<String> getListIds();

    void setListIds(@NotNull List<String> list);
}
