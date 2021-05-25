package com.avito.android.search.map;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.RealtyNewBackNavigation;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.redux.SubscribableStore;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.di.SerpList;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.middleware.NavigationMiddleware;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SearchMapFragment_MembersInjector implements MembersInjector<SearchMapFragment> {
    public final Provider<ApplicationStartupTasksRegistry> A;
    public final Provider<SnippetScrollDepthAnalyticsInteractor> B;
    public final Provider<SnippetScrollDepthTracker> C;
    public final Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> D;
    public final Provider<SavedLocationInteractor> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<FpsStateSupplier> d;
    public final Provider<ImplicitIntentFactory> e;
    public final Provider<NavigationMiddleware> f;
    public final Provider<SearchMapViewFactory> g;
    public final Provider<ViewBinder> h;
    public final Provider<AdvertXlStateProvider> i;
    public final Provider<RichSnippetStateProvider> j;
    public final Provider<InlineFiltersPresenter> k;
    public final Provider<SavedSearchesPresenter> l;
    public final Provider<NotificationManagerProvider> m;
    public final Provider<AsyncPhonePresenter> n;
    public final Provider<Formatter<Throwable>> o;
    public final Provider<Formatter<String>> p;
    public final Provider<SubscribableStore<SearchMapState, ? super MapAction>> q;
    public final Provider<SearchMapAnalyticsInteractor> r;
    public final Provider<CommercialBannersAnalyticsInteractor> s;
    public final Provider<SerpCacheInteractor> t;
    public final Provider<Features> u;
    public final Provider<SearchMapTracker> v;
    public final Provider<ItemVisibilityTracker> w;
    public final Provider<AbTestGroup<SimpleTestGroupWithControl2>> x;
    public final Provider<WitcherItemPresenter> y;
    public final Provider<FindLocationPresenter> z;

    public SearchMapFragment_MembersInjector(Provider<SavedLocationInteractor> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<FpsStateSupplier> provider4, Provider<ImplicitIntentFactory> provider5, Provider<NavigationMiddleware> provider6, Provider<SearchMapViewFactory> provider7, Provider<ViewBinder> provider8, Provider<AdvertXlStateProvider> provider9, Provider<RichSnippetStateProvider> provider10, Provider<InlineFiltersPresenter> provider11, Provider<SavedSearchesPresenter> provider12, Provider<NotificationManagerProvider> provider13, Provider<AsyncPhonePresenter> provider14, Provider<Formatter<Throwable>> provider15, Provider<Formatter<String>> provider16, Provider<SubscribableStore<SearchMapState, ? super MapAction>> provider17, Provider<SearchMapAnalyticsInteractor> provider18, Provider<CommercialBannersAnalyticsInteractor> provider19, Provider<SerpCacheInteractor> provider20, Provider<Features> provider21, Provider<SearchMapTracker> provider22, Provider<ItemVisibilityTracker> provider23, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider24, Provider<WitcherItemPresenter> provider25, Provider<FindLocationPresenter> provider26, Provider<ApplicationStartupTasksRegistry> provider27, Provider<SnippetScrollDepthAnalyticsInteractor> provider28, Provider<SnippetScrollDepthTracker> provider29, Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> provider30) {
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
    }

    public static MembersInjector<SearchMapFragment> create(Provider<SavedLocationInteractor> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<FpsStateSupplier> provider4, Provider<ImplicitIntentFactory> provider5, Provider<NavigationMiddleware> provider6, Provider<SearchMapViewFactory> provider7, Provider<ViewBinder> provider8, Provider<AdvertXlStateProvider> provider9, Provider<RichSnippetStateProvider> provider10, Provider<InlineFiltersPresenter> provider11, Provider<SavedSearchesPresenter> provider12, Provider<NotificationManagerProvider> provider13, Provider<AsyncPhonePresenter> provider14, Provider<Formatter<Throwable>> provider15, Provider<Formatter<String>> provider16, Provider<SubscribableStore<SearchMapState, ? super MapAction>> provider17, Provider<SearchMapAnalyticsInteractor> provider18, Provider<CommercialBannersAnalyticsInteractor> provider19, Provider<SerpCacheInteractor> provider20, Provider<Features> provider21, Provider<SearchMapTracker> provider22, Provider<ItemVisibilityTracker> provider23, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider24, Provider<WitcherItemPresenter> provider25, Provider<FindLocationPresenter> provider26, Provider<ApplicationStartupTasksRegistry> provider27, Provider<SnippetScrollDepthAnalyticsInteractor> provider28, Provider<SnippetScrollDepthTracker> provider29, Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> provider30) {
        return new SearchMapFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30);
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.advertXlStateProvider")
    public static void injectAdvertXlStateProvider(SearchMapFragment searchMapFragment, AdvertXlStateProvider advertXlStateProvider) {
        searchMapFragment.advertXlStateProvider = advertXlStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.analyticsInteractor")
    public static void injectAnalyticsInteractor(SearchMapFragment searchMapFragment, SearchMapAnalyticsInteractor searchMapAnalyticsInteractor) {
        searchMapFragment.analyticsInteractor = searchMapAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.asyncPhonePresenter")
    public static void injectAsyncPhonePresenter(SearchMapFragment searchMapFragment, AsyncPhonePresenter asyncPhonePresenter) {
        searchMapFragment.asyncPhonePresenter = asyncPhonePresenter;
    }

    @RealtyNewBackNavigation
    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.backNavigationTestGroup")
    public static void injectBackNavigationTestGroup(SearchMapFragment searchMapFragment, ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup) {
        searchMapFragment.backNavigationTestGroup = manuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.commercialBannersAnalyticsInteractor")
    public static void injectCommercialBannersAnalyticsInteractor(SearchMapFragment searchMapFragment, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor) {
        searchMapFragment.commercialBannersAnalyticsInteractor = commercialBannersAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SearchMapFragment searchMapFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        searchMapFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.errorFormatter")
    public static void injectErrorFormatter(SearchMapFragment searchMapFragment, Formatter<Throwable> formatter) {
        searchMapFragment.errorFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.features")
    public static void injectFeatures(SearchMapFragment searchMapFragment, Features features) {
        searchMapFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.findLocationPresenter")
    public static void injectFindLocationPresenter(SearchMapFragment searchMapFragment, FindLocationPresenter findLocationPresenter) {
        searchMapFragment.findLocationPresenter = findLocationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(SearchMapFragment searchMapFragment, ImplicitIntentFactory implicitIntentFactory) {
        searchMapFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.inlineFiltersPresenter")
    public static void injectInlineFiltersPresenter(SearchMapFragment searchMapFragment, InlineFiltersPresenter inlineFiltersPresenter) {
        searchMapFragment.inlineFiltersPresenter = inlineFiltersPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.intentFactory")
    public static void injectIntentFactory(SearchMapFragment searchMapFragment, ActivityIntentFactory activityIntentFactory) {
        searchMapFragment.intentFactory = activityIntentFactory;
    }

    @JustDialSellerPhoneTestGroup
    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.justDialSellerPhoneTestGroup")
    public static void injectJustDialSellerPhoneTestGroup(SearchMapFragment searchMapFragment, AbTestGroup<SimpleTestGroupWithControl2> abTestGroup) {
        searchMapFragment.justDialSellerPhoneTestGroup = abTestGroup;
    }

    @SerpList
    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.listItemVisibilityTracker")
    public static void injectListItemVisibilityTracker(SearchMapFragment searchMapFragment, ItemVisibilityTracker itemVisibilityTracker) {
        searchMapFragment.listItemVisibilityTracker = itemVisibilityTracker;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.locationInteractor")
    public static void injectLocationInteractor(SearchMapFragment searchMapFragment, SavedLocationInteractor savedLocationInteractor) {
        searchMapFragment.locationInteractor = savedLocationInteractor;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.navigationMiddleware")
    public static void injectNavigationMiddleware(SearchMapFragment searchMapFragment, NavigationMiddleware navigationMiddleware) {
        searchMapFragment.navigationMiddleware = navigationMiddleware;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.notificationManagerProvider")
    public static void injectNotificationManagerProvider(SearchMapFragment searchMapFragment, NotificationManagerProvider notificationManagerProvider) {
        searchMapFragment.notificationManagerProvider = notificationManagerProvider;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.phoneNumberFormatter")
    public static void injectPhoneNumberFormatter(SearchMapFragment searchMapFragment, Formatter<String> formatter) {
        searchMapFragment.phoneNumberFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.richSnippetStateProvider")
    @RichStateProvider
    public static void injectRichSnippetStateProvider(SearchMapFragment searchMapFragment, RichSnippetStateProvider richSnippetStateProvider) {
        searchMapFragment.richSnippetStateProvider = richSnippetStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.savedSearchesPresenter")
    public static void injectSavedSearchesPresenter(SearchMapFragment searchMapFragment, SavedSearchesPresenter savedSearchesPresenter) {
        searchMapFragment.savedSearchesPresenter = savedSearchesPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.searchMapTracker")
    public static void injectSearchMapTracker(SearchMapFragment searchMapFragment, SearchMapTracker searchMapTracker) {
        searchMapFragment.searchMapTracker = searchMapTracker;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.serpCacheInteractor")
    public static void injectSerpCacheInteractor(SearchMapFragment searchMapFragment, SerpCacheInteractor serpCacheInteractor) {
        searchMapFragment.serpCacheInteractor = serpCacheInteractor;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.snippetScrollDepthAnalyticsInteractor")
    public static void injectSnippetScrollDepthAnalyticsInteractor(SearchMapFragment searchMapFragment, SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor) {
        searchMapFragment.snippetScrollDepthAnalyticsInteractor = snippetScrollDepthAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.snippetScrollDepthTracker")
    public static void injectSnippetScrollDepthTracker(SearchMapFragment searchMapFragment, SnippetScrollDepthTracker snippetScrollDepthTracker) {
        searchMapFragment.snippetScrollDepthTracker = snippetScrollDepthTracker;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.store")
    public static void injectStore(SearchMapFragment searchMapFragment, SubscribableStore<SearchMapState, ? super MapAction> subscribableStore) {
        searchMapFragment.store = subscribableStore;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.supplier")
    public static void injectSupplier(SearchMapFragment searchMapFragment, FpsStateSupplier fpsStateSupplier) {
        searchMapFragment.supplier = fpsStateSupplier;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.tasksRegistry")
    public static void injectTasksRegistry(SearchMapFragment searchMapFragment, ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        searchMapFragment.tasksRegistry = applicationStartupTasksRegistry;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.viewBinder")
    public static void injectViewBinder(SearchMapFragment searchMapFragment, ViewBinder viewBinder) {
        searchMapFragment.viewBinder = viewBinder;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.viewFactory")
    public static void injectViewFactory(SearchMapFragment searchMapFragment, SearchMapViewFactory searchMapViewFactory) {
        searchMapFragment.viewFactory = searchMapViewFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.map.SearchMapFragment.witcherItemPresenter")
    public static void injectWitcherItemPresenter(SearchMapFragment searchMapFragment, WitcherItemPresenter witcherItemPresenter) {
        searchMapFragment.witcherItemPresenter = witcherItemPresenter;
    }

    public void injectMembers(SearchMapFragment searchMapFragment) {
        injectLocationInteractor(searchMapFragment, this.a.get());
        injectDeepLinkIntentFactory(searchMapFragment, this.b.get());
        injectIntentFactory(searchMapFragment, this.c.get());
        injectSupplier(searchMapFragment, this.d.get());
        injectImplicitIntentFactory(searchMapFragment, this.e.get());
        injectNavigationMiddleware(searchMapFragment, this.f.get());
        injectViewFactory(searchMapFragment, this.g.get());
        injectViewBinder(searchMapFragment, this.h.get());
        injectAdvertXlStateProvider(searchMapFragment, this.i.get());
        injectRichSnippetStateProvider(searchMapFragment, this.j.get());
        injectInlineFiltersPresenter(searchMapFragment, this.k.get());
        injectSavedSearchesPresenter(searchMapFragment, this.l.get());
        injectNotificationManagerProvider(searchMapFragment, this.m.get());
        injectAsyncPhonePresenter(searchMapFragment, this.n.get());
        injectErrorFormatter(searchMapFragment, this.o.get());
        injectPhoneNumberFormatter(searchMapFragment, this.p.get());
        injectStore(searchMapFragment, this.q.get());
        injectAnalyticsInteractor(searchMapFragment, this.r.get());
        injectCommercialBannersAnalyticsInteractor(searchMapFragment, this.s.get());
        injectSerpCacheInteractor(searchMapFragment, this.t.get());
        injectFeatures(searchMapFragment, this.u.get());
        injectSearchMapTracker(searchMapFragment, this.v.get());
        injectListItemVisibilityTracker(searchMapFragment, this.w.get());
        injectJustDialSellerPhoneTestGroup(searchMapFragment, this.x.get());
        injectWitcherItemPresenter(searchMapFragment, this.y.get());
        injectFindLocationPresenter(searchMapFragment, this.z.get());
        injectTasksRegistry(searchMapFragment, this.A.get());
        injectSnippetScrollDepthAnalyticsInteractor(searchMapFragment, this.B.get());
        injectSnippetScrollDepthTracker(searchMapFragment, this.C.get());
        injectBackNavigationTestGroup(searchMapFragment, this.D.get());
    }
}
