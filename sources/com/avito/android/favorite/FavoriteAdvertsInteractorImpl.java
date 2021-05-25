package com.avito.android.favorite;

import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractor;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b5\u00106J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00140\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsInteractorImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "Lcom/avito/android/favorite/FavoriteAdvertsEventProvider;", "", "id", "Lcom/avito/android/favorite/FavoriteActionSource;", "src", "", "isFavoriteOnBack", "Lio/reactivex/rxjava3/core/Single;", "", "toggleFavoriteStatus", "(Ljava/lang/String;Lcom/avito/android/favorite/FavoriteActionSource;Z)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "removeFromFavorites", "(Ljava/lang/String;Lcom/avito/android/favorite/FavoriteActionSource;)Lio/reactivex/rxjava3/core/Completable;", "isFavorite", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "", "ids", "", "getSavedFavoriteStatuses", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "getSavedFavoriteStatusesSync", "(Ljava/util/List;)Ljava/util/Map;", "isMarkForRemove", "(Ljava/util/List;)Ljava/util/List;", "wipeSynced", "()Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/avito/android/favorite/FavoriteAdvertsEvent;", "favoritesEvents", "()Lio/reactivex/rxjava3/core/Flowable;", "Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractor;", "d", "Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractor;", "favoriteAdvertsAnalyticsInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "syncDao", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "uploadInteractor", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "c", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "eventInteractor", "<init>", "(Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsInteractorImpl implements FavoriteAdvertsInteractor, FavoriteAdvertsEventProvider {
    public final FavoritesSyncDao a;
    public final FavoriteAdvertsUploadInteractor b;
    public final FavoriteAdvertsEventInteractor c;
    public final FavoriteAdvertsAnalyticsInteractor d;
    public final SchedulersFactory3 e;

    public static final class a<V> implements Callable<Map<String, ? extends Boolean>> {
        public final /* synthetic */ FavoriteAdvertsInteractorImpl a;
        public final /* synthetic */ List b;

        public a(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl, List list) {
            this.a = favoriteAdvertsInteractorImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Map<String, ? extends Boolean> call() {
            return this.a.a.getSavedFavoriteStatuses(this.b);
        }
    }

    public static final class b<V> implements Callable<Boolean> {
        public final /* synthetic */ FavoriteAdvertsInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public b(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl, String str, boolean z) {
            this.a = favoriteAdvertsInteractorImpl;
            this.b = str;
            this.c = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(this.a.a.isFavorite(this.b, this.c));
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ FavoriteAdvertsInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FavoriteActionSource c;

        public c(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl, String str, FavoriteActionSource favoriteActionSource) {
            this.a = favoriteAdvertsInteractorImpl;
            this.b = str;
            this.c = favoriteActionSource;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.a.markForRemove(this.b);
            this.a.c.acceptEvent(new FavoriteAdvertsEvent.RemovedFromFavorites(this.b, this.c));
            this.a.b.upload();
        }
    }

    public static final class d<T, R> implements Function<Boolean, SingleSource<? extends Unit>> {
        public final /* synthetic */ FavoriteAdvertsInteractorImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FavoriteActionSource d;

        public d(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl, boolean z, String str, FavoriteActionSource favoriteActionSource) {
            this.a = favoriteAdvertsInteractorImpl;
            this.b = z;
            this.c = str;
            this.d = favoriteActionSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Unit> apply(Boolean bool) {
            Completable completable;
            Boolean bool2 = bool;
            if (this.a.a.getCount() < 500 || !Intrinsics.areEqual(bool2, Boolean.valueOf(this.b))) {
                Intrinsics.checkNotNullExpressionValue(bool2, "isFavorite");
                if (bool2.booleanValue()) {
                    completable = this.a.removeFromFavorites(this.c, this.d);
                } else {
                    completable = FavoriteAdvertsInteractorImpl.access$addToFavorites(this.a, this.c, this.d);
                }
            } else {
                completable = Completable.fromAction(new a2.a.a.r0.b(this));
            }
            return completable.toSingleDefault(Unit.INSTANCE);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ FavoriteAdvertsInteractorImpl a;

        public e(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl) {
            this.a = favoriteAdvertsInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.a.wipeSynced();
        }
    }

    @Inject
    public FavoriteAdvertsInteractorImpl(@NotNull FavoritesSyncDao favoritesSyncDao, @NotNull FavoriteAdvertsUploadInteractor favoriteAdvertsUploadInteractor, @NotNull FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor, @NotNull FavoriteAdvertsAnalyticsInteractor favoriteAdvertsAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(favoritesSyncDao, "syncDao");
        Intrinsics.checkNotNullParameter(favoriteAdvertsUploadInteractor, "uploadInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsEventInteractor, "eventInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsAnalyticsInteractor, "favoriteAdvertsAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = favoritesSyncDao;
        this.b = favoriteAdvertsUploadInteractor;
        this.c = favoriteAdvertsEventInteractor;
        this.d = favoriteAdvertsAnalyticsInteractor;
        this.e = schedulersFactory3;
    }

    public static final Completable access$addToFavorites(FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl, String str, FavoriteActionSource favoriteActionSource) {
        Objects.requireNonNull(favoriteAdvertsInteractorImpl);
        Completable andThen = Completable.fromAction(new a2.a.a.r0.a(favoriteAdvertsInteractorImpl, str, favoriteActionSource)).subscribeOn(favoriteAdvertsInteractorImpl.e.io()).andThen(favoriteAdvertsInteractorImpl.d.sendAddToFavorites(str));
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromAction {…r.sendAddToFavorites(id))");
        return andThen;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsEventProvider
    @NotNull
    public Flowable<FavoriteAdvertsEvent> favoritesEvents() {
        return this.c.favoritesEvents();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public Single<Map<String, Boolean>> getSavedFavoriteStatuses(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        return a2.b.a.a.a.e2(this.e, Single.fromCallable(new a(this, list)), "Single.fromCallable { sy…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public Map<String, Boolean> getSavedFavoriteStatusesSync(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        return this.a.getSavedFavoriteStatuses(list);
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public Single<Boolean> isFavorite(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        return a2.b.a.a.a.e2(this.e, Single.fromCallable(new b(this, str, z)), "Single.fromCallable { sy…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public List<String> isMarkForRemove(@NotNull List<String> list) {
        ArrayList i0 = a2.b.a.a.a.i0(list, "ids");
        for (T t : list) {
            if (this.a.isMarkedForRemove(t)) {
                i0.add(t);
            }
        }
        return i0;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public Completable removeFromFavorites(@NotNull String str, @NotNull FavoriteActionSource favoriteActionSource) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(favoriteActionSource, "src");
        Completable andThen = Completable.fromAction(new c(this, str, favoriteActionSource)).subscribeOn(this.e.io()).andThen(this.d.sendRemoveFromFavorites(str));
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromAction {…dRemoveFromFavorites(id))");
        return andThen;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public Single<Unit> toggleFavoriteStatus(@NotNull String str, @NotNull FavoriteActionSource favoriteActionSource, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(favoriteActionSource, "src");
        Single<R> flatMap = isFavorite(str, z).flatMap(new d(this, z, str, favoriteActionSource));
        Intrinsics.checkNotNullExpressionValue(flatMap, "isFavorite(id, isFavorit…fault(Unit)\n            }");
        return flatMap;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsInteractor
    @NotNull
    public Completable wipeSynced() {
        Completable subscribeOn = Completable.fromAction(new e(this)).subscribeOn(this.e.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Completable.fromAction {…scribeOn(schedulers.io())");
        return subscribeOn;
    }
}
