package com.avito.android.favorites;

import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/favorites/FavoritesListStorageImpl;", "Lcom/avito/android/favorites/FavoritesListStorage;", "", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getFavoritesList", "()Ljava/util/List;", "setFavoritesList", "(Ljava/util/List;)V", "favoritesList", "<init>", "()V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesListStorageImpl implements FavoritesListStorage {
    @Nullable
    public List<? extends FavoriteListItem> a;

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem>, java.util.List<com.avito.android.favorites.adapter.FavoriteListItem> */
    @Override // com.avito.android.favorites.FavoritesListStorage
    @Nullable
    public List<FavoriteListItem> getFavoritesList() {
        return this.a;
    }

    @Override // com.avito.android.favorites.FavoritesListStorage
    public void setFavoritesList(@Nullable List<? extends FavoriteListItem> list) {
        this.a = list;
    }
}
