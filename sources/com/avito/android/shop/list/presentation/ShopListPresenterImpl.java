package com.avito.android.shop.list.presentation;

import a2.a.a.s2.d.b.c;
import a2.a.a.s2.d.b.d;
import a2.a.a.s2.d.b.e;
import a2.a.a.s2.d.b.f;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.advert_core.analytics.closed_advert.AdvertDetailsLoadEventKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ShowShopsScreenEvent;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ShopsLink;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.LinkAction;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.shop.list.analytic.ShopListTracker;
import com.avito.android.shop.list.business.ShopListInfo;
import com.avito.android.shop.list.business.ShopListInteractor;
import com.avito.android.shop.list.business.ShopLocation;
import com.avito.android.shop.list.di.ShopListModule;
import com.avito.android.shop.list.presentation.item.ShopItem;
import com.avito.android.util.Constants;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010g\u001a\u00020\u001e\u0012\b\u0010h\u001a\u0004\u0018\u000102\u0012\n\b\u0001\u0010i\u001a\u0004\u0018\u00010$¢\u0006\u0004\bj\u0010kJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\tR\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010(R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020H0G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0016\u0010O\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010AR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010UR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010VR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010(R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010c¨\u0006l"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListPresenterImpl;", "Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "", "loadNextPage", "", "c", "(Z)V", AuthSource.BOOKING_ORDER, "d", "()V", AuthSource.SEND_ABUSE, "e", "f", "Lcom/avito/android/shop/list/presentation/ShopListView;", "view", "attachView", "(Lcom/avito/android/shop/list/presentation/ShopListView;)V", "detachView", "Lcom/avito/android/shop/list/presentation/ShopListRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/list/presentation/ShopListRouter;)V", "detachRouter", "Lcom/avito/android/shop/list/presentation/item/ShopItem;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "onShopClick", "(Lcom/avito/android/shop/list/presentation/item/ShopItem;)V", "onAppend", "canAppend", "()Z", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "params", "Lcom/avito/android/remote/model/CaseText;", "locationNames", "onSearchParametersChanged", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Lcom/avito/android/remote/model/CaseText;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onDestroy", "Z", "isOnTop", "Lcom/avito/android/remote/model/LinkAction;", g.a, "Lcom/avito/android/remote/model/LinkAction;", "action", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", VKApiConst.Q, "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "floatingViewsPresenter", "", "l", "Ljava/lang/String;", "hintLocationName", "i", "hasNetworkError", "Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;", "s", "Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;", "shortcutNavigationItemConverter", "Lcom/avito/android/analytics/Analytics;", "t", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "dataDisposables", "Lcom/avito/android/shop/list/analytic/ShopListTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/shop/list/analytic/ShopListTracker;", "shopListTracker", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "h", "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "isLoading", "k", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParams", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "p", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "shopListDataChangeListener", "viewScopeDisposables", "Lcom/avito/android/shop/list/presentation/ShopListView;", "Lcom/avito/android/shop/list/presentation/ShopListRouter;", "Lcom/avito/android/shop/list/business/ShopListInteractor;", "n", "Lcom/avito/android/shop/list/business/ShopListInteractor;", "interactor", "j", "searchIsOpen", "Lcom/avito/android/shop/list/presentation/ShopListConverter;", "o", "Lcom/avito/android/shop/list/presentation/ShopListConverter;", "shopsConverter", "Lcom/avito/android/util/SchedulersFactory3;", "r", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/Features;", "features", "searchParameters", Constants.LOCATION_NAME, "state", "<init>", "(Lcom/avito/android/shop/list/analytic/ShopListTracker;Lcom/avito/android/shop/list/business/ShopListInteractor;Lcom/avito/android/shop/list/presentation/ShopListConverter;Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListPresenterImpl implements ShopListPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public ShopListView c;
    public ShopListRouter d;
    public boolean e;
    public boolean f;
    public LinkAction g;
    public DataSource<SpannedItem> h;
    public boolean i;
    public boolean j;
    public ShopsSearchParameters k;
    public String l;
    public final ShopListTracker m;
    public final ShopListInteractor n;
    public final ShopListConverter o;
    public final ShopListDataChangeListener p;
    public final PersistableFloatingViewsPresenter q;
    public final SchedulersFactory3 r;
    public final ShortcutNavigationItemConverter s;
    public final Analytics t;

    public static final class a extends Lambda implements Function1<LoadingState<? super ShopListInfo>, Unit> {
        public final /* synthetic */ ShopListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopListPresenterImpl shopListPresenterImpl) {
            super(1);
            this.a = shopListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super ShopListInfo> loadingState) {
            LoadingState<? super ShopListInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.d();
            } else if (loadingState2 instanceof LoadingState.Error) {
                ShopListPresenterImpl.access$handleError(this.a, ((LoadingState.Error) loadingState2).getError());
                this.a.m.trackShopsLoadError(this.a.h.getCount());
                this.a.m.stop();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                ShopListPresenterImpl.access$onShopsLoaded(this.a, (ShopListInfo) ((LoadingState.Loaded) loadingState2).getData());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<LoadingState<? super ShopLocation>, Unit> {
        public final /* synthetic */ ShopListPresenterImpl a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ShopListPresenterImpl shopListPresenterImpl, boolean z) {
            super(1);
            this.a = shopListPresenterImpl;
            this.b = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super ShopLocation> loadingState) {
            LoadingState<? super ShopLocation> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.d();
            } else if (loadingState2 instanceof LoadingState.Error) {
                ShopListPresenterImpl.access$handleError(this.a, ((LoadingState.Error) loadingState2).getError());
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                ShopListPresenterImpl.access$saveLocationId(this.a, ((ShopLocation) loaded.getData()).getId());
                ShopListPresenterImpl.access$updateLocationName(this.a, ShopListPresenterKt.access$getNameForHint((ShopLocation) loaded.getData()));
                this.a.b(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopListPresenterImpl(@NotNull ShopListTracker shopListTracker, @NotNull ShopListInteractor shopListInteractor, @NotNull ShopListConverter shopListConverter, @NotNull ShopListDataChangeListener shopListDataChangeListener, @NotNull PersistableFloatingViewsPresenter persistableFloatingViewsPresenter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ShortcutNavigationItemConverter shortcutNavigationItemConverter, @NotNull Analytics analytics, @NotNull Features features, @NotNull ShopsSearchParameters shopsSearchParameters, @Nullable String str, @ShopListModule.PresenterState @Nullable Kundle kundle) {
        String string;
        ShopsSearchParameters shopsSearchParameters2;
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(shopListTracker, "shopListTracker");
        Intrinsics.checkNotNullParameter(shopListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(shopListConverter, "shopsConverter");
        Intrinsics.checkNotNullParameter(shopListDataChangeListener, "shopListDataChangeListener");
        Intrinsics.checkNotNullParameter(persistableFloatingViewsPresenter, "floatingViewsPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(shortcutNavigationItemConverter, "shortcutNavigationItemConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        this.m = shopListTracker;
        this.n = shopListInteractor;
        this.o = shopListConverter;
        this.p = shopListDataChangeListener;
        this.q = persistableFloatingViewsPresenter;
        this.r = schedulersFactory3;
        this.s = shortcutNavigationItemConverter;
        this.t = analytics;
        this.f = (kundle == null || (bool2 = kundle.getBoolean("is_on_top")) == null) ? true : bool2.booleanValue();
        this.h = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
        this.i = (kundle == null || (bool = kundle.getBoolean(AdvertDetailsLoadEventKt.NETWORK_ERROR)) == null) ? false : bool.booleanValue();
        if (!(kundle == null || (shopsSearchParameters2 = (ShopsSearchParameters) kundle.getParcelable("search_parameters")) == null)) {
            shopsSearchParameters = shopsSearchParameters2;
        }
        this.k = shopsSearchParameters;
        if (!(kundle == null || (string = kundle.getString("location_name")) == null)) {
            str = string;
        }
        this.l = str;
    }

    public static final void access$handleError(ShopListPresenterImpl shopListPresenterImpl, TypedError typedError) {
        shopListPresenterImpl.e = false;
        ShopListView shopListView = shopListPresenterImpl.c;
        if (shopListView != null) {
            shopListView.addBottomSpace();
            shopListView.hideLoading();
            shopListView.hideActionButton();
            shopListView.hideShortcutsWithShift();
            shopListView.stopPullRefresh();
            shopListView.setPullRefreshEnabled(false);
            shopListView.setSearchEnabled(false);
            if ((typedError instanceof ErrorWithMessage) && !(typedError instanceof ErrorWithMessage.NetworkError)) {
                ErrorWithMessage errorWithMessage = (ErrorWithMessage) typedError;
                if (!m.isBlank(errorWithMessage.getMessage())) {
                    shopListView.showError(errorWithMessage.getMessage());
                    return;
                }
            }
            if (typedError instanceof ErrorWithMessage.NetworkError) {
                shopListView.showRetryOverlay();
                shopListPresenterImpl.i = true;
            }
        }
    }

    public static final void access$invalidateState(ShopListPresenterImpl shopListPresenterImpl) {
        shopListPresenterImpl.a.clear();
        shopListPresenterImpl.e = false;
        shopListPresenterImpl.n.invalidate();
        shopListPresenterImpl.a();
    }

    public static final void access$onQuerySubmitted(ShopListPresenterImpl shopListPresenterImpl, String str) {
        shopListPresenterImpl.k.setQuery(str);
        shopListPresenterImpl.e();
        ShopListView shopListView = shopListPresenterImpl.c;
        if (shopListView != null) {
            shopListView.close();
        }
    }

    public static final void access$onSearchStateChanged(ShopListPresenterImpl shopListPresenterImpl, boolean z) {
        if (z || shopListPresenterImpl.h.isEmpty()) {
            ShopListView shopListView = shopListPresenterImpl.c;
            if (shopListView != null) {
                shopListView.hideActionButton();
            }
        } else {
            ShopListView shopListView2 = shopListPresenterImpl.c;
            if (shopListView2 != null) {
                shopListView2.showActionButton();
            }
        }
        shopListPresenterImpl.j = z;
    }

    public static final void access$onShopsLoaded(ShopListPresenterImpl shopListPresenterImpl, ShopListInfo shopListInfo) {
        ShopListView shopListView;
        shopListPresenterImpl.m.trackShopsLoaded(shopListPresenterImpl.h.getCount());
        shopListPresenterImpl.e = false;
        shopListPresenterImpl.i = false;
        ShopListView shopListView2 = shopListPresenterImpl.c;
        if (shopListView2 != null) {
            shopListView2.setSearchEnabled(true);
        }
        ShopListView shopListView3 = shopListPresenterImpl.c;
        if (shopListView3 != null) {
            shopListView3.addBottomSpace();
        }
        shopListPresenterImpl.m.startShopsPrepare();
        ShopListView shopListView4 = shopListPresenterImpl.c;
        if (shopListView4 != null) {
            String query = shopListPresenterImpl.k.getQuery();
            if (query == null) {
                query = "";
            }
            shopListView4.setQuery(query);
        }
        Shortcuts shortcuts = shopListInfo.getShortcuts();
        List<ShortcutNavigationItem> convert = shopListPresenterImpl.s.convert(shortcuts);
        ShopListView shopListView5 = shopListPresenterImpl.c;
        if (shopListView5 != null) {
            shopListView5.setShortcutItems(shortcuts.getHeader(), convert);
        }
        if (convert.isEmpty()) {
            ShopListView shopListView6 = shopListPresenterImpl.c;
            if (shopListView6 != null) {
                shopListView6.hideShortcutsWithShift();
            }
        } else {
            ShopListView shopListView7 = shopListPresenterImpl.c;
            if (shopListView7 != null) {
                shopListView7.showShortcutsWithShift();
            }
        }
        List<ShopsListResult.Shop> shopList = shopListInfo.getShopList();
        shopListPresenterImpl.e = false;
        ListDataSource listDataSource = new ListDataSource(shopListPresenterImpl.o.convert(shopList));
        shopListPresenterImpl.p.onDataSourceChanged(listDataSource);
        shopListPresenterImpl.a();
        shopListPresenterImpl.h = listDataSource;
        shopListPresenterImpl.m.trackShopsPrepare(listDataSource.getCount());
        if (shopListPresenterImpl.h.isEmpty()) {
            ShopListView shopListView8 = shopListPresenterImpl.c;
            if (shopListView8 != null) {
                shopListView8.hideActionButton();
                shopListView8.hideShortcutsWithShift();
                shopListView8.showEmptyView();
            }
        } else {
            ShopListView shopListView9 = shopListPresenterImpl.c;
            if (shopListView9 != null) {
                if (shopListPresenterImpl.j) {
                    shopListView9.hideActionButton();
                } else if (shopListPresenterImpl.f || (true ^ shopListPresenterImpl.n.canLoadMore())) {
                    shopListView9.showActionButton();
                }
                shopListView9.hideEmptyView();
            }
        }
        ShopListView shopListView10 = shopListPresenterImpl.c;
        if (shopListView10 != null) {
            shopListView10.hideLoading();
            shopListView10.stopPullRefresh();
            shopListView10.onDataChanged(shopListPresenterImpl);
        }
        shopListPresenterImpl.m.trackShopsDraw(shopListPresenterImpl.h.getCount());
        List<LinkAction> shopActions = shopListInfo.getShopActions();
        if (!shopActions.isEmpty()) {
            LinkAction linkAction = shopActions.get(0);
            String title = linkAction.getTitle();
            if (!(title == null || (shopListView = shopListPresenterImpl.c) == null)) {
                shopListView.setActionText(title);
            }
            shopListPresenterImpl.g = linkAction;
        }
        Map<String, String> firebaseParams = shopListInfo.getFirebaseParams();
        if (firebaseParams != null) {
            shopListPresenterImpl.t.track(new ShowShopsScreenEvent(firebaseParams));
        }
        shopListPresenterImpl.m.stopLoadShopsSession();
    }

    public static final void access$onShortcutClick(ShopListPresenterImpl shopListPresenterImpl, DeepLink deepLink) {
        ShopListRouter shopListRouter;
        Objects.requireNonNull(shopListPresenterImpl);
        if ((deepLink instanceof ShopsLink) && (shopListRouter = shopListPresenterImpl.d) != null) {
            ShopsSearchParameters searchParams = ((ShopsLink) deepLink).getSearchParams();
            shopListRouter.openShortcut(new ShopsSearchParameters(shopListPresenterImpl.k.getQuery(), searchParams.getCategoryId(), searchParams.getLocationId()), shopListPresenterImpl.l);
        }
    }

    public static final void access$saveLocationId(ShopListPresenterImpl shopListPresenterImpl, String str) {
        shopListPresenterImpl.k.setLocationId(str);
    }

    public static final void access$updateLocationName(ShopListPresenterImpl shopListPresenterImpl, String str) {
        shopListPresenterImpl.l = str;
        shopListPresenterImpl.f();
    }

    public final void a() {
        DataSource<SpannedItem> dataSource = this.h;
        if (dataSource instanceof CloseableDataSource) {
            ((CloseableDataSource) dataSource).close();
        }
        this.h = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    public void attachRouter(@NotNull ShopListRouter shopListRouter) {
        Intrinsics.checkNotNullParameter(shopListRouter, "router");
        this.d = shopListRouter;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    public void attachView(@NotNull ShopListView shopListView) {
        Intrinsics.checkNotNullParameter(shopListView, "view");
        this.c = shopListView;
        if (shopListView != null) {
            String query = this.k.getQuery();
            if (query == null) {
                query = "";
            }
            shopListView.setQuery(query);
        }
        f();
        ShopListView shopListView2 = this.c;
        if (shopListView2 != null) {
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.searchClarifyEvents(), new a4(0, this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.navigationCallbacks(), new a4(1, this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.reloadEvents(), new a4(2, this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.actionClickEvents(), new a4(3, this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.pullRefreshEvents(), new a4(4, this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.submitCallbacks(), new d(this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.openCallbacks(), new e(this)));
            Disposables.plusAssign(this.b, Observables.subscribeOnNext(shopListView2.firstVisibleEvents(), new f(this)));
            CompositeDisposable compositeDisposable = this.b;
            Observable<R> map = shopListView2.shortcutClicks().map(a2.a.a.s2.d.b.g.a);
            Intrinsics.checkNotNullExpressionValue(map, "listView.shortcutClicks(…     .map { it.deepLink }");
            Disposables.plusAssign(compositeDisposable, Observables.subscribeOnNext(map, new c(this)));
        }
        Disposables.plusAssign(this.b, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.r, this.n.getLocationChanges(), "interactor\n            .…lersFactory.mainThread())"), new a2.a.a.s2.d.b.b(this)));
        if (this.i) {
            shopListView.showRetryOverlay();
        } else if (!this.e || this.n.hasCachedData()) {
            c(false);
        } else {
            d();
        }
    }

    public final void b(boolean z) {
        this.m.startShopsAdverts();
        Disposables.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.r, this.n.getShops(this.k, z), "interactor.getShops(sear…lersFactory.mainThread())"), new a(this)));
    }

    public final void c(boolean z) {
        boolean z2 = true;
        this.e = true;
        if (z) {
            this.m.startLoadMoreShopsSession();
        } else {
            this.m.startReloadSession();
        }
        String locationId = this.k.getLocationId();
        if (locationId == null || locationId.length() == 0) {
            Disposables.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.r, this.n.getLocationInfo(), "interactor.getLocationIn…lersFactory.mainThread())"), new b(this, z)));
            return;
        }
        Intrinsics.checkNotNull(locationId);
        String str = this.l;
        if (str != null && !m.isBlank(str)) {
            z2 = false;
        }
        if (z2) {
            Observables.subscribeOnNext(a2.b.a.a.a.b2(this.r, this.n.getLocationInfoById(locationId), "interactor.getLocationIn…lersFactory.mainThread())"), new a2.a.a.s2.d.b.a(this));
        }
        b(z);
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return this.n.canLoadMore();
    }

    public final void d() {
        ShopListView shopListView;
        if (this.h.isEmpty() && (shopListView = this.c) != null) {
            shopListView.showLoading();
        }
        ShopListView shopListView2 = this.c;
        if (shopListView2 != null) {
            shopListView2.setSearchEnabled(false);
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    public void detachView() {
        this.c = null;
        this.m.stop();
        this.b.clear();
    }

    public final void e() {
        this.a.clear();
        this.e = false;
        this.n.invalidate();
        a();
        this.p.onDataSourceChanged(new ListDataSource(CollectionsKt__CollectionsKt.emptyList()));
        ShopListView shopListView = this.c;
        if (shopListView != null) {
            shopListView.onDataChanged(this);
        }
        this.q.reset();
        ShopListView shopListView2 = this.c;
        if (shopListView2 != null) {
            shopListView2.hideActionButton();
        }
        c(false);
    }

    public final void f() {
        Unit unit;
        String str = this.l;
        if (str != null) {
            ShopListView shopListView = this.c;
            if (shopListView != null) {
                shopListView.showSearchHintWithLocation(str);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        ShopListView shopListView2 = this.c;
        if (shopListView2 != null) {
            shopListView2.showSearchHintNoLocation();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        ShopListView shopListView = this.c;
        if (shopListView != null) {
            shopListView.removeBottomSpace();
        }
        if (!this.e) {
            c(true);
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    public void onDestroy() {
        this.a.clear();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("search_parameters", this.k);
        kundle.putString("location_name", this.l);
        kundle.putBoolean("is_on_top", Boolean.valueOf(this.f));
        kundle.putBoolean(AdvertDetailsLoadEventKt.NETWORK_ERROR, Boolean.valueOf(this.i));
        return kundle;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListPresenter
    public void onSearchParametersChanged(@NotNull ShopsSearchParameters shopsSearchParameters, @NotNull CaseText caseText) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "params");
        Intrinsics.checkNotNullParameter(caseText, "locationNames");
        if (!Intrinsics.areEqual(this.k.getLocationId(), shopsSearchParameters.getLocationId())) {
            this.l = caseText.getName(6);
            f();
        }
        this.k = shopsSearchParameters;
        e();
    }

    @Override // com.avito.android.shop.list.presentation.item.ShopClickListener
    public void onShopClick(@NotNull ShopItem shopItem) {
        Intrinsics.checkNotNullParameter(shopItem, ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
        if (shopItem.getUri() != null) {
            ShopListRouter shopListRouter = this.d;
            if (shopListRouter != null) {
                shopListRouter.followDeepLink(shopItem.getUri());
                return;
            }
            return;
        }
        SearchParams searchParams = new SearchParams(this.k.getCategoryId(), null, this.k.getLocationId(), null, null, null, null, null, null, this.k.getQuery(), null, null, null, null, null, null, null, null, null, null, null, null, null, 8388090, null);
        ShopListRouter shopListRouter2 = this.d;
        if (shopListRouter2 != null) {
            shopListRouter2.openShopDetailsScreen(shopItem.getStringId(), searchParams);
        }
    }
}
