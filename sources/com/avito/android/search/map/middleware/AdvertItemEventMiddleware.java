package com.avito.android.search.map.middleware;

import com.avito.android.di.PerFragment;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.redux.Middleware;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.di.PinAdvertsList;
import com.avito.android.search.map.view.advert.AdvertItemEvent;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/map/middleware/AdvertItemEventMiddleware;", "Lcom/avito/android/redux/Middleware;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "Lio/reactivex/rxjava3/core/Observable;", "actions", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "pinAdvertsFavoritePresenter", "<init>", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemEventMiddleware implements Middleware<SearchMapState, MapAction> {
    public final FavoriteAdvertsPresenter a;

    public static final class a<T> implements Predicate<MapAction> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(MapAction mapAction) {
            return mapAction instanceof AdvertItemEvent.FavoriteButtonClicked;
        }
    }

    public static final class b<T> implements Consumer<AdvertItemEvent.FavoriteButtonClicked> {
        public final /* synthetic */ AdvertItemEventMiddleware a;

        public b(AdvertItemEventMiddleware advertItemEventMiddleware) {
            this.a = advertItemEventMiddleware;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertItemEvent.FavoriteButtonClicked favoriteButtonClicked) {
            this.a.a.onFavoriteButtonClicked(favoriteButtonClicked.getItem());
        }
    }

    public static final class c<T, R> implements Function<AdvertItemEvent.FavoriteButtonClicked, ObservableSource<? extends MapAction>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MapAction> apply(AdvertItemEvent.FavoriteButtonClicked favoriteButtonClicked) {
            return Observable.empty();
        }
    }

    @Inject
    public AdvertItemEventMiddleware(@PinAdvertsList @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "pinAdvertsFavoritePresenter");
        this.a = favoriteAdvertsPresenter;
    }

    @Override // com.avito.android.redux.Middleware
    @NotNull
    public Observable<MapAction> create(@NotNull Observable<MapAction> observable, @NotNull Observable<SearchMapState> observable2) {
        Intrinsics.checkNotNullParameter(observable, "actions");
        Intrinsics.checkNotNullParameter(observable2, "state");
        Observable<MapAction> filter = observable.filter(a.a);
        Intrinsics.checkNotNullExpressionValue(filter, "actions.filter { it is A…t.FavoriteButtonClicked }");
        Observable<U> cast = filter.cast(AdvertItemEvent.FavoriteButtonClicked.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Observable<R> flatMap = cast.doOnNext(new b(this)).flatMap(c.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "actions.filter { it is A…able.empty<MapAction>() }");
        return flatMap;
    }
}
