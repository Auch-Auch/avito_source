package com.avito.android.favorites;

import a2.a.a.t0.a0;
import a2.a.a.t0.b0;
import a2.a.a.t0.c0;
import a2.a.a.t0.d0;
import a2.a.a.t0.e0;
import a2.a.a.t0.f0;
import a2.a.a.t0.i0;
import a2.a.a.t0.j0;
import a2.a.a.t0.k0;
import a2.a.a.t0.m0;
import a2.a.a.t0.o0;
import a2.a.a.t0.p0;
import a2.a.a.t0.y;
import a2.a.a.t0.z;
import android.annotation.SuppressLint;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.FavoriteAdvertsSyncEvent;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Throwables;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractorImpl;", "Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;", "", "onSynchronize", "()V", "onUpload", "onWipe", "onUploadRemovedItems", "Lio/reactivex/rxjava3/core/Single;", "", AuthSource.SEND_ABUSE, "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/Analytics;", a2.g.r.g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "c", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "syncDao", "Lcom/avito/android/server_time/TimeSource;", "f", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/db/favorites/FavoriteItemsDao;", "d", "Lcom/avito/android/db/favorites/FavoriteItemsDao;", "advertsDao", "Lcom/avito/android/favorites/remote/FavoritesApi;", "Lcom/avito/android/favorites/remote/FavoritesApi;", "api", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;", "h", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;", "syncEventInteractor", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "i", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "converter", "Lcom/avito/android/favorites/MutableFavoriteStorage;", "e", "Lcom/avito/android/favorites/MutableFavoriteStorage;", "favoriteStorage", "<init>", "(Lcom/avito/android/favorites/remote/FavoritesApi;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/db/favorites/FavoriteItemsDao;Lcom/avito/android/favorites/MutableFavoriteStorage;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;Lcom/avito/android/favorites/FavoriteAdvertItemConverter;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsServiceInteractorImpl implements FavoriteAdvertsServiceInteractor {
    public final FavoritesApi a;
    public final AccountStateProvider b;
    public final FavoritesSyncDao c;
    public final FavoriteItemsDao d;
    public final MutableFavoriteStorage e;
    public final TimeSource f;
    public final Analytics g;
    public final FavoriteAdvertsSyncEventInteractor h;
    public final FavoriteAdvertItemConverter i;

    public static final class a<T, R> implements Function<Boolean, CompletableSource> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public a(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (!bool2.booleanValue()) {
                return FavoriteAdvertsServiceInteractorImpl.access$purgeRemovedAdverts(this.a).flatMapCompletable(new y(this));
            }
            this.a.d.wipe();
            return FavoriteAdvertsServiceInteractorImpl.access$uploadPendingChanges(this.a).ignoreElement();
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public b(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            FavoriteAdvertsServiceInteractorImpl.access$reportEvent(this.a, new FavoriteAdvertsSyncEvent.Started());
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public c(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            FavoriteAdvertsServiceInteractorImpl.access$reportEvent(this.a, new FavoriteAdvertsSyncEvent.Completed(null, 1, null));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public d(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (Throwables.isNotFoundError(th2)) {
                FavoriteAdvertsServiceInteractorImpl.access$reportEvent(this.a, new FavoriteAdvertsSyncEvent.Completed(null, 1, null));
                return;
            }
            FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            FavoriteAdvertsServiceInteractorImpl.access$reportEvent(favoriteAdvertsServiceInteractorImpl, new FavoriteAdvertsSyncEvent.Failed(th2));
        }
    }

    public static final class e<T> implements Consumer<Boolean> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public e(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl = this.a;
                Completable doOnError = FavoriteAdvertsServiceInteractorImpl.access$uploadPendingChanges(favoriteAdvertsServiceInteractorImpl).doOnSubscribe(new z(this)).doOnSuccess(new f3(0, this)).ignoreElement().doOnError(new a0(this));
                Intrinsics.checkNotNullExpressionValue(doOnError, "uploadPendingChanges()\n …tsSyncEvent.Failed(it)) }");
                FavoriteAdvertsServiceInteractorImpl.access$subscribeWithErrorHandling(favoriteAdvertsServiceInteractorImpl, doOnError, "Failed to upload favorites");
                return;
            }
            FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl2 = this.a;
            Completable ignoreElement = FavoriteAdvertsServiceInteractorImpl.access$purgeRemovedAdverts(favoriteAdvertsServiceInteractorImpl2).doOnSuccess(new f3(1, this)).ignoreElement();
            Intrinsics.checkNotNullExpressionValue(ignoreElement, "purgeRemovedAdverts()\n  …         .ignoreElement()");
            FavoriteAdvertsServiceInteractorImpl.access$subscribeWithErrorHandling(favoriteAdvertsServiceInteractorImpl2, ignoreElement, "Failed to delete removed adverts");
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public f(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.g.track(new NonFatalError("Failed to get authorization state", th, null, 4, null));
        }
    }

    public static final class g<V> implements Callable<Object> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public g(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.c.wipe();
            this.a.d.wipe();
            return Unit.INSTANCE;
        }
    }

    public static final class h<V> implements Callable<List<? extends String>> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public h(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends String> call() {
            return this.a.c.getMarkedForRemoveIds();
        }
    }

    public static final class i<T, R> implements Function<List<? extends String>, SingleSource<? extends Integer>> {
        public final /* synthetic */ FavoriteAdvertsServiceInteractorImpl a;

        public i(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
            this.a = favoriteAdvertsServiceInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Integer> apply(List<? extends String> list) {
            List<? extends String> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "ids");
            if (!list2.isEmpty()) {
                return this.a.a.removeFromFavorites(CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, null, 62, null)).firstOrError().map(new p0(this, list2));
            }
            return Single.just(Integer.valueOf(list2.size()));
        }
    }

    @Inject
    public FavoriteAdvertsServiceInteractorImpl(@NotNull FavoritesApi favoritesApi, @NotNull AccountStateProvider accountStateProvider, @NotNull FavoritesSyncDao favoritesSyncDao, @NotNull FavoriteItemsDao favoriteItemsDao, @NotNull MutableFavoriteStorage mutableFavoriteStorage, @NotNull TimeSource timeSource, @NotNull Analytics analytics, @NotNull FavoriteAdvertsSyncEventInteractor favoriteAdvertsSyncEventInteractor, @NotNull FavoriteAdvertItemConverter favoriteAdvertItemConverter) {
        Intrinsics.checkNotNullParameter(favoritesApi, "api");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(favoritesSyncDao, "syncDao");
        Intrinsics.checkNotNullParameter(favoriteItemsDao, "advertsDao");
        Intrinsics.checkNotNullParameter(mutableFavoriteStorage, "favoriteStorage");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncEventInteractor, "syncEventInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertItemConverter, "converter");
        this.a = favoritesApi;
        this.b = accountStateProvider;
        this.c = favoritesSyncDao;
        this.d = favoriteItemsDao;
        this.e = mutableFavoriteStorage;
        this.f = timeSource;
        this.g = analytics;
        this.h = favoriteAdvertsSyncEventInteractor;
        this.i = favoriteAdvertItemConverter;
    }

    public static final Single access$purgeRemovedAdverts(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsServiceInteractorImpl);
        Single fromCallable = Single.fromCallable(new b0(favoriteAdvertsServiceInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …       ids.size\n        }");
        return fromCallable;
    }

    public static final void access$reportEvent(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl, FavoriteAdvertsSyncEvent favoriteAdvertsSyncEvent) {
        favoriteAdvertsServiceInteractorImpl.h.acceptEvent(favoriteAdvertsSyncEvent);
    }

    public static final void access$saveFavoriteItemsToAdvertsDao(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl, List list) {
        favoriteAdvertsServiceInteractorImpl.d.wipeAndSave(list);
    }

    public static final void access$subscribeWithErrorHandling(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl, Completable completable, String str) {
        Objects.requireNonNull(favoriteAdvertsServiceInteractorImpl);
        completable.subscribe(c0.a, new d0(favoriteAdvertsServiceInteractorImpl, str));
    }

    public static final Completable access$updateFavoriteAdverts(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsServiceInteractorImpl);
        Completable flatMapCompletable = Single.fromCallable(new e0(favoriteAdvertsServiceInteractorImpl)).filter(f0.a).flatMapObservable(new i0(favoriteAdvertsServiceInteractorImpl)).flatMapCompletable(j0.a);
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.fromCallable { sy… Completable.complete() }");
        return flatMapCompletable;
    }

    public static final void access$updateLastSyncTime(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        favoriteAdvertsServiceInteractorImpl.e.saveFavoritesLastUpdateDate(favoriteAdvertsServiceInteractorImpl.f.now());
    }

    public static final Single access$uploadPendingChanges(FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsServiceInteractorImpl);
        Single flatMap = Single.fromCallable(new k0(favoriteAdvertsServiceInteractorImpl)).flatMap(new m0(favoriteAdvertsServiceInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Single.fromCallable { sy…          }\n            }");
        Single flatMap2 = flatMap.flatMap(new o0(favoriteAdvertsServiceInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(flatMap2, "uploadNotSyncedIds()\n   …d + added }\n            }");
        return flatMap2;
    }

    public final Single<Integer> a() {
        Single<Integer> flatMap = Single.fromCallable(new h(this)).flatMap(new i(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Single.fromCallable { sy…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsServiceInteractor
    public void onSynchronize() {
        Completable doOnError = this.b.currentAuthorized().flatMapCompletable(new a(this)).doOnSubscribe(new b(this)).doOnComplete(new c(this)).doOnError(new d(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "accountStateProvider.cur…          }\n            }");
        doOnError.subscribe(c0.a, new d0(this, "Failed to synchronize favorites"));
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsServiceInteractor
    @SuppressLint({"CheckResult"})
    public void onUpload() {
        this.b.currentAuthorized().subscribe(new e(this), new f(this));
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsServiceInteractor
    public void onUploadRemovedItems() {
        Completable ignoreElement = a().ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "uploadRemovedIds()\n            .ignoreElement()");
        ignoreElement.subscribe(c0.a, new d0(this, "Failed to synchronize removed items"));
    }

    @Override // com.avito.android.favorites.FavoriteAdvertsServiceInteractor
    public void onWipe() {
        Completable fromCallable = Completable.fromCallable(new g(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…vertsDao.wipe()\n        }");
        fromCallable.subscribe(c0.a, new d0(this, "Failed to wipe favorites"));
    }
}
