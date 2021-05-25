package com.avito.android.serp;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.serp.adapter.SerpItemSaturator;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.diff_calculator.DiffCalculator;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Pair;
public final class SerpPresenterImpl_Factory implements Factory<SerpPresenterImpl> {
    public final Provider<Relay<Pair<SnippetItem, Integer>>> A;
    public final Provider<Relay<Pair<SnippetItem, Boolean>>> B;
    public final Provider<AbTestGroup<SimpleTestGroupWithControl2>> C;
    public final Provider<InlineFiltersPresenter> D;
    public final Provider<SerpItemSaturator> E;
    public final Provider<SerpTracker> F;
    public final Provider<ItemVisibilityTracker> G;
    public final Provider<DiffCalculator> H;
    public final Provider<SavedSearchesPresenter> I;
    public final Provider<VerticalFilterPresenter> J;
    public final Provider<SkeletonGenerator> K;
    public final Provider<SerpSkeletonTestGroup> L;
    public final Provider<Preferences> M;
    public final Provider<AsyncPhonePresenter> N;
    public final Provider<SnippetScrollDepthTracker> O;
    public final Provider<SnippetScrollDepthAnalyticsInteractor> P;
    public final Provider<AppendingRetryItemPresenter> Q;
    public final Provider<SerpArguments> R;
    public final Provider<SerpPresenterState> S;
    public final Provider<SavedLocationInteractor> T;
    public final Provider<DfpDebugPresenter> a;
    public final Provider<SerpInteractor> b;
    public final Provider<SubscribeSearchInteractor> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<PersistableFloatingViewsPresenter> e;
    public final Provider<Formatter<Throwable>> f;
    public final Provider<Analytics> g;
    public final Provider<SerpAnalyticsInteractor> h;
    public final Provider<CommercialBannersAnalyticsInteractor> i;
    public final Provider<AdvertMessengerInteractor> j;
    public final Provider<SchedulersFactory3> k;
    public final Provider<SerpResourcesProvider> l;
    public final Provider<SerpSpanProvider> m;
    public final Provider<SpannedGridPositionProvider> n;
    public final Provider<String> o;
    public final Provider<ConnectionQualitySubscriber> p;
    public final Provider<FavoriteAdvertsPresenter> q;
    public final Provider<ViewedAdvertsPresenter> r;
    public final Provider<ClosedItemPresenter> s;
    public final Provider<ClosedItemInteractor> t;
    public final Provider<Features> u;
    public final Provider<AdvertXlStateProvider> v;
    public final Provider<RichSnippetStateProvider> w;
    public final Provider<Formatter<String>> x;
    public final Provider<ClickStreamLinkHandler> y;
    public final Provider<Relay<Pair<SnippetItem, Integer>>> z;

    public SerpPresenterImpl_Factory(Provider<DfpDebugPresenter> provider, Provider<SerpInteractor> provider2, Provider<SubscribeSearchInteractor> provider3, Provider<AdapterPresenter> provider4, Provider<PersistableFloatingViewsPresenter> provider5, Provider<Formatter<Throwable>> provider6, Provider<Analytics> provider7, Provider<SerpAnalyticsInteractor> provider8, Provider<CommercialBannersAnalyticsInteractor> provider9, Provider<AdvertMessengerInteractor> provider10, Provider<SchedulersFactory3> provider11, Provider<SerpResourcesProvider> provider12, Provider<SerpSpanProvider> provider13, Provider<SpannedGridPositionProvider> provider14, Provider<String> provider15, Provider<ConnectionQualitySubscriber> provider16, Provider<FavoriteAdvertsPresenter> provider17, Provider<ViewedAdvertsPresenter> provider18, Provider<ClosedItemPresenter> provider19, Provider<ClosedItemInteractor> provider20, Provider<Features> provider21, Provider<AdvertXlStateProvider> provider22, Provider<RichSnippetStateProvider> provider23, Provider<Formatter<String>> provider24, Provider<ClickStreamLinkHandler> provider25, Provider<Relay<Pair<SnippetItem, Integer>>> provider26, Provider<Relay<Pair<SnippetItem, Integer>>> provider27, Provider<Relay<Pair<SnippetItem, Boolean>>> provider28, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider29, Provider<InlineFiltersPresenter> provider30, Provider<SerpItemSaturator> provider31, Provider<SerpTracker> provider32, Provider<ItemVisibilityTracker> provider33, Provider<DiffCalculator> provider34, Provider<SavedSearchesPresenter> provider35, Provider<VerticalFilterPresenter> provider36, Provider<SkeletonGenerator> provider37, Provider<SerpSkeletonTestGroup> provider38, Provider<Preferences> provider39, Provider<AsyncPhonePresenter> provider40, Provider<SnippetScrollDepthTracker> provider41, Provider<SnippetScrollDepthAnalyticsInteractor> provider42, Provider<AppendingRetryItemPresenter> provider43, Provider<SerpArguments> provider44, Provider<SerpPresenterState> provider45, Provider<SavedLocationInteractor> provider46) {
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
        this.N = provider40;
        this.O = provider41;
        this.P = provider42;
        this.Q = provider43;
        this.R = provider44;
        this.S = provider45;
        this.T = provider46;
    }

