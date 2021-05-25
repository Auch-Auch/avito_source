package com.avito.android.search.map.view;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/map/view/MarkerWithFavorite;", "", "", "", "getListFavoritesIds", "()Ljava/util/List;", "setListFavoritesIds", "(Ljava/util/List;)V", "listFavoritesIds", "", "isFavorite", "()Z", "setFavorite", "(Z)V", "getFavoritesIds", "()Ljava/lang/String;", "favoritesIds", "map_release"}, k = 1, mv = {1, 4, 2})
public interface MarkerWithFavorite {
    @NotNull
    String getFavoritesIds();

    @NotNull
    List<String> getListFavoritesIds();

    boolean isFavorite();

    void setFavorite(boolean z);

    void setListFavoritesIds(@NotNull List<String> list);
}
