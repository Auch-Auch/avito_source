package com.avito.android.advert.favorites;

import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "", "", "id", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "favoriteChangeEvents", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "favoriteInvalidatedEvent", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertDetails;", "item", "context", "Lio/reactivex/rxjava3/core/Single;", "toggleFavoriteStatus", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "isMarketplace", "removeFromFavorites", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "isFavoriteOnBack", "isFavorite", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsFavoriteInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single removeFromFavorites$default(AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return advertDetailsFavoriteInteractor.removeFromFavorites(str, str2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeFromFavorites");
        }
    }

    @NotNull
    Observable<FavoriteAdvertsEvent> favoriteChangeEvents(@NotNull String str);

    @NotNull
    Observable<Unit> favoriteInvalidatedEvent();

    @NotNull
    Single<Boolean> isFavorite(@NotNull String str, boolean z);

    @NotNull
    Single<Unit> removeFromFavorites(@NotNull String str, @Nullable String str2, boolean z);

    @NotNull
    Single<Unit> toggleFavoriteStatus(@NotNull AdvertDetails advertDetails, @Nullable String str);
}
