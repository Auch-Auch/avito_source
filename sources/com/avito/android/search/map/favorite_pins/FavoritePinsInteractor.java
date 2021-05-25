package com.avito.android.search.map.favorite_pins;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;", "", "", "", "ids", "", "", "isFavoriteList", "(Ljava/util/List;)Ljava/util/Map;", "isMarkForRemove", "(Ljava/util/List;)Ljava/util/List;", "map_release"}, k = 1, mv = {1, 4, 2})
public interface FavoritePinsInteractor {
    @NotNull
    Map<String, Boolean> isFavoriteList(@NotNull List<String> list);

    @NotNull
    List<String> isMarkForRemove(@NotNull List<String> list);
}