    public static SerpPresenterImpl_Factory create(Provider<DfpDebugPresenter> provider, Provider<SerpInteractor> provider2, Provider<SubscribeSearchInteractor> provider3, Provider<AdapterPresenter> provider4, Provider<PersistableFloatingViewsPresenter> provider5, Provider<Formatter<Throwable>> provider6, Provider<Analytics> provider7, Provider<SerpAnalyticsInteractor> provider8, Provider<CommercialBannersAnalyticsInteractor> provider9, Provider<AdvertMessengerInteractor> provider10, Provider<SchedulersFactory3> provider11, Provider<SerpResourcesProvider> provider12, Provider<SerpSpanProvider> provider13, Provider<SpannedGridPositionProvider> provider14, Provider<String> provider15, Provider<ConnectionQualitySubscriber> provider16, Provider<FavoriteAdvertsPresenter> provider17, Provider<ViewedAdvertsPresenter> provider18, Provider<ClosedItemPresenter> provider19, Provider<ClosedItemInteractor> provider20, Provider<Features> provider21, Provider<AdvertXlStateProvider> provider22, Provider<RichSnippetStateProvider> provider23, Provider<Formatter<String>> provider24, Provider<ClickStreamLinkHandler> provider25, Provider<Relay<Pair<SnippetItem, Integer>>> provider26, Provider<Relay<Pair<SnippetItem, Integer>>> provider27, Provider<Relay<Pair<SnippetItem, Boolean>>> provider28, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider29, Provider<InlineFiltersPresenter> provider30, Provider<SerpItemSaturator> provider31, Provider<SerpTracker> provider32, Provider<ItemVisibilityTracker> provider33, Provider<DiffCalculator> provider34, Provider<SavedSearchesPresenter> provider35, Provider<VerticalFilterPresenter> provider36, Provider<SkeletonGenerator> provider37, Provider<SerpSkeletonTestGroup> provider38, Provider<Preferences> provider39, Provider<AsyncPhonePresenter> provider40, Provider<SnippetScrollDepthTracker> provider41, Provider<SnippetScrollDepthAnalyticsInteractor> provider42, Provider<AppendingRetryItemPresenter> provider43, Provider<SerpArguments> provider44, Provider<SerpPresenterState> provider45, Provider<SavedLocationInteractor> provider46) {
        return new SerpPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43, provider44, provider45, provider46);
    }

    public static SerpPresenterImpl newInstance(DfpDebugPresenter dfpDebugPresenter, SerpInteractor serpInteractor, SubscribeSearchInteractor subscribeSearchInteractor, AdapterPresenter adapterPresenter, PersistableFloatingViewsPresenter persistableFloatingViewsPresenter, Formatter<Throwable> formatter, Analytics analytics, SerpAnalyticsInteractor serpAnalyticsInteractor, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, AdvertMessengerInteractor advertMessengerInteractor, SchedulersFactory3 schedulersFactory3, SerpResourcesProvider serpResourcesProvider, SerpSpanProvider serpSpanProvider, SpannedGridPositionProvider spannedGridPositionProvider, String str, ConnectionQualitySubscriber connectionQualitySubscriber, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, ClosedItemPresenter closedItemPresenter, ClosedItemInteractor closedItemInteractor, Features features, AdvertXlStateProvider advertXlStateProvider, RichSnippetStateProvider richSnippetStateProvider, Formatter<String> formatter2, ClickStreamLinkHandler clickStreamLinkHandler, Relay<Pair<SnippetItem, Integer>> relay, Relay<Pair<SnippetItem, Integer>> relay2, Relay<Pair<SnippetItem, Boolean>> relay3, AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, InlineFiltersPresenter inlineFiltersPresenter, SerpItemSaturator serpItemSaturator, SerpTracker serpTracker, ItemVisibilityTracker itemVisibilityTracker, DiffCalculator diffCalculator, SavedSearchesPresenter savedSearchesPresenter, VerticalFilterPresenter verticalFilterPresenter, SkeletonGenerator skeletonGenerator, SerpSkeletonTestGroup serpSkeletonTestGroup, Preferences preferences, AsyncPhonePresenter asyncPhonePresenter, SnippetScrollDepthTracker snippetScrollDepthTracker, SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor, AppendingRetryItemPresenter appendingRetryItemPresenter, SerpArguments serpArguments, SerpPresenterState serpPresenterState, SavedLocationInteractor savedLocationInteractor) {
        return new SerpPresenterImpl(dfpDebugPresenter, serpInteractor, subscribeSearchInteractor, adapterPresenter, persistableFloatingViewsPresenter, formatter, analytics, serpAnalyticsInteractor, commercialBannersAnalyticsInteractor, advertMessengerInteractor, schedulersFactory3, serpResourcesProvider, serpSpanProvider, spannedGridPositionProvider, str, connectionQualitySubscriber, favoriteAdvertsPresenter, viewedAdvertsPresenter, closedItemPresenter, closedItemInteractor, features, advertXlStateProvider, richSnippetStateProvider, formatter2, clickStreamLinkHandler, relay, relay2, relay3, abTestGroup, inlineFiltersPresenter, serpItemSaturator, serpTracker, itemVisibilityTracker, diffCalculator, savedSearchesPresenter, verticalFilterPresenter, skeletonGenerator, serpSkeletonTestGroup, preferences, asyncPhonePresenter, snippetScrollDepthTracker, snippetScrollDepthAnalyticsInteractor, appendingRetryItemPresenter, serpArguments, serpPresenterState, savedLocationInteractor);
    }

    @Override // javax.inject.Provider
    public SerpPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get(), this.J.get(), this.K.get(), this.L.get(), this.M.get(), this.N.get(), this.O.get(), this.P.get(), this.Q.get(), this.R.get(), this.S.get(), this.T.get());
    }
}
