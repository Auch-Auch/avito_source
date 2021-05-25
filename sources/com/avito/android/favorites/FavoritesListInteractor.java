package com.avito.android.favorites;

import android.net.Uri;
import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.favorites.event.FavoriteListUpdateEvent;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0002H&¢\u0006\u0004\b\t\u0010\u0005J%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\r\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H&¢\u0006\u0004\b\u0013\u0010\u0005J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H&¢\u0006\u0004\b\u0014\u0010\u0005J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H&¢\u0006\u0004\b\u0015\u0010\u0005J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H&¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u00020 2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010#H&¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010#H&¢\u0006\u0004\b(\u0010'J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0002H&¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0012H&¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/avito/android/favorites/FavoritesListInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent;", "favoriteUpdateEvents", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "getFavorites", "", "withUploadingChanges", "Lcom/avito/android/favorites/FavoritesLoadingModel;", "loadFavorites", "(Z)Lio/reactivex/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Observable;", "", "removeInactiveAdverts", "removeInactiveAdvertsWithPaging", "removeAllAdverts", "removeAllAdvertsWithPaging", "", "getFavoritesLastUpdateDate", "()J", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lio/reactivex/Single;", "hasNotSyncedItems", "()Lio/reactivex/Single;", "Lio/reactivex/Completable;", "markAsViewed", "()Lio/reactivex/Completable;", "", "id", "context", "markForRemove", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "clearMarkForRemove", "", "counterChanges", "resetCounter", "()V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface FavoritesListInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadFavorites$default(FavoritesListInteractor favoritesListInteractor, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return favoritesListInteractor.loadFavorites(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFavorites");
        }
    }

    @NotNull
    Completable clearMarkForRemove(@NotNull String str, @Nullable String str2);

    @NotNull
    Observable<Integer> counterChanges();

    @NotNull
    Observable<FavoriteListUpdateEvent> favoriteUpdateEvents();

    @NotNull
    Observable<LoadingState<CloseableDataSource<FavoriteListItem>>> getFavorites();

    long getFavoritesLastUpdateDate();

    @NotNull
    Single<Boolean> hasNotSyncedItems();

    @NotNull
    Observable<LoadingState<FavoritesLoadingModel>> loadFavorites(@NotNull Uri uri);

    @NotNull
    Observable<LoadingState<FavoritesLoadingModel>> loadFavorites(boolean z);

    @NotNull
    Completable markAsViewed();

    @NotNull
    Completable markForRemove(@NotNull String str, @Nullable String str2);

    @NotNull
    Kundle onSaveState();

    @NotNull
    Observable<Unit> removeAllAdverts();

    @NotNull
    Observable<Unit> removeAllAdvertsWithPaging();

    @NotNull
    Observable<Unit> removeInactiveAdverts();

    @NotNull
    Observable<Unit> removeInactiveAdvertsWithPaging();

    void resetCounter();
}
