package com.avito.android.advert.favorites;

import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEvent;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractorImpl;", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "", "id", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "favoriteChangeEvents", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "favoriteInvalidatedEvent", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertDetails;", "item", "context", "Lio/reactivex/rxjava3/core/Single;", "toggleFavoriteStatus", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "isMarketplace", "removeFromFavorites", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "isFavoriteOnBack", "isFavorite", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "eventProvider", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "interactor", "<init>", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFavoriteInteractorImpl implements AdvertDetailsFavoriteInteractor {
    public final FavoriteAdvertsInteractor a;
    public final FavoriteAdvertsSyncEventProvider b;
    public final SchedulersFactory3 c;

    public static final class a<T> implements Predicate<FavoriteAdvertsEvent> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(FavoriteAdvertsEvent favoriteAdvertsEvent) {
            FavoriteAdvertsEvent favoriteAdvertsEvent2 = favoriteAdvertsEvent;
            if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.AddedToFavorites) {
                return ((FavoriteAdvertsEvent.AddedToFavorites) favoriteAdvertsEvent2).getIds().contains(this.a);
            }
            if (favoriteAdvertsEvent2 instanceof FavoriteAdvertsEvent.RemovedFromFavorites) {
                return ((FavoriteAdvertsEvent.RemovedFromFavorites) favoriteAdvertsEvent2).getIds().contains(this.a);
            }
            return true;
        }
    }

    public static final class b<T> implements Predicate<FavoriteAdvertsSyncEvent> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(FavoriteAdvertsSyncEvent favoriteAdvertsSyncEvent) {
            return favoriteAdvertsSyncEvent instanceof FavoriteAdvertsSyncEvent.Completed;
        }
    }

    public static final class c<T, R> implements Function<FavoriteAdvertsSyncEvent, Unit> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(FavoriteAdvertsSyncEvent favoriteAdvertsSyncEvent) {
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Supplier<Unit> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Unit get() {
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertDetailsFavoriteInteractorImpl(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteAdvertsSyncEventProvider favoriteAdvertsSyncEventProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncEventProvider, "eventProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = favoriteAdvertsInteractor;
        this.b = favoriteAdvertsSyncEventProvider;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor
    @NotNull
    public Observable<FavoriteAdvertsEvent> favoriteChangeEvents(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable<FavoriteAdvertsEvent> observable = this.a.favoritesEvents().filter(new a(str)).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "interactor.favoritesEven…          .toObservable()");
        return observable;
    }

    @Override // com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor
    @NotNull
    public Observable<Unit> favoriteInvalidatedEvent() {
        Observable<R> map = this.b.observeEvents().skip(1).filter(b.a).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "eventProvider.observeEve…            .map { Unit }");
        return map;
    }

    @Override // com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor
    @NotNull
    public Single<Boolean> isFavorite(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        return a2.b.a.a.a.e2(this.c, this.a.isFavorite(str, z), "interactor.isFavorite(id…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor
    @NotNull
    public Single<Unit> removeFromFavorites(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        return a2.b.a.a.a.e2(this.c, this.a.removeFromFavorites(str, new FavoriteActionSource.Item(str2, z)).toSingle(d.a), "interactor.removeFromFav…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor
    @NotNull
    public Single<Unit> toggleFavoriteStatus(@NotNull AdvertDetails advertDetails, @Nullable String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "item");
        return a2.b.a.a.a.e2(this.c, this.a.toggleFavoriteStatus(advertDetails.getId(), new FavoriteActionSource.Item(str, advertDetails.isMarketplace()), advertDetails.isFavorite()), "interactor.toggleFavorit…scribeOn(schedulers.io())");
    }
}
