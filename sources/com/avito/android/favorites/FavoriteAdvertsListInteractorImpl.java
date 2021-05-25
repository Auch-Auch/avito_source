package com.avito.android.favorites;

import a2.a.a.t0.w;
import a2.a.a.t0.x;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.favorite.FavoriteAdvertsEvent;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.FavoriteAdvertsSyncEvent;
import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItem;
import com.avito.android.favorites.di.Favorites;
import com.avito.android.favorites.event.FavoriteListUpdateEvent;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.FavoritesLoadingResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bk\b\u0007\u0012\u0006\u0010@\u001a\u00020>\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u00109\u001a\u000206\u0012\b\b\u0001\u0010P\u001a\u00020M\u0012\u0006\u0010X\u001a\u00020U¢\u0006\u0004\b]\u0010^J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000e\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b&\u0010'J!\u0010+\u001a\u00020\u00182\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u00182\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b-\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsListInteractorImpl;", "Lcom/avito/android/favorites/FavoritesListInteractor;", "Lio/reactivex/Observable;", "", AuthSource.SEND_ABUSE, "()Lio/reactivex/Observable;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent;", "favoriteUpdateEvents", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "getFavorites", "withUploadingChanges", "Lcom/avito/android/favorites/FavoritesLoadingModel;", "loadFavorites", "(Z)Lio/reactivex/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Observable;", "", "removeAllAdverts", "removeAllAdvertsWithPaging", "removeInactiveAdverts", "removeInactiveAdvertsWithPaging", "Lio/reactivex/Completable;", "markAsViewed", "()Lio/reactivex/Completable;", "", "getFavoritesLastUpdateDate", "()J", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "counterChanges", "resetCounter", "()V", "Lio/reactivex/Single;", "hasNotSyncedItems", "()Lio/reactivex/Single;", "", "id", "context", "markForRemove", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "clearMarkForRemove", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", a2.g.r.g.a, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/favorites/remote/FavoritesApi;", "c", "Lcom/avito/android/favorites/remote/FavoritesApi;", "api", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "j", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "converter", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "f", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "eventInteractor", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "eventProvider", "Lcom/avito/android/db/favorites/FavoriteItemsDao;", "d", "Lcom/avito/android/db/favorites/FavoriteItemsDao;", "itemsDao", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "e", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "syncDao", "Lcom/avito/android/favorites/FavoriteStorage;", "h", "Lcom/avito/android/favorites/FavoriteStorage;", "favoriteStorage", "Lcom/avito/android/common/CounterInteractor;", "k", "Lcom/avito/android/common/CounterInteractor;", "favoritesCounterInteractor", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/Features;", "l", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/favorites/remote/FavoritesApi;Lcom/avito/android/db/favorites/FavoriteItemsDao;Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/favorites/FavoriteStorage;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/favorites/FavoriteAdvertItemConverter;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/Features;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsListInteractorImpl implements FavoritesListInteractor {
    public final FavoriteAdvertsSyncEventProvider a;
    public final AccountStateProvider b;
    public final FavoritesApi c;
    public final FavoriteItemsDao d;
    public final FavoritesSyncDao e;
    public final FavoriteAdvertsEventInteractor f;
    public final TypedErrorThrowableConverter g;
    public final FavoriteStorage h;
    public final SchedulersFactory i;
    public final FavoriteAdvertItemConverter j;
    public final CounterInteractor k;
    public final Features l;

    public static final class a implements Action {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;
        public final /* synthetic */ String b;

        public a(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, String str) {
            this.a = favoriteAdvertsListInteractorImpl;
            this.b = str;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.e.clearMarkForRemove(this.b, true);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, String str, String str2) {
            this.a = favoriteAdvertsListInteractorImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            FavoriteAdvertsListInteractorImpl.access$reportAddedToFavorites(this.a, t6.n.d.listOf(this.b), this.c);
        }
    }

    public static final class c<T, R> implements Function<FavoriteAdvertsSyncEvent, FavoriteListUpdateEvent> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public FavoriteListUpdateEvent apply(FavoriteAdvertsSyncEvent favoriteAdvertsSyncEvent) {
            FavoriteListUpdateEvent updateError;
            FavoriteAdvertsSyncEvent favoriteAdvertsSyncEvent2 = favoriteAdvertsSyncEvent;
            Intrinsics.checkNotNullParameter(favoriteAdvertsSyncEvent2, "it");
            if (favoriteAdvertsSyncEvent2 instanceof FavoriteAdvertsSyncEvent.Started) {
                return FavoriteListUpdateEvent.UpdateStarted.INSTANCE;
            }
            if (favoriteAdvertsSyncEvent2 instanceof FavoriteAdvertsSyncEvent.Completed) {
                updateError = new FavoriteListUpdateEvent.UpdateFinished(((FavoriteAdvertsSyncEvent.Completed) favoriteAdvertsSyncEvent2).getId());
            } else if (favoriteAdvertsSyncEvent2 instanceof FavoriteAdvertsSyncEvent.Failed) {
                updateError = new FavoriteListUpdateEvent.UpdateError(((FavoriteAdvertsSyncEvent.Failed) favoriteAdvertsSyncEvent2).getReason());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return updateError;
        }
    }

    public static final class d<V> implements Callable<FavoriteAdvertsDataSource> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public d(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public FavoriteAdvertsDataSource call() {
            return new FavoriteAdvertsDataSource(this.a.d.getAdvertsDataSource());
        }
    }

    public static final class e<T, R> implements Function<FavoriteAdvertsDataSource, LoadingState<? super CloseableDataSource<FavoriteListItem>>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CloseableDataSource<FavoriteListItem>> apply(FavoriteAdvertsDataSource favoriteAdvertsDataSource) {
            FavoriteAdvertsDataSource favoriteAdvertsDataSource2 = favoriteAdvertsDataSource;
            Intrinsics.checkNotNullParameter(favoriteAdvertsDataSource2, "it");
            return new LoadingState.Loaded(favoriteAdvertsDataSource2);
        }
    }

    public static final class f<T, R> implements Function<Throwable, LoadingState<? super CloseableDataSource<FavoriteListItem>>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public f(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CloseableDataSource<FavoriteListItem>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.g.convert(th2));
        }
    }

    public static final class g<V> implements Callable<List<? extends String>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public g(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends String> call() {
            return this.a.e.getAddedToFavoritesIds();
        }
    }

    public static final class h<T, R> implements Function<List<? extends String>, Boolean> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(List<? extends String> list) {
            List<? extends String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return Boolean.valueOf(!list2.isEmpty());
        }
    }

    public static final class i<T, R> implements Function<Unit, ObservableSource<? extends TypedResult<FavoritesLoadingResult>>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public i(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<FavoritesLoadingResult>> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return InteropKt.toV2(this.a.c.getFavoritesV3());
        }
    }

    public static final class j<T, R> implements Function<TypedResult<FavoritesLoadingResult>, ObservableSource<? extends TypedResult<FavoritesLoadingResult>>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public j(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<FavoritesLoadingResult>> apply(TypedResult<FavoritesLoadingResult> typedResult) {
            TypedResult<FavoritesLoadingResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (this.a.l.getFavouriteAdvertsCounter().invoke().booleanValue()) {
                return InteropKt.toV2(this.a.k.executeUpdate()).andThen(Observable.just(typedResult2));
            }
            return Observable.just(typedResult2);
        }
    }

    public static final class k<T, R> implements Function<FavoritesLoadingResult, LoadingState<? super FavoritesLoadingModel>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public k(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super FavoritesLoadingModel> apply(FavoritesLoadingResult favoritesLoadingResult) {
            FavoritesLoadingResult favoritesLoadingResult2 = favoritesLoadingResult;
            Intrinsics.checkNotNullParameter(favoritesLoadingResult2, "it");
            return FavoriteAdvertsListInteractorImpl.access$convertLoadingResult(this.a, favoritesLoadingResult2);
        }
    }

    public static final class l<T, R> implements Function<Throwable, LoadingState<? super FavoritesLoadingModel>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public l(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super FavoritesLoadingModel> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.g.convert(th2));
        }
    }

    public static final class m<T, R> implements Function<FavoritesLoadingResult, LoadingState<? super FavoritesLoadingModel>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public m(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super FavoritesLoadingModel> apply(FavoritesLoadingResult favoritesLoadingResult) {
            FavoritesLoadingResult favoritesLoadingResult2 = favoritesLoadingResult;
            Intrinsics.checkNotNullParameter(favoritesLoadingResult2, "it");
            return FavoriteAdvertsListInteractorImpl.access$convertLoadingResult(this.a, favoritesLoadingResult2);
        }
    }

    public static final class n<T, R> implements Function<Throwable, LoadingState<? super FavoritesLoadingModel>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public n(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super FavoritesLoadingModel> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.g.convert(th2));
        }
    }

    public static final class o implements Action {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;
        public final /* synthetic */ String b;

        public o(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, String str) {
            this.a = favoriteAdvertsListInteractorImpl;
            this.b = str;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.e.markForRemove(this.b);
        }
    }

    public static final class p implements Action {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public p(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, String str, String str2) {
            this.a = favoriteAdvertsListInteractorImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            FavoriteAdvertsListInteractorImpl.access$reportRemovedFromFavorites(this.a, t6.n.d.listOf(this.b), this.c);
        }
    }

    public static final class q<T, R> implements Function<Boolean, ObservableSource<? extends Unit>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public q(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isLogged");
            return FavoriteAdvertsListInteractorImpl.access$getAllIds(this.a).flatMap(new a2.a.a.t0.f(this, bool2));
        }
    }

    public static final class r<T, R> implements Function<Boolean, ObservableSource<? extends Unit>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public r(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Boolean bool) {
            Observable<R> observable;
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isLogged");
            if (bool2.booleanValue()) {
                observable = InteropKt.toV2(this.a.c.clearFavorites()).map(new a2.a.a.t0.g(this));
            } else {
                observable = FavoriteAdvertsListInteractorImpl.access$getAllIds(this.a).doOnNext(new a2.a.a.t0.h(this));
            }
            return observable.doOnNext(new a2.a.a.t0.i(this)).map(a2.a.a.t0.j.a).subscribeOn(this.a.i.io());
        }
    }

    public static final class s<T, R> implements Function<Boolean, ObservableSource<? extends Unit>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public s(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isLogged");
            return FavoriteAdvertsListInteractorImpl.access$getInactiveIds(this.a).flatMap(new a2.a.a.t0.m(this, bool2));
        }
    }

    public static final class t<T, R> implements Function<Boolean, ObservableSource<? extends Unit>> {
        public final /* synthetic */ FavoriteAdvertsListInteractorImpl a;

        public t(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
            this.a = favoriteAdvertsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Boolean bool) {
            Observable<R> observable;
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isLogged");
            if (bool2.booleanValue()) {
                observable = InteropKt.toV2(this.a.c.removeInactiveFavorites()).map(new a2.a.a.t0.n(this));
            } else {
                observable = FavoriteAdvertsListInteractorImpl.access$getInactiveIds(this.a).doOnNext(new v0(0, this));
            }
            return observable.doOnNext(new v0(1, this)).map(a2.a.a.t0.o.a).subscribeOn(this.a.i.io());
        }
    }

    @Inject
    public FavoriteAdvertsListInteractorImpl(@NotNull FavoriteAdvertsSyncEventProvider favoriteAdvertsSyncEventProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull FavoritesApi favoritesApi, @NotNull FavoriteItemsDao favoriteItemsDao, @NotNull FavoritesSyncDao favoritesSyncDao, @NotNull FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull FavoriteStorage favoriteStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull FavoriteAdvertItemConverter favoriteAdvertItemConverter, @Favorites @NotNull CounterInteractor counterInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncEventProvider, "eventProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(favoritesApi, "api");
        Intrinsics.checkNotNullParameter(favoriteItemsDao, "itemsDao");
        Intrinsics.checkNotNullParameter(favoritesSyncDao, "syncDao");
        Intrinsics.checkNotNullParameter(favoriteAdvertsEventInteractor, "eventInteractor");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(favoriteStorage, "favoriteStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(favoriteAdvertItemConverter, "converter");
        Intrinsics.checkNotNullParameter(counterInteractor, "favoritesCounterInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = favoriteAdvertsSyncEventProvider;
        this.b = accountStateProvider;
        this.c = favoritesApi;
        this.d = favoriteItemsDao;
        this.e = favoritesSyncDao;
        this.f = favoriteAdvertsEventInteractor;
        this.g = typedErrorThrowableConverter;
        this.h = favoriteStorage;
        this.i = schedulersFactory;
        this.j = favoriteAdvertItemConverter;
        this.k = counterInteractor;
        this.l = features;
    }

    public static final LoadingState access$convertLoadingResult(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, FavoritesLoadingResult favoritesLoadingResult) {
        FavoriteLoadingItem favoriteLoadingItem;
        Objects.requireNonNull(favoriteAdvertsListInteractorImpl);
        if (favoritesLoadingResult instanceof FavoritesLoadingResult.Ok) {
            List<String> markedForRemoveIds = favoriteAdvertsListInteractorImpl.e.getMarkedForRemoveIds();
            FavoritesLoadingResult.Ok ok = (FavoritesLoadingResult.Ok) favoritesLoadingResult;
            List<FavoriteModel> convert = favoriteAdvertsListInteractorImpl.j.convert(ok.getResponse().getFavorites(), ok.getResponse().getReferences());
            ArrayList arrayList = new ArrayList();
            for (T t2 : convert) {
                if (!markedForRemoveIds.contains(t2.getAdvertId())) {
                    arrayList.add(t2);
                }
            }
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(FavoriteAdvertItem.Companion.fromFavoriteModel((FavoriteModel) it.next()));
            }
            String nextPage = ok.getResponse().getNextPage();
            if (nextPage != null) {
                Uri parse = Uri.parse(nextPage);
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it)");
                favoriteLoadingItem = new FavoriteLoadingItem(parse);
            } else {
                favoriteLoadingItem = null;
            }
            return new LoadingState.Loaded(new FavoritesLoadingModel(arrayList2, favoriteLoadingItem));
        } else if (favoritesLoadingResult instanceof FavoritesLoadingResult.ListExpiredError) {
            return new LoadingState.Error((TypedError) favoritesLoadingResult);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final Observable access$getAllIds(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsListInteractorImpl);
        Observable fromCallable = Observable.fromCallable(new a2.a.a.t0.a(favoriteAdvertsListInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable ….getActiveIds()\n        }");
        return fromCallable;
    }

    public static final Observable access$getInactiveIds(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsListInteractorImpl);
        Observable fromCallable = Observable.fromCallable(new a2.a.a.t0.b(favoriteAdvertsListInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …etInactiveIds()\n        }");
        return fromCallable;
    }

    public static final Observable access$removeAdverts(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, List list) {
        Objects.requireNonNull(favoriteAdvertsListInteractorImpl);
        Observable fromCallable = Observable.fromCallable(new a2.a.a.t0.c(favoriteAdvertsListInteractorImpl, list));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …Dao.remove(ids)\n        }");
        return fromCallable;
    }

    public static final void access$reportAddedToFavorites(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, List list, String str) {
        favoriteAdvertsListInteractorImpl.f.acceptEvent(new FavoriteAdvertsEvent.AddedToFavorites(list, new FavoriteActionSource.Favorites(str)));
    }

    public static final void access$reportRemovedFromFavorites(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl, List list, String str) {
        favoriteAdvertsListInteractorImpl.f.acceptEvent(new FavoriteAdvertsEvent.RemovedFromFavorites(list, new FavoriteActionSource.Favorites(str)));
    }

    public static final Single access$uploadRemovedIds(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsListInteractorImpl);
        Single flatMap = Single.fromCallable(new a2.a.a.t0.t(favoriteAdvertsListInteractorImpl)).flatMap(new w(favoriteAdvertsListInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Single.fromCallable { sy…          }\n            }");
        return flatMap;
    }

    public static final Observable access$wipeLocalAdverts(FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl) {
        Objects.requireNonNull(favoriteAdvertsListInteractorImpl);
        Observable fromCallable = Observable.fromCallable(new x(favoriteAdvertsListInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable … syncDao.wipe()\n        }");
        return fromCallable;
    }

    public final Observable<Boolean> a() {
        Observable<Boolean> observable = InteropKt.toV2(this.b.currentAuthorized()).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "accountStateProvider.cur…d().toV2().toObservable()");
        return observable;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Completable clearMarkForRemove(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Completable doOnComplete = Completable.fromAction(new a(this, str)).subscribeOn(this.i.io()).observeOn(this.i.mainThread()).doOnComplete(new b(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "Completable.fromAction {…es(listOf(id), context) }");
        return doOnComplete;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<Integer> counterChanges() {
        return InteropKt.toV2(this.k.changes());
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<FavoriteListUpdateEvent> favoriteUpdateEvents() {
        Observable<FavoriteListUpdateEvent> map = InteropKt.toV2(this.a.observeEvents()).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "eventProvider.observeEve…          }\n            }");
        return map;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<LoadingState<CloseableDataSource<FavoriteListItem>>> getFavorites() {
        return a2.b.a.a.a.S1(this.i, Observable.fromCallable(new d(this)).map(e.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new f(this)), "Observable.fromCallable …scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    public long getFavoritesLastUpdateDate() {
        return this.h.getFavoritesLastUpdateDate();
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Single<Boolean> hasNotSyncedItems() {
        Single<Boolean> map = Single.fromCallable(new g(this)).map(h.a);
        Intrinsics.checkNotNullExpressionValue(map, "Single.fromCallable { sy…}.map { it.isNotEmpty() }");
        return map;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<LoadingState<FavoritesLoadingModel>> loadFavorites(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        FavoritesApi favoritesApi = this.c;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable subscribeOn = InteropKt.toV2(favoritesApi.getFavoritesV3(uri2)).subscribeOn(this.i.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getFavoritesV3(nextP…scribeOn(schedulers.io())");
        Observable<LoadingState<FavoritesLoadingModel>> onErrorReturn = TypedObservablesKt.toTyped(subscribeOn).map(new m(this)).onErrorReturn(new n(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getFavoritesV3(nextP…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Completable markAsViewed() {
        Observable subscribeOn = InteropKt.toV2(this.c.clearFavoritesCount()).subscribeOn(this.i.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.clearFavoritesCount(…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.clearFavoritesCount(…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Completable markForRemove(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Completable doOnComplete = Completable.fromAction(new o(this, str)).subscribeOn(this.i.io()).observeOn(this.i.mainThread()).doOnComplete(new p(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "Completable.fromAction {…es(listOf(id), context) }");
        return doOnComplete;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Kundle onSaveState() {
        return Kundle.Companion.getEMPTY();
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<Unit> removeAllAdverts() {
        return a2.b.a.a.a.S1(this.i, a().switchMap(new q(this)), "isLogged().switchMap { i…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<Unit> removeAllAdvertsWithPaging() {
        Observable<R> switchMap = a().switchMap(new r(this));
        Intrinsics.checkNotNullExpressionValue(switchMap, "isLogged().switchMap { i…chedulers.io())\n        }");
        return switchMap;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<Unit> removeInactiveAdverts() {
        return a2.b.a.a.a.S1(this.i, a().switchMap(new s(this)), "isLogged().switchMap { i…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<Unit> removeInactiveAdvertsWithPaging() {
        Observable<R> switchMap = a().switchMap(new t(this));
        Intrinsics.checkNotNullExpressionValue(switchMap, "isLogged().switchMap { i…chedulers.io())\n        }");
        return switchMap;
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    public void resetCounter() {
        this.k.reset();
    }

    @Override // com.avito.android.favorites.FavoritesListInteractor
    @NotNull
    public Observable<LoadingState<FavoritesLoadingModel>> loadFavorites(boolean z) {
        Single single;
        if (z) {
            Single flatMap = Single.fromCallable(new a2.a.a.t0.p(this)).flatMap(new a2.a.a.t0.r(this));
            Intrinsics.checkNotNullExpressionValue(flatMap, "Single.fromCallable { sy…          }\n            }");
            single = flatMap.flatMap(new a2.a.a.t0.s(this));
            Intrinsics.checkNotNullExpressionValue(single, "uploadAddedIds().flatMap { uploadRemovedIds() }");
        } else {
            single = Singles.toSingle(Unit.INSTANCE);
        }
        Observable concatMap = single.flatMapObservable(new i(this)).concatMap(new j(this));
        Intrinsics.checkNotNullExpressionValue(concatMap, "if (withUploadingChanges…          }\n            }");
        Observable<LoadingState<FavoritesLoadingModel>> onErrorReturn = TypedObservablesKt.toTyped(concatMap).map(new k(this)).subscribeOn(this.i.io()).onErrorReturn(new l(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "if (withUploadingChanges…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
