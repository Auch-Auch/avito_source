package com.avito.android.favorite;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00130\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "Lcom/avito/android/favorite/FavoriteAdvertsEventProvider;", "", "id", "Lcom/avito/android/favorite/FavoriteActionSource;", "src", "", "isFavoriteOnBack", "Lio/reactivex/rxjava3/core/Single;", "", "toggleFavoriteStatus", "(Ljava/lang/String;Lcom/avito/android/favorite/FavoriteActionSource;Z)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "removeFromFavorites", "(Ljava/lang/String;Lcom/avito/android/favorite/FavoriteActionSource;)Lio/reactivex/rxjava3/core/Completable;", "isFavorite", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "", "ids", "", "getSavedFavoriteStatuses", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "getSavedFavoriteStatusesSync", "(Ljava/util/List;)Ljava/util/Map;", "isMarkForRemove", "(Ljava/util/List;)Ljava/util/List;", "wipeSynced", "()Lio/reactivex/rxjava3/core/Completable;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteAdvertsInteractor extends FavoriteAdvertsEventProvider {
    @NotNull
    Single<Map<String, Boolean>> getSavedFavoriteStatuses(@NotNull List<String> list);

    @NotNull
    Map<String, Boolean> getSavedFavoriteStatusesSync(@NotNull List<String> list);

    @NotNull
    Single<Boolean> isFavorite(@NotNull String str, boolean z);

    @NotNull
    List<String> isMarkForRemove(@NotNull List<String> list);

    @NotNull
    Completable removeFromFavorites(@NotNull String str, @NotNull FavoriteActionSource favoriteActionSource);

    @NotNull
    Single<Unit> toggleFavoriteStatus(@NotNull String str, @NotNull FavoriteActionSource favoriteActionSource, boolean z);

    @NotNull
    Completable wipeSynced();
}
