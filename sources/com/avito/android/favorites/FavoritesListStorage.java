package com.avito.android.favorites;

import com.avito.android.favorites.adapter.FavoriteListItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/favorites/FavoritesListStorage;", "", "", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "getFavoritesList", "()Ljava/util/List;", "setFavoritesList", "(Ljava/util/List;)V", "favoritesList", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface FavoritesListStorage {
    @Nullable
    List<FavoriteListItem> getFavoritesList();

    void setFavoritesList(@Nullable List<? extends FavoriteListItem> list);
}
