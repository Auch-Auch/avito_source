package com.avito.android.home;

import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.advert.actions.HiddenAdvertItemPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.geo.GeoStorage;
import com.avito.android.home.analytics.HomeAnalyticsInteractor;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider;
import com.avito.android.home.tabs_item.SectionTabsItemPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.preferences.UpdateStorage;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.location_notification.LocationNotificationActionData;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Pair;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
public final class HomePresenterImpl_Factory implements Factory<HomePresenterImpl> {
    public final Provider<ItemVisibilityTracker> A;
    public final Provider<HiddenAdvertItemPresenter> B;
    public final Provider<LocationAnalyticsInteractor> C;
    public final Provider<GeoStorage> D;
    public final Provider<SkeletonGenerator> E;
    public final Provider<HomeSkeletonTestGroup> F;
    public final Provider<HomeNewRubricatorTestGroup> G;
    public final Provider<HomePresenterState> H;
    public final Provider<HomeInteractor> a;
    public final Provider<PersistableFloatingViewsPresenter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<AppendingRetryItemPresenter> d;
    public final Provider<ErrorFormatter> e;
    public final Provider<HomeAnalyticsInteractor> f;
    public final Provider<SnippetScrollDepthAnalyticsInteractor> g;
    public final Provider<SnippetScrollDepthTracker> h;
    public final Provider<CommercialBannersAnalyticsInteractor> i;
    public final Provider<SchedulersFactory3> j;
    public final Provider<HomePresenterResourcesProvider> k;
    public final Provider<SerpSpanProvider> l;
    public final Provider<ShortcutNavigationItemConverter> m;
    public final Provider<SpannedGridPositionProvider> n;
    public final Provider<ConnectionQualitySubscriber> o;
    public final Provider<FavoriteAdvertsPresenter> p;
    public final Provider<DefaultSearchLocationPermissionProvider> q;
    public final Provider<ViewedAdvertsPresenter> r;
    public final Provider<SectionTabsItemPresenter> s;
    public final Provider<Relay<Pair<SnippetItem, Integer>>> t;
    public final Provider<Relay<LocationNotificationActionData>> u;
    public final Provider<Relay<LocationNotificationActionData>> v;
    public final Provider<Features> w;
    public final Provider<UpdateStorage> x;
    public final Provider<IdProvider> y;
    public final Provider<HomeTracker> z;

    public HomePresenterImpl_Factory(Provider<HomeInteractor> provider, Provider<PersistableFloatingViewsPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<AppendingRetryItemPresenter> provider4, Provider<ErrorFormatter> provider5, Provider<HomeAnalyticsInteractor> provider6, Provider<SnippetScrollDepthAnalyticsInteractor> provider7, Provider<SnippetScrollDepthTracker> provider8, Provider<CommercialBannersAnalyticsInteractor> provider9, Provider<SchedulersFactory3> provider10, Provider<HomePresenterResourcesProvider> provider11, Provider<SerpSpanProvider> provider12, Provider<ShortcutNavigationItemConverter> provider13, Provider<SpannedGridPositionProvider> provider14, Provider<ConnectionQualitySubscriber> provider15, Provider<FavoriteAdvertsPresenter> provider16, Provider<DefaultSearchLocationPermissionProvider> provider17, Provider<ViewedAdvertsPresenter> provider18, Provider<SectionTabsItemPresenter> provider19, Provider<Relay<Pair<SnippetItem, Integer>>> provider20, Provider<Relay<LocationNotificationActionData>> provider21, Provider<Relay<LocationNotificationActionData>> provider22, Provider<Features> provider23, Provider<UpdateStorage> provider24, Provider<IdProvider> provider25, Provider<HomeTracker> provider26, Provider<ItemVisibilityTracker> provider27, Provider<HiddenAdvertItemPresenter> provider28, Provider<LocationAnalyticsInteractor> provider29, Provider<GeoStorage> provider30, Provider<SkeletonGenerator> provider31, Provider<HomeSkeletonTestGroup> provider32, Provider<HomeNewRubricatorTestGroup> provider33, Provider<HomePresenterState> provider34) {
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
    }

