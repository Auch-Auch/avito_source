package com.avito.android.favorites;

import a2.a.a.t0.q0;
import a2.a.a.t0.r0;
import a2.a.a.t0.s0;
import a2.a.a.t0.t0;
import a2.a.a.t0.u0;
import a2.a.a.t0.v0;
import a2.a.a.t0.w0;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoritesListPresenter;
import com.avito.android.favorites.FavoritesView;
import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItem;
import com.avito.android.favorites.event.FavoriteListUpdateEvent;
import com.avito.android.favorites.events.BuyerAsksSellerTtlItemEvent;
import com.avito.android.favorites.events.ClickOnMoreActionsEvent;
import com.avito.android.favorites.events.ClickOnSimilarEvent;
import com.avito.android.favorites.tracker.FavoritesTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.FavoritesLoadingResult;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010~\u001a\u00020{\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010t\u001a\u00020q\u0012\u0006\u0010j\u001a\u00020g\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010Z\u001a\u00020W\u0012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010J\u001a\u00020G\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010&\u0012\u0006\u0010o\u001a\u00020l¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J!\u0010$\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u0004J#\u0010-\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u0015H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0002H\u0002¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u0010\u0004J\u0019\u00101\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u0015H\u0002¢\u0006\u0004\b1\u0010 J\u000f\u00102\u001a\u00020\u0002H\u0002¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0002H\u0002¢\u0006\u0004\b4\u0010\u0004R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010R\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010=R\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010=R\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010eR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010uR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010wR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010yR\u0016\u0010z\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010=R\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R \u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000108\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/favorites/FavoritesListPresenterImpl;", "Lcom/avito/android/favorites/FavoritesListPresenter;", "", "onPullRefresh", "()V", "onRetry", "Lcom/avito/android/favorites/FavoritesView;", "view", "attachView", "(Lcom/avito/android/favorites/FavoritesView;)V", "detachView", "onRemoveAllClicked", "onRemoveInactiveClicked", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "item", "onRemoveItemClicked", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;)V", "", "itemId", "onClickMoreItemActions", "(Ljava/lang/String;)V", "", "isShop", "onClickSimilar", "(Ljava/lang/String;Z)V", "onAskSellerAboutItem", "Lcom/avito/android/favorites/FavoritesListPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/favorites/FavoritesListPresenter$Router;)V", "isVisible", "onVisibilityChanged", "(Z)V", "detachRouter", "Lcom/avito/android/remote/model/Image;", "image", "onFavoriteItemClicked", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;Lcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onRestoreState", "i", "showProgress", "withUploadingChanges", AuthSource.BOOKING_ORDER, "(ZZ)V", "h", "d", "e", "f", a2.g.r.g.a, AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadingDisposable", "Lcom/avito/android/analytics/Analytics;", "t", "Lcom/avito/android/analytics/Analytics;", "analytics", "k", "Z", "isLoading", "Lcom/avito/android/favorites/tracker/FavoritesTracker;", "s", "Lcom/avito/android/favorites/tracker/FavoritesTracker;", "tracker", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "o", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/favorites/FavoritesListStorage;", "x", "Lcom/avito/android/favorites/FavoritesListStorage;", "favoritesListStorage", "Lcom/avito/android/util/ErrorFormatter;", "w", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "Lcom/avito/android/remote/model/CloseableDataSource;", "lastDataSource", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/account/AccountStateProvider;", "u", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "p", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteAdvertsInteractor", "l", "Ljava/lang/String;", "lastCompletedEventId", "j", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "visibleDisposables", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "r", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "updateInProgress", "Lcom/avito/android/Features;", "y", "Lcom/avito/android/Features;", "features", "disposable", "Lcom/avito/android/favorites/FavoriteListResourceProvider;", VKApiConst.Q, "Lcom/avito/android/favorites/FavoriteListResourceProvider;", "resourcesProvider", "Lcom/avito/android/favorites/FavoritesListPresenter$Router;", "", "Ljava/util/List;", "items", "Lcom/avito/android/favorites/FavoritesView;", "isItemsViewed", "Lcom/avito/android/favorites/FavoritesListInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/favorites/FavoritesListInteractor;", "interactor", "Lio/reactivex/Observable;", "Lcom/avito/android/favorites/action/FavoriteItemAction;", VKApiConst.VERSION, "Lio/reactivex/Observable;", "itemActions", "state", "<init>", "(Lcom/avito/android/favorites/FavoritesListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/favorites/FavoriteListResourceProvider;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/favorites/tracker/FavoritesTracker;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;Lio/reactivex/Observable;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/favorites/FavoritesListStorage;Lcom/avito/android/util/Kundle;Lcom/avito/android/Features;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesListPresenterImpl implements FavoritesListPresenter {
    public CompositeDisposable a = new CompositeDisposable();
    public Disposable b;
    public CompositeDisposable c = new CompositeDisposable();
    public FavoritesView d;
    public FavoritesListPresenter.Router e;
    public CloseableDataSource<FavoriteListItem> f;
    public List<? extends FavoriteListItem> g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public final FavoritesListInteractor m;
    public final SchedulersFactory n;
    public final AdapterPresenter o;
    public final FavoriteAdvertsInteractor p;
    public final FavoriteListResourceProvider q;
    public final TreeStateIdGenerator r;
    public final FavoritesTracker s;
    public final Analytics t;
    public final AccountStateProvider u;
    public final Observable<FavoriteItemAction> v;
    public final ErrorFormatter w;
    public final FavoritesListStorage x;
    public final Features y;

    public static final class a<T> implements Consumer<FavoriteItemAction> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public a(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x003a */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x003a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Consumer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(com.avito.android.favorites.action.FavoriteItemAction r6) {
            /*
                r5 = this;
                com.avito.android.favorites.action.FavoriteItemAction r6 = (com.avito.android.favorites.action.FavoriteItemAction) r6
                boolean r0 = r6 instanceof com.avito.android.favorites.adapter.loading.action.LoadingNextFavoriteItemAction
                if (r0 == 0) goto L_0x0012
                com.avito.android.favorites.FavoritesListPresenterImpl r0 = r5.a
                com.avito.android.favorites.adapter.loading.action.LoadingNextFavoriteItemAction r6 = (com.avito.android.favorites.adapter.loading.action.LoadingNextFavoriteItemAction) r6
                android.net.Uri r6 = r6.getNextPage()
                com.avito.android.favorites.FavoritesListPresenterImpl.access$loadFavoritesNextItems(r0, r6)
                goto L_0x0058
            L_0x0012:
                boolean r0 = r6 instanceof com.avito.android.favorites.adapter.error.action.FavoriteErrorItemAction
                if (r0 == 0) goto L_0x0058
                com.avito.android.favorites.FavoritesListPresenterImpl r0 = r5.a
                java.util.List r1 = com.avito.android.favorites.FavoritesListPresenterImpl.access$getItems$p(r0)
                if (r1 == 0) goto L_0x0039
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r1 = r1.iterator()
            L_0x0027:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x003a
                java.lang.Object r3 = r1.next()
                boolean r4 = r3 instanceof com.avito.android.favorites.adapter.advert.FavoriteAdvertItem
                if (r4 == 0) goto L_0x0027
                r2.add(r3)
                goto L_0x0027
            L_0x0039:
                r2 = 0
            L_0x003a:
                if (r2 == 0) goto L_0x003d
                goto L_0x0041
            L_0x003d:
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0041:
                com.avito.android.favorites.adapter.loading.FavoriteLoadingItem r1 = new com.avito.android.favorites.adapter.loading.FavoriteLoadingItem
                com.avito.android.favorites.adapter.error.action.FavoriteErrorItemAction r6 = (com.avito.android.favorites.adapter.error.action.FavoriteErrorItemAction) r6
                android.net.Uri r6 = r6.getFailedUri()
                r1.<init>(r6)
                java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r2, r1)
                com.avito.android.favorites.FavoritesListPresenterImpl.access$setItems$p(r0, r6)
                com.avito.android.favorites.FavoritesListPresenterImpl r6 = r5.a
                com.avito.android.favorites.FavoritesListPresenterImpl.access$updateItems(r6)
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.FavoritesListPresenterImpl.a.accept(java.lang.Object):void");
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ FavoritesListPresenterImpl a;
        public final /* synthetic */ boolean b;

        public b(FavoritesListPresenterImpl favoritesListPresenterImpl, boolean z) {
            this.a = favoritesListPresenterImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            FavoritesView favoritesView = this.a.d;
            if (favoritesView != null) {
                favoritesView.dismissMessageWithAction();
            }
            this.a.k = true;
            if (this.b) {
                this.a.g();
            }
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super FavoritesLoadingModel>> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public c(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super FavoritesLoadingModel> loadingState) {
            this.a.i = false;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public d(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.k = false;
        }
    }

    public static final class e<T> implements Consumer<LoadingState<? super FavoritesLoadingModel>> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public e(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super FavoritesLoadingModel> loadingState) {
            LoadingState<? super FavoritesLoadingModel> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                FavoritesListPresenterImpl.access$handleLoadingSuccess(this.a, (LoadingState.Loaded) loadingState2);
            } else if (loadingState2 instanceof LoadingState.Error) {
                FavoritesListPresenterImpl.access$handleLoadingError(this.a, (LoadingState.Error) loadingState2);
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public g(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.i = true;
        }
    }

    public static final class h implements Action {
        public static final h a = new h();

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class j<T> implements Consumer<Unit> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public j(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            if (this.a.u.isAuthorized()) {
                FavoritesListPresenterImpl.c(this.a, false, false, 3);
                return;
            }
            FavoritesListPresenter.Router router = this.a.e;
            if (router != null) {
                router.startSync();
            }
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public k(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            FavoritesView favoritesView = this.a.d;
            if (favoritesView != null) {
                favoritesView.hideProgress();
            }
            FavoritesView favoritesView2 = this.a.d;
            if (favoritesView2 != null) {
                favoritesView2.showMessage(this.a.w.format(th2));
            }
        }
    }

    public static final class l<T> implements Consumer<Unit> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public l(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            if (this.a.u.isAuthorized()) {
                FavoritesListPresenterImpl.c(this.a, false, false, 3);
                return;
            }
            FavoritesListPresenter.Router router = this.a.e;
            if (router != null) {
                router.startSync();
            }
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public m(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            FavoritesView favoritesView = this.a.d;
            if (favoritesView != null) {
                favoritesView.hideProgress();
            }
            FavoritesView favoritesView2 = this.a.d;
            if (favoritesView2 != null) {
                favoritesView2.showMessage(this.a.w.format(th2));
            }
        }
    }

    public static final class n extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoritesListPresenterImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FavoriteAdvertItem c;
        public final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(FavoritesListPresenterImpl favoritesListPresenterImpl, int i, FavoriteAdvertItem favoriteAdvertItem, String str) {
            super(0);
            this.a = favoritesListPresenterImpl;
            this.b = i;
            this.c = favoriteAdvertItem;
            this.d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            List list = this.a.g;
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.avito.android.favorites.adapter.FavoriteListItem>");
            TypeIntrinsics.asMutableList(list).add(this.b, this.c);
            this.a.h();
            CompositeDisposable compositeDisposable = this.a.a;
            Disposable subscribe = this.a.m.clearMarkForRemove(this.c.getStringId(), this.d).subscribe(s0.a, t0.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.clearMarkForR…be({}) { Logs.error(it) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return Unit.INSTANCE;
        }
    }

    public static final class o implements Action {
        public static final o a = new o();

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class p<T> implements Consumer<Throwable> {
        public static final p a = new p();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class q extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoritesListPresenterImpl a;
        public final /* synthetic */ FavoriteAdvertItem b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(FavoritesListPresenterImpl favoritesListPresenterImpl, FavoriteAdvertItem favoriteAdvertItem, String str) {
            super(0);
            this.a = favoritesListPresenterImpl;
            this.b = favoriteAdvertItem;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            CompositeDisposable compositeDisposable = this.a.a;
            Single observeOn = InteropKt.toV2(this.a.p.toggleFavoriteStatus(this.b.getStringId(), new FavoriteActionSource.Favorites(this.c), false)).observeOn(this.a.n.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "favoriteAdvertsInteracto…lersFactory.mainThread())");
            DisposableKt.plusAssign(compositeDisposable, Singles.subscribeOnNext(observeOn, new u0(this)));
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            super(1);
            this.a = favoritesListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            this.a.i();
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function1<FavoriteListUpdateEvent, Unit> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            super(1);
            this.a = favoritesListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(FavoriteListUpdateEvent favoriteListUpdateEvent) {
            FavoriteListUpdateEvent favoriteListUpdateEvent2 = favoriteListUpdateEvent;
            FavoritesListPresenterImpl favoritesListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(favoriteListUpdateEvent2, "it");
            FavoritesListPresenterImpl.access$onFavoritesUpdated(favoritesListPresenterImpl, favoriteListUpdateEvent2);
            return Unit.INSTANCE;
        }
    }

    public static final class t<T> implements Predicate<Integer> {
        public static final t a = new t();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Integer num) {
            if (a2.b.a.a.a.f0(num, "it", 0) > 0) {
                return true;
            }
            return false;
        }
    }

    public static final class u<T> implements Consumer<Integer> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public u(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            this.a.m.resetCounter();
        }
    }

    public static final class v<T> implements Consumer<Throwable> {
        public static final v a = new v();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class w<T> implements Consumer<LoadingState<? super CloseableDataSource<FavoriteListItem>>> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public w(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super CloseableDataSource<FavoriteListItem>> loadingState) {
            LoadingState<? super CloseableDataSource<FavoriteListItem>> loadingState2 = loadingState;
            FavoritesListPresenterImpl favoritesListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            FavoritesListPresenterImpl.access$processLoadingEvent(favoritesListPresenterImpl, loadingState2);
        }
    }

    public static final class x<T> implements Consumer<Throwable> {
        public final /* synthetic */ FavoritesListPresenterImpl a;

        public x(FavoritesListPresenterImpl favoritesListPresenterImpl) {
            this.a = favoritesListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            FavoritesListPresenterImpl.access$processLoadingError(this.a);
        }
    }

    @Inject
    public FavoritesListPresenterImpl(@NotNull FavoritesListInteractor favoritesListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteListResourceProvider favoriteListResourceProvider, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull FavoritesTracker favoritesTracker, @NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider, @NotNull Observable<FavoriteItemAction> observable, @NotNull ErrorFormatter errorFormatter, @NotNull FavoritesListStorage favoritesListStorage, @Nullable Kundle kundle, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(favoritesListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoriteAdvertsInteractor");
        Intrinsics.checkNotNullParameter(favoriteListResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(favoritesTracker, "tracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(observable, "itemActions");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(favoritesListStorage, "favoritesListStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        this.m = favoritesListInteractor;
        this.n = schedulersFactory;
        this.o = adapterPresenter;
        this.p = favoriteAdvertsInteractor;
        this.q = favoriteListResourceProvider;
        this.r = treeStateIdGenerator;
        this.s = favoritesTracker;
        this.t = analytics;
        this.u = accountStateProvider;
        this.v = observable;
        this.w = errorFormatter;
        this.x = favoritesListStorage;
        this.y = features;
        this.i = kundle != null ? kundle.getBoolean("is_items_viewed", false) : false;
        this.l = kundle != null ? kundle.getString("sync_completed_event_id") : null;
    }

    public static final void access$handleLoadingError(FavoritesListPresenterImpl favoritesListPresenterImpl, LoadingState.Error error) {
        favoritesListPresenterImpl.a();
        FavoritesView favoritesView = favoritesListPresenterImpl.d;
        if (favoritesView != null) {
            favoritesView.setMenuVisibility(false);
        }
        TypedError error2 = error.getError();
        if (error2 instanceof FavoritesLoadingResult.ListExpiredError) {
            c(favoritesListPresenterImpl, false, false, 3);
        } else if (error2 instanceof ErrorWithMessage) {
            FavoritesView favoritesView2 = favoritesListPresenterImpl.d;
            if (favoritesView2 != null) {
                favoritesView2.showErrorOverlay(((ErrorWithMessage) error2).getMessage());
            }
            FavoritesView favoritesView3 = favoritesListPresenterImpl.d;
            if (favoritesView3 != null) {
                TypedError error3 = error.getError();
                Objects.requireNonNull(error3, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                favoritesView3.showMessage(((ErrorWithMessage) error3).getMessage());
            }
        } else {
            FavoritesView favoritesView4 = favoritesListPresenterImpl.d;
            if (favoritesView4 != null) {
                FavoritesView.DefaultImpls.showErrorOverlay$default(favoritesView4, null, 1, null);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0080 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0080 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$handleLoadingNextError(com.avito.android.favorites.FavoritesListPresenterImpl r4, com.avito.android.util.LoadingState.Error r5, android.net.Uri r6) {
        /*
            java.util.Objects.requireNonNull(r4)
            com.avito.android.remote.error.TypedError r0 = r5.getError()
            boolean r1 = r0 instanceof com.avito.android.remote.model.FavoritesLoadingResult.ListExpiredError
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r4.g = r2
            r5 = 3
            r6 = 0
            c(r4, r6, r6, r5)
            goto L_0x0094
        L_0x0015:
            boolean r0 = r0 instanceof com.avito.android.remote.error.ErrorWithMessage
            if (r0 == 0) goto L_0x0061
            com.avito.android.remote.error.TypedError r5 = r5.getError()
            java.lang.String r0 = "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage"
            java.util.Objects.requireNonNull(r5, r0)
            com.avito.android.remote.error.ErrorWithMessage r5 = (com.avito.android.remote.error.ErrorWithMessage) r5
            java.lang.String r5 = r5.getMessage()
            java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem> r0 = r4.g
            if (r0 == 0) goto L_0x0047
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0035:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            boolean r3 = r1 instanceof com.avito.android.favorites.adapter.advert.FavoriteAdvertItem
            if (r3 == 0) goto L_0x0035
            r2.add(r1)
            goto L_0x0035
        L_0x0047:
            if (r2 == 0) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x004e:
            com.avito.android.favorites.adapter.error.FavoriteErrorItem r0 = new com.avito.android.favorites.adapter.error.FavoriteErrorItem
            r0.<init>(r5, r6)
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r2, r0)
            r4.g = r6
            com.avito.android.favorites.FavoritesView r6 = r4.d
            if (r6 == 0) goto L_0x0094
            r6.showMessage(r5)
            goto L_0x0094
        L_0x0061:
            java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem> r5 = r4.g
            if (r5 == 0) goto L_0x0080
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x006e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r5.next()
            boolean r1 = r0 instanceof com.avito.android.favorites.adapter.advert.FavoriteAdvertItem
            if (r1 == 0) goto L_0x006e
            r2.add(r0)
            goto L_0x006e
        L_0x0080:
            if (r2 == 0) goto L_0x0083
            goto L_0x0087
        L_0x0083:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0087:
            com.avito.android.favorites.adapter.error.FavoriteErrorItem r5 = new com.avito.android.favorites.adapter.error.FavoriteErrorItem
            java.lang.String r0 = ""
            r5.<init>(r0, r6)
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r2, r5)
            r4.g = r5
        L_0x0094:
            r4.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.FavoritesListPresenterImpl.access$handleLoadingNextError(com.avito.android.favorites.FavoritesListPresenterImpl, com.avito.android.util.LoadingState$Error, android.net.Uri):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0045 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0045 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$handleLoadingNextSuccess(com.avito.android.favorites.FavoritesListPresenterImpl r4, com.avito.android.util.LoadingState.Loaded r5) {
        /*
            java.util.Objects.requireNonNull(r4)
            java.lang.Object r0 = r5.getData()
            com.avito.android.favorites.FavoritesLoadingModel r0 = (com.avito.android.favorites.FavoritesLoadingModel) r0
            java.util.List r0 = r0.getItems()
            java.lang.Object r5 = r5.getData()
            com.avito.android.favorites.FavoritesLoadingModel r5 = (com.avito.android.favorites.FavoritesLoadingModel) r5
            com.avito.android.favorites.adapter.loading.FavoriteLoadingItem r5 = r5.getNextItem()
            if (r5 == 0) goto L_0x0025
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.MutableList<com.avito.android.favorites.adapter.FavoriteListItem>"
            java.util.Objects.requireNonNull(r0, r1)
            java.util.List r1 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r0)
            r1.add(r5)
        L_0x0025:
            java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem> r5 = r4.g
            if (r5 == 0) goto L_0x0044
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0032:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0045
            java.lang.Object r2 = r5.next()
            boolean r3 = r2 instanceof com.avito.android.favorites.adapter.advert.FavoriteAdvertItem
            if (r3 == 0) goto L_0x0032
            r1.add(r2)
            goto L_0x0032
        L_0x0044:
            r1 = 0
        L_0x0045:
            if (r1 == 0) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x004c:
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r1, r0)
            r4.g = r5
            r4.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.FavoritesListPresenterImpl.access$handleLoadingNextSuccess(com.avito.android.favorites.FavoritesListPresenterImpl, com.avito.android.util.LoadingState$Loaded):void");
    }

    public static final void access$handleLoadingSuccess(FavoritesListPresenterImpl favoritesListPresenterImpl, LoadingState.Loaded loaded) {
        FavoritesView favoritesView = favoritesListPresenterImpl.d;
        if (favoritesView != null) {
            favoritesView.scrollToTop();
        }
        List<FavoriteListItem> items = ((FavoritesLoadingModel) loaded.getData()).getItems();
        Objects.requireNonNull(items, "null cannot be cast to non-null type kotlin.collections.MutableList<com.avito.android.favorites.adapter.FavoriteListItem>");
        List<? extends FavoriteListItem> asMutableList = TypeIntrinsics.asMutableList(items);
        FavoriteLoadingItem nextItem = ((FavoritesLoadingModel) loaded.getData()).getNextItem();
        if (nextItem != null) {
            asMutableList.add(nextItem);
        }
        favoritesListPresenterImpl.g = asMutableList;
        favoritesListPresenterImpl.a();
        favoritesListPresenterImpl.h();
        if (favoritesListPresenterImpl.j && favoritesListPresenterImpl.y.getFavouriteAdvertsCounter().invoke().booleanValue()) {
            favoritesListPresenterImpl.d();
        }
    }

    public static final void access$loadFavoritesNextItems(FavoritesListPresenterImpl favoritesListPresenterImpl, Uri uri) {
        Disposable disposable = favoritesListPresenterImpl.b;
        if (disposable != null) {
            disposable.dispose();
        }
        favoritesListPresenterImpl.b = favoritesListPresenterImpl.m.loadFavorites(uri).observeOn(favoritesListPresenterImpl.n.mainThread()).subscribe(new q0(favoritesListPresenterImpl, uri), r0.a);
    }

    public static final void access$onFavoritesUpdated(FavoritesListPresenterImpl favoritesListPresenterImpl, FavoriteListUpdateEvent favoriteListUpdateEvent) {
        FavoritesView favoritesView;
        favoritesListPresenterImpl.h = false;
        if (favoriteListUpdateEvent instanceof FavoriteListUpdateEvent.UpdateError) {
            favoritesListPresenterImpl.s.trackAdvertsLoadError();
            favoritesListPresenterImpl.s.startAdvertsDraw();
            String format = favoritesListPresenterImpl.w.format(((FavoriteListUpdateEvent.UpdateError) favoriteListUpdateEvent).getError());
            favoritesListPresenterImpl.a();
            if (favoritesListPresenterImpl.j && (favoritesView = favoritesListPresenterImpl.d) != null) {
                favoritesView.showMessage(format);
            }
            favoritesListPresenterImpl.s.trackAdvertsErrorDraw();
        } else if (favoriteListUpdateEvent instanceof FavoriteListUpdateEvent.UpdateFinished) {
            favoritesListPresenterImpl.s.trackAdvertsLoaded();
            favoritesListPresenterImpl.s.startAdvertsDraw();
            if (favoritesListPresenterImpl.u.isAuthorized()) {
                FavoriteListUpdateEvent.UpdateFinished updateFinished = (FavoriteListUpdateEvent.UpdateFinished) favoriteListUpdateEvent;
                if (!Intrinsics.areEqual(favoritesListPresenterImpl.l, updateFinished.getId())) {
                    favoritesListPresenterImpl.l = updateFinished.getId();
                    c(favoritesListPresenterImpl, false, false, 2);
                }
            } else {
                favoritesListPresenterImpl.i();
            }
            favoritesListPresenterImpl.s.trackAdvertsDraw();
        }
    }

    public static final void access$processLoadingError(FavoritesListPresenterImpl favoritesListPresenterImpl) {
        favoritesListPresenterImpl.a();
        FavoritesView favoritesView = favoritesListPresenterImpl.d;
        if (favoritesView != null) {
            FavoritesView.DefaultImpls.showErrorOverlay$default(favoritesView, null, 1, null);
        }
    }

    public static final void access$processLoadingEvent(FavoritesListPresenterImpl favoritesListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(favoritesListPresenterImpl);
        if (loadingState instanceof LoadingState.Error) {
            favoritesListPresenterImpl.a();
            FavoritesView favoritesView = favoritesListPresenterImpl.d;
            if (favoritesView != null) {
                FavoritesView.DefaultImpls.showErrorOverlay$default(favoritesView, null, 1, null);
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            CloseableDataSource<FavoriteListItem> closeableDataSource = (CloseableDataSource) ((LoadingState.Loaded) loadingState).getData();
            CloseableDataSource<FavoriteListItem> closeableDataSource2 = favoritesListPresenterImpl.f;
            if (closeableDataSource2 != null) {
                closeableDataSource2.close();
            }
            favoritesListPresenterImpl.f = closeableDataSource;
            favoritesListPresenterImpl.o.onDataSourceChanged(closeableDataSource);
            if (closeableDataSource.isEmpty()) {
                FavoritesView favoritesView2 = favoritesListPresenterImpl.d;
                if (favoritesView2 != null) {
                    favoritesView2.showEmptyView();
                }
            } else {
                FavoritesView favoritesView3 = favoritesListPresenterImpl.d;
                if (favoritesView3 != null) {
                    favoritesView3.hideEmptyView();
                }
            }
            FavoritesView favoritesView4 = favoritesListPresenterImpl.d;
            if (favoritesView4 != null) {
                favoritesView4.onDataChanged();
            }
            if (!closeableDataSource.isEmpty() || !favoritesListPresenterImpl.h) {
                favoritesListPresenterImpl.a();
            }
            favoritesListPresenterImpl.f();
        }
    }

    public static /* synthetic */ void c(FavoritesListPresenterImpl favoritesListPresenterImpl, boolean z, boolean z2, int i2) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        favoritesListPresenterImpl.b(z, z2);
    }

    public final void a() {
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.stopPullToRefresh();
        }
        FavoritesView favoritesView2 = this.d;
        if (favoritesView2 != null) {
            favoritesView2.hideProgress();
        }
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    public void attachRouter(@NotNull FavoritesListPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
        if (!this.u.isAuthorized()) {
            e(false);
        }
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    public void attachView(@NotNull FavoritesView favoritesView) {
        Intrinsics.checkNotNullParameter(favoritesView, "view");
        this.d = favoritesView;
        this.s.startAdvertsLoading();
        g();
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.v.subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemActions.subscribe { …}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        if (this.u.isAuthorized()) {
            if (this.g != null) {
                a();
                h();
            } else {
                c(this, false, false, 3);
            }
        }
        f();
    }

    public final void b(boolean z, boolean z2) {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = this.m.loadFavorites(z2).observeOn(this.n.mainThread()).doOnSubscribe(new b(this, z)).doOnNext(new c(this)).doOnTerminate(new d(this)).subscribe(new e(this), f.a);
    }

    public final void d() {
        if (this.u.isAuthorized()) {
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = this.m.markAsViewed().observeOn(this.n.mainThread()).doOnComplete(new g(this)).subscribe(h.a, i.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.markAsViewed(…e({}, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    public void detachView() {
        CloseableDataSource<FavoriteListItem> closeableDataSource = this.f;
        if (closeableDataSource != null) {
            closeableDataSource.close();
        }
        this.a.clear();
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
    }

    public final void e(boolean z) {
        if (z) {
            g();
        }
        this.h = true;
        FavoritesListPresenter.Router router = this.e;
        if (router != null) {
            router.startSync();
        }
    }

    public final void f() {
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.setMenuVisibility(this.o.getCount() > 0);
        }
    }

    public final void g() {
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.showProgress();
        }
    }

    public final void h() {
        AdapterPresenter adapterPresenter = this.o;
        List<? extends FavoriteListItem> list = this.g;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        AdapterPresentersKt.updateItems(adapterPresenter, CollectionsKt___CollectionsKt.toMutableList((Collection) list));
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.onDataChanged();
        }
        List<? extends FavoriteListItem> list2 = this.g;
        if (list2 == null || list2.isEmpty()) {
            FavoritesView favoritesView2 = this.d;
            if (favoritesView2 != null) {
                favoritesView2.showEmptyView();
            }
            FavoritesView favoritesView3 = this.d;
            if (favoritesView3 != null) {
                favoritesView3.setMenuVisibility(false);
            }
        } else {
            FavoritesView favoritesView4 = this.d;
            if (favoritesView4 != null) {
                favoritesView4.hideEmptyView();
            }
            FavoritesView favoritesView5 = this.d;
            if (favoritesView5 != null) {
                favoritesView5.setMenuVisibility(true);
            }
        }
        f();
    }

    public final void i() {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.m.getFavorites().observeOn(this.n.mainThread()).subscribe(new w(this), new x(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getFavorites(… processLoadingError() })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter.Listener
    public void onAskSellerAboutItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.t.track(new BuyerAsksSellerTtlItemEvent(str, this.u.getCurrentUserId()));
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.showMessage(this.q.getMessageSentToSeller());
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onClickMoreItemActions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.t.track(new ClickOnMoreActionsEvent(str, this.u.getCurrentUserId()));
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onClickSimilar(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.t.track(new ClickOnSimilarEvent(str, this.u.getCurrentUserId()));
        FavoritesListPresenter.Router router = this.e;
        if (router != null) {
            router.openSimilarAdverts(str, z);
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onFavoriteItemClicked(@NotNull FavoriteAdvertItem favoriteAdvertItem, @Nullable Image image) {
        FavoritesListPresenter.Router router;
        Intrinsics.checkNotNullParameter(favoriteAdvertItem, "item");
        DeepLink deepLink = favoriteAdvertItem.getDeepLink();
        String str = null;
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        if (((AdvertDetailsLink) deepLink) != null && (router = this.e) != null) {
            String stringId = favoriteAdvertItem.getStringId();
            DeepLink deepLink2 = favoriteAdvertItem.getDeepLink();
            if (!(deepLink2 instanceof AdvertDetailsLink)) {
                deepLink2 = null;
            }
            AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink2;
            if (advertDetailsLink != null) {
                str = advertDetailsLink.getContext();
            }
            router.openFastAdvertDetails(stringId, str, favoriteAdvertItem.getTitle(), favoriteAdvertItem.getPrice(), favoriteAdvertItem.getPreviousPrice(), image, new TreeClickStreamParent(this.r.nextStateId(), ScreenIdField.FAVORITE_ITEMS.name(), null, null), false);
        }
    }

    @Override // com.avito.android.favorites.FavoritesView.Presenter
    public void onPullRefresh() {
        if (this.u.isAuthorized()) {
            b(false, true);
        } else {
            e(false);
        }
    }

    @Override // com.avito.android.favorites.FavoritesView.Presenter
    public void onRemoveAllClicked() {
        Observable<Unit> observable;
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.showProgress();
        }
        CompositeDisposable compositeDisposable = this.a;
        if (this.u.isAuthorized()) {
            observable = this.m.removeAllAdvertsWithPaging();
        } else {
            observable = this.m.removeAllAdverts();
        }
        Disposable subscribe = observable.observeOn(this.n.mainThread()).subscribe(new j(this), new k(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "if (accountStateProvider…mat(error))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.favorites.FavoritesView.Presenter
    public void onRemoveInactiveClicked() {
        Observable<Unit> observable;
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.showProgress();
        }
        CompositeDisposable compositeDisposable = this.a;
        if (this.u.isAuthorized()) {
            observable = this.m.removeInactiveAdvertsWithPaging();
        } else {
            observable = this.m.removeInactiveAdverts();
        }
        Disposable subscribe = observable.observeOn(this.n.mainThread()).subscribe(new l(this), new m(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "if (accountStateProvider…mat(error))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRemoveItemClicked(@org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.advert.FavoriteAdvertItem r9) {
        /*
            r8 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = com.avito.android.favorites.FavoritesListPresenterKt.access$extractContext(r9)
            com.avito.android.account.AccountStateProvider r1 = r8.u
            boolean r1 = r1.isAuthorized()
            r2 = 1
            if (r1 == 0) goto L_0x0094
            java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem> r1 = r8.g
            r3 = -1
            if (r1 == 0) goto L_0x0044
            java.util.Iterator r1 = r1.iterator()
            r4 = 0
            r5 = 0
        L_0x001d:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0044
            java.lang.Object r6 = r1.next()
            com.avito.android.favorites.adapter.FavoriteListItem r6 = (com.avito.android.favorites.adapter.FavoriteListItem) r6
            boolean r7 = r6 instanceof com.avito.android.favorites.adapter.advert.FavoriteAdvertItem
            if (r7 == 0) goto L_0x003d
            java.lang.String r6 = r6.getStringId()
            java.lang.String r7 = r9.getStringId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L_0x003d
            r6 = 1
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            if (r6 == 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            int r5 = r5 + 1
            goto L_0x001d
        L_0x0044:
            r5 = -1
        L_0x0045:
            if (r5 != r3) goto L_0x0048
            return
        L_0x0048:
            boolean r1 = r9.getActive()
            if (r1 == 0) goto L_0x0066
            com.avito.android.favorites.FavoritesView r1 = r8.d
            if (r1 == 0) goto L_0x0066
            com.avito.android.favorites.FavoriteListResourceProvider r2 = r8.q
            java.lang.String r2 = r2.getRemovedFromFavorites()
            com.avito.android.favorites.FavoriteListResourceProvider r3 = r8.q
            java.lang.String r3 = r3.getCancel()
            com.avito.android.favorites.FavoritesListPresenterImpl$n r4 = new com.avito.android.favorites.FavoritesListPresenterImpl$n
            r4.<init>(r8, r5, r9, r0)
            r1.showMessageWithAction(r2, r3, r4)
        L_0x0066:
            java.util.List<? extends com.avito.android.favorites.adapter.FavoriteListItem> r1 = r8.g
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.MutableList<com.avito.android.favorites.adapter.FavoriteListItem>"
            java.util.Objects.requireNonNull(r1, r2)
            java.util.List r1 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r1)
            r1.remove(r5)
            r8.h()
            io.reactivex.disposables.CompositeDisposable r1 = r8.a
            com.avito.android.favorites.FavoritesListInteractor r2 = r8.m
            java.lang.String r9 = r9.getStringId()
            io.reactivex.Completable r9 = r2.markForRemove(r9, r0)
            com.avito.android.favorites.FavoritesListPresenterImpl$o r0 = com.avito.android.favorites.FavoritesListPresenterImpl.o.a
            com.avito.android.favorites.FavoritesListPresenterImpl$p r2 = com.avito.android.favorites.FavoritesListPresenterImpl.p.a
            io.reactivex.disposables.Disposable r9 = r9.subscribe(r0, r2)
            java.lang.String r0 = "interactor.markForRemove…be({}) { Logs.error(it) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r1, r9)
            goto L_0x00e2
        L_0x0094:
            boolean r1 = r9.getActive()
            if (r1 == 0) goto L_0x00b2
            com.avito.android.favorites.FavoritesView r1 = r8.d
            if (r1 == 0) goto L_0x00b2
            com.avito.android.favorites.FavoriteListResourceProvider r3 = r8.q
            java.lang.String r3 = r3.getRemovedFromFavorites()
            com.avito.android.favorites.FavoriteListResourceProvider r4 = r8.q
            java.lang.String r4 = r4.getCancel()
            com.avito.android.favorites.FavoritesListPresenterImpl$q r5 = new com.avito.android.favorites.FavoritesListPresenterImpl$q
            r5.<init>(r8, r9, r0)
            r1.showMessageWithAction(r3, r4, r5)
        L_0x00b2:
            io.reactivex.disposables.CompositeDisposable r1 = r8.a
            com.avito.android.favorite.FavoriteAdvertsInteractor r3 = r8.p
            java.lang.String r9 = r9.getStringId()
            com.avito.android.favorite.FavoriteActionSource$Favorites r4 = new com.avito.android.favorite.FavoriteActionSource$Favorites
            r4.<init>(r0)
            io.reactivex.rxjava3.core.Single r9 = r3.toggleFavoriteStatus(r9, r4, r2)
            io.reactivex.Single r9 = com.avito.android.util.rx3.InteropKt.toV2(r9)
            com.avito.android.util.SchedulersFactory r0 = r8.n
            io.reactivex.Scheduler r0 = r0.mainThread()
            io.reactivex.Single r9 = r9.observeOn(r0)
            java.lang.String r0 = "favoriteAdvertsInteracto…lersFactory.mainThread())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            com.avito.android.favorites.FavoritesListPresenterImpl$r r0 = new com.avito.android.favorites.FavoritesListPresenterImpl$r
            r0.<init>(r8)
            io.reactivex.disposables.Disposable r9 = com.avito.android.util.Singles.subscribeOnNext(r9, r0)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r1, r9)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.FavoritesListPresenterImpl.onRemoveItemClicked(com.avito.android.favorites.adapter.advert.FavoriteAdvertItem):void");
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    public void onRestoreState() {
        this.g = this.x.getFavoritesList();
        this.x.setFavoritesList(null);
    }

    @Override // com.avito.android.favorites.FavoritesView.Presenter
    public void onRetry() {
        if (this.u.isAuthorized()) {
            c(this, false, true, 1);
        } else {
            e(true);
        }
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    @NotNull
    public Kundle onSaveState() {
        this.x.setFavoritesList(this.g);
        Kundle kundle = new Kundle();
        kundle.putBoolean("is_items_viewed", Boolean.valueOf(this.i));
        kundle.putString("sync_completed_event_id", this.l);
        return kundle;
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter
    public void onVisibilityChanged(boolean z) {
        this.j = z;
        if (z) {
            DisposableKt.plusAssign(this.c, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.n, this.m.favoriteUpdateEvents(), "interactor.favoriteUpdat…lersFactory.mainThread())"), new s(this)));
            if (!this.u.isAuthorized()) {
                i();
                CompositeDisposable compositeDisposable = this.a;
                Disposable subscribe = this.m.hasNotSyncedItems().subscribe(new v0(this), w0.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.hasNotSyncedI…d items\", it) }\n        )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else {
                FavoritesListPresenter.Router router = this.e;
                if (router != null) {
                    router.startUpload();
                }
            }
            if (this.y.getFavouriteAdvertsCounter().invoke().booleanValue()) {
                if (!this.i && !this.k) {
                    d();
                }
                CompositeDisposable compositeDisposable2 = this.c;
                Disposable subscribe2 = this.m.counterChanges().filter(t.a).delay(2, TimeUnit.SECONDS).observeOn(this.n.mainThread()).subscribe(new u(this), v.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.counterChange…ctor.resetCounter() }) {}");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
                return;
            }
            return;
        }
        if (this.y.getFavouriteAdvertsCounter().invoke().booleanValue()) {
            this.m.resetCounter();
        }
        FavoritesListPresenter.Router router2 = this.e;
        if (router2 != null) {
            router2.startUploadRemoved();
        }
        FavoritesView favoritesView = this.d;
        if (favoritesView != null) {
            favoritesView.dismissMessageWithAction();
        }
        this.c.clear();
    }
}
