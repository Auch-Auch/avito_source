package com.avito.android.search.map.favorite_pins;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/map/favorite_pins/FavouritePinsInteractorImpl;", "Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;", "", "", "ids", "", "", "isFavoriteList", "(Ljava/util/List;)Ljava/util/Map;", "isMarkForRemove", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "interactor", "<init>", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class FavouritePinsInteractorImpl implements FavoritePinsInteractor {
    public final FavoriteAdvertsInteractor a;

    @Inject
    public FavouritePinsInteractorImpl(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "interactor");
        this.a = favoriteAdvertsInteractor;
    }

    @Override // com.avito.android.search.map.favorite_pins.FavoritePinsInteractor
    @NotNull
    public Map<String, Boolean> isFavoriteList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        return this.a.getSavedFavoriteStatusesSync(list);
    }

    @Override // com.avito.android.search.map.favorite_pins.FavoritePinsInteractor
    @NotNull
    public List<String> isMarkForRemove(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        return this.a.isMarkForRemove(list);
    }
}
