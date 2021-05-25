package com.avito.android.favorites;

import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/favorites/FavoritesLoadingModel;", "", "", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItem;", "getNextItem", "()Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItem;", "nextItem", "<init>", "(Ljava/util/List;Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItem;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesLoadingModel {
    @NotNull
    public final List<FavoriteListItem> a;
    @Nullable
    public final FavoriteLoadingItem b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public FavoritesLoadingModel(@NotNull List<? extends FavoriteListItem> list, @Nullable FavoriteLoadingItem favoriteLoadingItem) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = list;
        this.b = favoriteLoadingItem;
    }

    @NotNull
    public final List<FavoriteListItem> getItems() {
        return this.a;
    }

    @Nullable
    public final FavoriteLoadingItem getNextItem() {
        return this.b;
    }
}
