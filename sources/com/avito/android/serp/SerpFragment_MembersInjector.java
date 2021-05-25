package com.avito.android.serp;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.dfp_mobile_ads.DfpMobileAdsWrapper;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SerpFragment_MembersInjector implements MembersInjector<SerpFragment> {
    public final Provider<WarningStateProvider> A;
    public final Provider<NotificationManagerProvider> B;
    public final Provider<SerpTracker> C;
    public final Provider<InlineFiltersPresenter> D;
    public final Provider<InlineFilterDialogFactory> E;
    public final Provider<WitcherItemPresenter> F;
    public final Provider<VerticalFilterPresenter> G;
    public final Provider<SavedSearchesPresenter> H;
    public final Provider<AsyncPhonePresenter> I;
    public final Provider<SerpSkeletonTestGroup> J;
    public final Provider<SerpOnboardingHandler> K;
    public final Provider<CartFabViewModel> L;
    public final Provider<CartQuantityChangesHandler> M;
    public final Provider<SerpPresenter> a;
    public final Provider<SerpResourcesProvider> b;
    public final Provider<SerpInteractor> c;
    public final Provider<FpsStateSupplier> d;
    public final Provider<SerpAnalyticsInteractor> e;
    public final Provider<PersistableFloatingViewsPresenter> f;
    public final Provider<ActivityIntentFactory> g;
    public final Provider<DeepLinkIntentFactory> h;
    public final Provider<AdapterPresenter> i;
    public final Provider<GridLayoutManager.SpanSizeLookup> j;
    public final Provider<ImplicitIntentFactory> k;
    public final Provider<SpannedGridPositionProvider> l;
    public final Provider<DestroyableViewHolderBuilder> m;
    public final Provider<NetworkInfoBroadcastReceiver> n;
    public final Provider<FavoriteAdvertsPresenter> o;
    public final Provider<ViewedAdvertsPresenter> p;
    public final Provider<ClosedItemPresenter> q;
    public final Provider<BuildInfo> r;
    public final Provider<Analytics> s;
    public final Provider<ItemVisibilityTracker> t;
    public final Provider<Features> u;
    public final Provider<SerpInteractor> v;
    public final Provider<SchedulersFactory3> w;
    public final Provider<AdvertXlStateProvider> x;
    public final Provider<RichSnippetStateProvider> y;
    public final Provider<DfpMobileAdsWrapper> z;

    public SerpFragment_MembersInjector(Provider<SerpPresenter> provider, Provider<SerpResourcesProvider> provider2, Provider<SerpInteractor> provider3, Provider<FpsStateSupplier> provider4, Provider<SerpAnalyticsInteractor> provider5, Provider<PersistableFloatingViewsPresenter> provider6, Provider<ActivityIntentFactory> provider7, Provider<DeepLinkIntentFactory> provider8, Provider<AdapterPresenter> provider9, Provider<GridLayoutManager.SpanSizeLookup> provider10, Provider<ImplicitIntentFactory> provider11, Provider<SpannedGridPositionProvider> provider12, Provider<DestroyableViewHolderBuilder> provider13, Provider<NetworkInfoBroadcastReceiver> provider14, Provider<FavoriteAdvertsPresenter> provider15, Provider<ViewedAdvertsPresenter> provider16, Provider<ClosedItemPresenter> provider17, Provider<BuildInfo> provider18, Provider<Analytics> provider19, Provider<ItemVisibilityTracker> provider20, Provider<Features> provider21, Provider<SerpInteractor> provider22, Provider<SchedulersFactory3> provider23, Provider<AdvertXlStateProvider> provider24, Provider<RichSnippetStateProvider> provider25, Provider<DfpMobileAdsWrapper> provider26, Provider<WarningStateProvider> provider27, Provider<NotificationManagerProvider> provider28, Provider<SerpTracker> provider29, Provider<InlineFiltersPresenter> provider30, Provider<InlineFilterDialogFactory> provider31, Provider<WitcherItemPresenter> provider32, Provider<VerticalFilterPresenter> provider33, Provider<SavedSearchesPresenter> provider34, Provider<AsyncPhonePresenter> provider35, Provider<SerpSkeletonTestGroup> provider36, Provider<SerpOnboardingHandler> provider37, Provider<CartFabViewModel> provider38, Provider<CartQuantityChangesHandler> provider39) {
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
        this.D = provider30;
        this.E = provider31;
        this.F = provider32;
        this.G = provider33;
        this.H = provider34;
        this.I = provider35;
        this.J = provider36;
        this.K = provider37;
        this.L = provider38;
        this.M = provider39;
    }

    public static MembersInjector<SerpFragment> create(Provider<SerpPresenter> provider, Provider<SerpResourcesProvider> provider2, Provider<SerpInteractor> provider3, Provider<FpsStateSupplier> provider4, Provider<SerpAnalyticsInteractor> provider5, Provider<PersistableFloatingViewsPresenter> provider6, Provider<ActivityIntentFactory> provider7, Provider<DeepLinkIntentFactory> provider8, Provider<AdapterPresenter> provider9, Provider<GridLayoutManager.SpanSizeLookup> provider10, Provider<ImplicitIntentFactory> provider11, Provider<SpannedGridPositionProvider> provider12, Provider<DestroyableViewHolderBuilder> provider13, Provider<NetworkInfoBroadcastReceiver> provider14, Provider<FavoriteAdvertsPresenter> provider15, Provider<ViewedAdvertsPresenter> provider16, Provider<ClosedItemPresenter> provider17, Provider<BuildInfo> provider18, Provider<Analytics> provider19, Provider<ItemVisibilityTracker> provider20, Provider<Features> provider21, Provider<SerpInteractor> provider22, Provider<SchedulersFactory3> provider23, Provider<AdvertXlStateProvider> provider24, Provider<RichSnippetStateProvider> provider25, Provider<DfpMobileAdsWrapper> provider26, Provider<WarningStateProvider> provider27, Provider<NotificationManagerProvider> provider28, Provider<SerpTracker> provider29, Provider<InlineFiltersPresenter> provider30, Provider<InlineFilterDialogFactory> provider31, Provider<WitcherItemPresenter> provider32, Provider<VerticalFilterPresenter> provider33, Provider<SavedSearchesPresenter> provider34, Provider<AsyncPhonePresenter> provider35, Provider<SerpSkeletonTestGroup> provider36, Provider<SerpOnboardingHandler> provider37, Provider<CartFabViewModel> provider38, Provider<CartQuantityChangesHandler> provider39) {
        return new SerpFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39);
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.adapterPresenter")
    public static void injectAdapterPresenter(SerpFragment serpFragment, AdapterPresenter adapterPresenter) {
        serpFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.advertXlStateProvider")
    public static void injectAdvertXlStateProvider(SerpFragment serpFragment, AdvertXlStateProvider advertXlStateProvider) {
        serpFragment.advertXlStateProvider = advertXlStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.analytics")
    public static void injectAnalytics(SerpFragment serpFragment, Analytics analytics) {
        serpFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.analyticsInteractor")
    public static void injectAnalyticsInteractor(SerpFragment serpFragment, SerpAnalyticsInteractor serpAnalyticsInteractor) {
        serpFragment.analyticsInteractor = serpAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.asyncPhonePresenter")
    public static void injectAsyncPhonePresenter(SerpFragment serpFragment, AsyncPhonePresenter asyncPhonePresenter) {
        serpFragment.asyncPhonePresenter = asyncPhonePresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.buildInfo")
    public static void injectBuildInfo(SerpFragment serpFragment, BuildInfo buildInfo) {
        serpFragment.buildInfo = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.cartFabQuantityHandler")
    public static void injectCartFabQuantityHandler(SerpFragment serpFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        serpFragment.cartFabQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.cartFabViewModel")
    public static void injectCartFabViewModel(SerpFragment serpFragment, CartFabViewModel cartFabViewModel) {
        serpFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.closedItemPresenter")
    public static void injectClosedItemPresenter(SerpFragment serpFragment, ClosedItemPresenter closedItemPresenter) {
        serpFragment.closedItemPresenter = closedItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SerpFragment serpFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        serpFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(SerpFragment serpFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        serpFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(SerpFragment serpFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        serpFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.features")
    public static void injectFeatures(SerpFragment serpFragment, Features features) {
        serpFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.floatingViewsPresenter")
    public static void injectFloatingViewsPresenter(SerpFragment serpFragment, PersistableFloatingViewsPresenter persistableFloatingViewsPresenter) {
        serpFragment.floatingViewsPresenter = persistableFloatingViewsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.gridPositionProvider")
    public static void injectGridPositionProvider(SerpFragment serpFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        serpFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(SerpFragment serpFragment, ImplicitIntentFactory implicitIntentFactory) {
        serpFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.inlineFilterDialogFactory")
    public static void injectInlineFilterDialogFactory(SerpFragment serpFragment, InlineFilterDialogFactory inlineFilterDialogFactory) {
        serpFragment.inlineFilterDialogFactory = inlineFilterDialogFactory;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.inlineFiltersPresenter")
    public static void injectInlineFiltersPresenter(SerpFragment serpFragment, InlineFiltersPresenter inlineFiltersPresenter) {
        serpFragment.inlineFiltersPresenter = inlineFiltersPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.intentFactory")
    public static void injectIntentFactory(SerpFragment serpFragment, ActivityIntentFactory activityIntentFactory) {
        serpFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.interactor")
    public static void injectInteractor(SerpFragment serpFragment, SerpInteractor serpInteractor) {
        serpFragment.interactor = serpInteractor;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.itemVisibilityTracker")
    public static void injectItemVisibilityTracker(SerpFragment serpFragment, ItemVisibilityTracker itemVisibilityTracker) {
        serpFragment.itemVisibilityTracker = itemVisibilityTracker;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.mobileAdsWrapper")
    public static void injectMobileAdsWrapper(SerpFragment serpFragment, DfpMobileAdsWrapper dfpMobileAdsWrapper) {
        serpFragment.mobileAdsWrapper = dfpMobileAdsWrapper;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.networkInfoBroadcastReceiver")
    public static void injectNetworkInfoBroadcastReceiver(SerpFragment serpFragment, NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver) {
        serpFragment.networkInfoBroadcastReceiver = networkInfoBroadcastReceiver;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.notificationManagerProvider")
    public static void injectNotificationManagerProvider(SerpFragment serpFragment, NotificationManagerProvider notificationManagerProvider) {
        serpFragment.notificationManagerProvider = notificationManagerProvider;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.onboardingHandler")
    public static void injectOnboardingHandler(SerpFragment serpFragment, SerpOnboardingHandler serpOnboardingHandler) {
        serpFragment.onboardingHandler = serpOnboardingHandler;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.presenter")
    public static void injectPresenter(SerpFragment serpFragment, SerpPresenter serpPresenter) {
        serpFragment.presenter = serpPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.resourcesProvider")
    public static void injectResourcesProvider(SerpFragment serpFragment, SerpResourcesProvider serpResourcesProvider) {
        serpFragment.resourcesProvider = serpResourcesProvider;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.richSnippetStateProvider")
    @RichStateProvider
    public static void injectRichSnippetStateProvider(SerpFragment serpFragment, RichSnippetStateProvider richSnippetStateProvider) {
        serpFragment.richSnippetStateProvider = richSnippetStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.savedSearchPresenter")
    public static void injectSavedSearchPresenter(SerpFragment serpFragment, SavedSearchesPresenter savedSearchesPresenter) {
        serpFragment.savedSearchPresenter = savedSearchesPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.schedulers")
    public static void injectSchedulers(SerpFragment serpFragment, SchedulersFactory3 schedulersFactory3) {
        serpFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.serpInteractor")
    public static void injectSerpInteractor(SerpFragment serpFragment, SerpInteractor serpInteractor) {
        serpFragment.serpInteractor = serpInteractor;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.serpSkeletonTestGroup")
    public static void injectSerpSkeletonTestGroup(SerpFragment serpFragment, SerpSkeletonTestGroup serpSkeletonTestGroup) {
        serpFragment.serpSkeletonTestGroup = serpSkeletonTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(SerpFragment serpFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        serpFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.supplier")
    public static void injectSupplier(SerpFragment serpFragment, FpsStateSupplier fpsStateSupplier) {
        serpFragment.supplier = fpsStateSupplier;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.tracker")
    public static void injectTracker(SerpFragment serpFragment, SerpTracker serpTracker) {
        serpFragment.tracker = serpTracker;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.verticalFilterPresenter")
    public static void injectVerticalFilterPresenter(SerpFragment serpFragment, VerticalFilterPresenter verticalFilterPresenter) {
        serpFragment.verticalFilterPresenter = verticalFilterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(SerpFragment serpFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        serpFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.warningStateProvider")
    public static void injectWarningStateProvider(SerpFragment serpFragment, WarningStateProvider warningStateProvider) {
        serpFragment.warningStateProvider = warningStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.serp.SerpFragment.witcherItemPresenter")
    public static void injectWitcherItemPresenter(SerpFragment serpFragment, WitcherItemPresenter witcherItemPresenter) {
        serpFragment.witcherItemPresenter = witcherItemPresenter;
    }

    public void injectMembers(SerpFragment serpFragment) {
        injectPresenter(serpFragment, this.a.get());
        injectResourcesProvider(serpFragment, this.b.get());
        injectInteractor(serpFragment, this.c.get());
        injectSupplier(serpFragment, this.d.get());
        injectAnalyticsInteractor(serpFragment, this.e.get());
        injectFloatingViewsPresenter(serpFragment, this.f.get());
        injectIntentFactory(serpFragment, this.g.get());
        injectDeepLinkIntentFactory(serpFragment, this.h.get());
        injectAdapterPresenter(serpFragment, this.i.get());
        injectSpanSizeLookup(serpFragment, this.j.get());
        injectImplicitIntentFactory(serpFragment, this.k.get());
        injectGridPositionProvider(serpFragment, this.l.get());
        injectDestroyableViewHolderBuilder(serpFragment, this.m.get());
        injectNetworkInfoBroadcastReceiver(serpFragment, this.n.get());
        injectFavoriteAdvertsPresenter(serpFragment, this.o.get());
        injectViewedAdvertsPresenter(serpFragment, this.p.get());
        injectClosedItemPresenter(serpFragment, this.q.get());
        injectBuildInfo(serpFragment, this.r.get());
        injectAnalytics(serpFragment, this.s.get());
        injectItemVisibilityTracker(serpFragment, this.t.get());
        injectFeatures(serpFragment, this.u.get());
        injectSerpInteractor(serpFragment, this.v.get());
        injectSchedulers(serpFragment, this.w.get());
        injectAdvertXlStateProvider(serpFragment, this.x.get());
        injectRichSnippetStateProvider(serpFragment, this.y.get());
        injectMobileAdsWrapper(serpFragment, this.z.get());
        injectWarningStateProvider(serpFragment, this.A.get());
        injectNotificationManagerProvider(serpFragment, this.B.get());
        injectTracker(serpFragment, this.C.get());
        injectInlineFiltersPresenter(serpFragment, this.D.get());
        injectInlineFilterDialogFactory(serpFragment, this.E.get());
        injectWitcherItemPresenter(serpFragment, this.F.get());
        injectVerticalFilterPresenter(serpFragment, this.G.get());
        injectSavedSearchPresenter(serpFragment, this.H.get());
        injectAsyncPhonePresenter(serpFragment, this.I.get());
        injectSerpSkeletonTestGroup(serpFragment, this.J.get());
        injectOnboardingHandler(serpFragment, this.K.get());
        injectCartFabViewModel(serpFragment, this.L.get());
        injectCartFabQuantityHandler(serpFragment, this.M.get());
    }
}