    public static HomePresenterImpl_Factory create(Provider<HomeInteractor> provider, Provider<PersistableFloatingViewsPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<AppendingRetryItemPresenter> provider4, Provider<ErrorFormatter> provider5, Provider<HomeAnalyticsInteractor> provider6, Provider<SnippetScrollDepthAnalyticsInteractor> provider7, Provider<SnippetScrollDepthTracker> provider8, Provider<CommercialBannersAnalyticsInteractor> provider9, Provider<SchedulersFactory3> provider10, Provider<HomePresenterResourcesProvider> provider11, Provider<SerpSpanProvider> provider12, Provider<ShortcutNavigationItemConverter> provider13, Provider<SpannedGridPositionProvider> provider14, Provider<ConnectionQualitySubscriber> provider15, Provider<FavoriteAdvertsPresenter> provider16, Provider<DefaultSearchLocationPermissionProvider> provider17, Provider<ViewedAdvertsPresenter> provider18, Provider<SectionTabsItemPresenter> provider19, Provider<Relay<Pair<SnippetItem, Integer>>> provider20, Provider<Relay<LocationNotificationActionData>> provider21, Provider<Relay<LocationNotificationActionData>> provider22, Provider<Features> provider23, Provider<UpdateStorage> provider24, Provider<IdProvider> provider25, Provider<HomeTracker> provider26, Provider<ItemVisibilityTracker> provider27, Provider<HiddenAdvertItemPresenter> provider28, Provider<LocationAnalyticsInteractor> provider29, Provider<GeoStorage> provider30, Provider<SkeletonGenerator> provider31, Provider<HomeSkeletonTestGroup> provider32, Provider<HomeNewRubricatorTestGroup> provider33, Provider<HomePresenterState> provider34) {
        return new HomePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34);
    }

    public static HomePresenterImpl newInstance(HomeInteractor homeInteractor, PersistableFloatingViewsPresenter persistableFloatingViewsPresenter, AdapterPresenter adapterPresenter, AppendingRetryItemPresenter appendingRetryItemPresenter, ErrorFormatter errorFormatter, HomeAnalyticsInteractor homeAnalyticsInteractor, SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor, SnippetScrollDepthTracker snippetScrollDepthTracker, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, SchedulersFactory3 schedulersFactory3, HomePresenterResourcesProvider homePresenterResourcesProvider, SerpSpanProvider serpSpanProvider, ShortcutNavigationItemConverter shortcutNavigationItemConverter, SpannedGridPositionProvider spannedGridPositionProvider, ConnectionQualitySubscriber connectionQualitySubscriber, FavoriteAdvertsPresenter favoriteAdvertsPresenter, DefaultSearchLocationPermissionProvider defaultSearchLocationPermissionProvider, ViewedAdvertsPresenter viewedAdvertsPresenter, SectionTabsItemPresenter sectionTabsItemPresenter, Relay<Pair<SnippetItem, Integer>> relay, Relay<LocationNotificationActionData> relay2, Relay<LocationNotificationActionData> relay3, Features features, UpdateStorage updateStorage, IdProvider idProvider, HomeTracker homeTracker, ItemVisibilityTracker itemVisibilityTracker, HiddenAdvertItemPresenter hiddenAdvertItemPresenter, LocationAnalyticsInteractor locationAnalyticsInteractor, GeoStorage geoStorage, SkeletonGenerator skeletonGenerator, HomeSkeletonTestGroup homeSkeletonTestGroup, HomeNewRubricatorTestGroup homeNewRubricatorTestGroup, HomePresenterState homePresenterState) {
        return new HomePresenterImpl(homeInteractor, persistableFloatingViewsPresenter, adapterPresenter, appendingRetryItemPresenter, errorFormatter, homeAnalyticsInteractor, snippetScrollDepthAnalyticsInteractor, snippetScrollDepthTracker, commercialBannersAnalyticsInteractor, schedulersFactory3, homePresenterResourcesProvider, serpSpanProvider, shortcutNavigationItemConverter, spannedGridPositionProvider, connectionQualitySubscriber, favoriteAdvertsPresenter, defaultSearchLocationPermissionProvider, viewedAdvertsPresenter, sectionTabsItemPresenter, relay, relay2, relay3, features, updateStorage, idProvider, homeTracker, itemVisibilityTracker, hiddenAdvertItemPresenter, locationAnalyticsInteractor, geoStorage, skeletonGenerator, homeSkeletonTestGroup, homeNewRubricatorTestGroup, homePresenterState);
    }

    @Override // javax.inject.Provider
    public HomePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get());
    }
}
