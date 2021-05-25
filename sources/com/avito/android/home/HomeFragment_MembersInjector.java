package com.avito.android.home;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.home.analytics.HomeAnalyticsInteractor;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.home.default_search_location.DefaultSearchLocationInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
    public final Provider<HomeNewRubricatorTestGroup> A;
    public final Provider<CartFabViewModel> B;
    public final Provider<CartQuantityChangesHandler> C;
    public final Provider<HomePresenter> a;
    public final Provider<HomePresenterResourcesProvider> b;
    public final Provider<Analytics> c;
    public final Provider<ItemVisibilityTracker> d;
    public final Provider<HomeAnalyticsInteractor> e;
    public final Provider<Features> f;
    public final Provider<PersistableFloatingViewsPresenter> g;
    public final Provider<HomeInteractor> h;
    public final Provider<ResponsiveAdapterPresenter> i;
    public final Provider<GridLayoutManager.SpanSizeLookup> j;
    public final Provider<ActivityIntentFactory> k;
    public final Provider<DeepLinkIntentFactory> l;
    public final Provider<SpannedGridPositionProvider> m;
    public final Provider<DestroyableViewHolderBuilder> n;
    public final Provider<NetworkInfoBroadcastReceiver> o;
    public final Provider<FavoriteAdvertsPresenter> p;
    public final Provider<AdvertItemActionsPresenter> q;
    public final Provider<DefaultSearchLocationPresenter> r;
    public final Provider<DefaultSearchLocationInteractor> s;
    public final Provider<DefaultLocationInteractor> t;
    public final Provider<SchedulersFactory3> u;
    public final Provider<FpsStateSupplier> v;
    public final Provider<ViewedAdvertsPresenter> w;
    public final Provider<HomeTracker> x;
    public final Provider<HomeSkeletonTestGroup> y;
    public final Provider<WitcherItemPresenter> z;

    public HomeFragment_MembersInjector(Provider<HomePresenter> provider, Provider<HomePresenterResourcesProvider> provider2, Provider<Analytics> provider3, Provider<ItemVisibilityTracker> provider4, Provider<HomeAnalyticsInteractor> provider5, Provider<Features> provider6, Provider<PersistableFloatingViewsPresenter> provider7, Provider<HomeInteractor> provider8, Provider<ResponsiveAdapterPresenter> provider9, Provider<GridLayoutManager.SpanSizeLookup> provider10, Provider<ActivityIntentFactory> provider11, Provider<DeepLinkIntentFactory> provider12, Provider<SpannedGridPositionProvider> provider13, Provider<DestroyableViewHolderBuilder> provider14, Provider<NetworkInfoBroadcastReceiver> provider15, Provider<FavoriteAdvertsPresenter> provider16, Provider<AdvertItemActionsPresenter> provider17, Provider<DefaultSearchLocationPresenter> provider18, Provider<DefaultSearchLocationInteractor> provider19, Provider<DefaultLocationInteractor> provider20, Provider<SchedulersFactory3> provider21, Provider<FpsStateSupplier> provider22, Provider<ViewedAdvertsPresenter> provider23, Provider<HomeTracker> provider24, Provider<HomeSkeletonTestGroup> provider25, Provider<WitcherItemPresenter> provider26, Provider<HomeNewRubricatorTestGroup> provider27, Provider<CartFabViewModel> provider28, Provider<CartQuantityChangesHandler> provider29) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
        this.w = provider23;
        this.x = provider24;
        this.y = provider25;
        this.z = provider26;
        this.A = provider27;
        this.B = provider28;
        this.C = provider29;
    }

    public static MembersInjector<HomeFragment> create(Provider<HomePresenter> provider, Provider<HomePresenterResourcesProvider> provider2, Provider<Analytics> provider3, Provider<ItemVisibilityTracker> provider4, Provider<HomeAnalyticsInteractor> provider5, Provider<Features> provider6, Provider<PersistableFloatingViewsPresenter> provider7, Provider<HomeInteractor> provider8, Provider<ResponsiveAdapterPresenter> provider9, Provider<GridLayoutManager.SpanSizeLookup> provider10, Provider<ActivityIntentFactory> provider11, Provider<DeepLinkIntentFactory> provider12, Provider<SpannedGridPositionProvider> provider13, Provider<DestroyableViewHolderBuilder> provider14, Provider<NetworkInfoBroadcastReceiver> provider15, Provider<FavoriteAdvertsPresenter> provider16, Provider<AdvertItemActionsPresenter> provider17, Provider<DefaultSearchLocationPresenter> provider18, Provider<DefaultSearchLocationInteractor> provider19, Provider<DefaultLocationInteractor> provider20, Provider<SchedulersFactory3> provider21, Provider<FpsStateSupplier> provider22, Provider<ViewedAdvertsPresenter> provider23, Provider<HomeTracker> provider24, Provider<HomeSkeletonTestGroup> provider25, Provider<WitcherItemPresenter> provider26, Provider<HomeNewRubricatorTestGroup> provider27, Provider<CartFabViewModel> provider28, Provider<CartQuantityChangesHandler> provider29) {
        return new HomeFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29);
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.adapterPresenter")
    public static void injectAdapterPresenter(HomeFragment homeFragment, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        homeFragment.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.advertItemActionsPresenter")
    public static void injectAdvertItemActionsPresenter(HomeFragment homeFragment, AdvertItemActionsPresenter advertItemActionsPresenter) {
        homeFragment.advertItemActionsPresenter = advertItemActionsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.analytics")
    public static void injectAnalytics(HomeFragment homeFragment, Analytics analytics) {
        homeFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.analyticsInteractor")
    public static void injectAnalyticsInteractor(HomeFragment homeFragment, HomeAnalyticsInteractor homeAnalyticsInteractor) {
        homeFragment.analyticsInteractor = homeAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.cartFabQuantityHandler")
    public static void injectCartFabQuantityHandler(HomeFragment homeFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        homeFragment.cartFabQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.cartFabViewModel")
    public static void injectCartFabViewModel(HomeFragment homeFragment, CartFabViewModel cartFabViewModel) {
        homeFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(HomeFragment homeFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        homeFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.defaultLocationInteractor")
    public static void injectDefaultLocationInteractor(HomeFragment homeFragment, DefaultLocationInteractor defaultLocationInteractor) {
        homeFragment.defaultLocationInteractor = defaultLocationInteractor;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.defaultLocationPresenter")
    public static void injectDefaultLocationPresenter(HomeFragment homeFragment, DefaultSearchLocationPresenter defaultSearchLocationPresenter) {
        homeFragment.defaultLocationPresenter = defaultSearchLocationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.defaultSearchLocationInteractor")
    public static void injectDefaultSearchLocationInteractor(HomeFragment homeFragment, DefaultSearchLocationInteractor defaultSearchLocationInteractor) {
        homeFragment.defaultSearchLocationInteractor = defaultSearchLocationInteractor;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(HomeFragment homeFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        homeFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(HomeFragment homeFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        homeFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.features")
    public static void injectFeatures(HomeFragment homeFragment, Features features) {
        homeFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.floatingViewsPresenter")
    public static void injectFloatingViewsPresenter(HomeFragment homeFragment, PersistableFloatingViewsPresenter persistableFloatingViewsPresenter) {
        homeFragment.floatingViewsPresenter = persistableFloatingViewsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.gridPositionProvider")
    public static void injectGridPositionProvider(HomeFragment homeFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        homeFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.homeNewRubricatorTestGroup")
    public static void injectHomeNewRubricatorTestGroup(HomeFragment homeFragment, HomeNewRubricatorTestGroup homeNewRubricatorTestGroup) {
        homeFragment.homeNewRubricatorTestGroup = homeNewRubricatorTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.homeSkeletonTestGroup")
    public static void injectHomeSkeletonTestGroup(HomeFragment homeFragment, HomeSkeletonTestGroup homeSkeletonTestGroup) {
        homeFragment.homeSkeletonTestGroup = homeSkeletonTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.intentFactory")
    public static void injectIntentFactory(HomeFragment homeFragment, ActivityIntentFactory activityIntentFactory) {
        homeFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.interactor")
    public static void injectInteractor(HomeFragment homeFragment, HomeInteractor homeInteractor) {
        homeFragment.interactor = homeInteractor;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.itemVisibilityTracker")
    public static void injectItemVisibilityTracker(HomeFragment homeFragment, ItemVisibilityTracker itemVisibilityTracker) {
        homeFragment.itemVisibilityTracker = itemVisibilityTracker;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.networkInfoBroadcastReceiver")
    public static void injectNetworkInfoBroadcastReceiver(HomeFragment homeFragment, NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver) {
        homeFragment.networkInfoBroadcastReceiver = networkInfoBroadcastReceiver;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.presenter")
    public static void injectPresenter(HomeFragment homeFragment, HomePresenter homePresenter) {
        homeFragment.presenter = homePresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.resourceProvider")
    public static void injectResourceProvider(HomeFragment homeFragment, HomePresenterResourcesProvider homePresenterResourcesProvider) {
        homeFragment.resourceProvider = homePresenterResourcesProvider;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.schedulers")
    public static void injectSchedulers(HomeFragment homeFragment, SchedulersFactory3 schedulersFactory3) {
        homeFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(HomeFragment homeFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        homeFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.supplier")
    public static void injectSupplier(HomeFragment homeFragment, FpsStateSupplier fpsStateSupplier) {
        homeFragment.supplier = fpsStateSupplier;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.tracker")
    public static void injectTracker(HomeFragment homeFragment, HomeTracker homeTracker) {
        homeFragment.tracker = homeTracker;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(HomeFragment homeFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        homeFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.home.HomeFragment.witcherItemPresenter")
    public static void injectWitcherItemPresenter(HomeFragment homeFragment, WitcherItemPresenter witcherItemPresenter) {
        homeFragment.witcherItemPresenter = witcherItemPresenter;
    }

    public void injectMembers(HomeFragment homeFragment) {
        injectPresenter(homeFragment, this.a.get());
        injectResourceProvider(homeFragment, this.b.get());
        injectAnalytics(homeFragment, this.c.get());
        injectItemVisibilityTracker(homeFragment, this.d.get());
        injectAnalyticsInteractor(homeFragment, this.e.get());
        injectFeatures(homeFragment, this.f.get());
        injectFloatingViewsPresenter(homeFragment, this.g.get());
        injectInteractor(homeFragment, this.h.get());
        injectAdapterPresenter(homeFragment, this.i.get());
        injectSpanSizeLookup(homeFragment, this.j.get());
        injectIntentFactory(homeFragment, this.k.get());
        injectDeepLinkIntentFactory(homeFragment, this.l.get());
        injectGridPositionProvider(homeFragment, this.m.get());
        injectDestroyableViewHolderBuilder(homeFragment, this.n.get());
        injectNetworkInfoBroadcastReceiver(homeFragment, this.o.get());
        injectFavoriteAdvertsPresenter(homeFragment, this.p.get());
        injectAdvertItemActionsPresenter(homeFragment, this.q.get());
        injectDefaultLocationPresenter(homeFragment, this.r.get());
        injectDefaultSearchLocationInteractor(homeFragment, this.s.get());
        injectDefaultLocationInteractor(homeFragment, this.t.get());
        injectSchedulers(homeFragment, this.u.get());
        injectSupplier(homeFragment, this.v.get());
        injectViewedAdvertsPresenter(homeFragment, this.w.get());
        injectTracker(homeFragment, this.x.get());
        injectHomeSkeletonTestGroup(homeFragment, this.y.get());
        injectWitcherItemPresenter(homeFragment, this.z.get());
        injectHomeNewRubricatorTestGroup(homeFragment, this.A.get());
        injectCartFabViewModel(homeFragment, this.B.get());
        injectCartFabQuantityHandler(homeFragment, this.C.get());
    }
}
