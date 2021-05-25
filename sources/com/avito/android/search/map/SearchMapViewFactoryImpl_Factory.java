package com.avito.android.search.map;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.interactor.MapAreaConverter;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import com.avito.android.search.map.view.MarkerIconFactory;
import com.avito.android.search.map.view.PinAdvertsListViewBinder;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.SerpListViewBinder;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Pair;
public final class SearchMapViewFactoryImpl_Factory implements Factory<SearchMapViewFactoryImpl> {
    public final Provider<InlineFilterDialogFactory> A;
    public final Provider<SavedSearchesPresenter> B;
    public final Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> C;
    public final Provider<SerpItemsPrefetchTestGroup> D;
    public final Provider<Features> E;
    public final Provider<FavoriteAdvertsPresenter> F;
    public final Provider<SnippetScrollDepthTracker> G;
    public final Provider<SchedulersFactory3> a;
    public final Provider<SuggestInteractor> b;
    public final Provider<MarkerIconFactory> c;
    public final Provider<Analytics> d;
    public final Provider<PinAdvertsListViewBinder> e;
    public final Provider<SimpleRecyclerAdapter> f;
    public final Provider<GridLayoutManager.SpanSizeLookup> g;
    public final Provider<SpannedGridPositionProvider> h;
    public final Provider<AppendingRetryListener> i;
    public final Provider<SerpListViewBinder> j;
    public final Provider<SimpleRecyclerAdapter> k;
    public final Provider<GridLayoutManager.SpanSizeLookup> l;
    public final Provider<SpannedGridPositionProvider> m;
    public final Provider<AppendingRetryListener> n;
    public final Provider<ItemVisibilityTracker> o;
    public final Provider<SerpListResourcesProvider> p;
    public final Provider<MapAreaConverter> q;
    public final Provider<Relay<Pair<SnippetItem, Integer>>> r;
    public final Provider<Relay<Pair<SnippetItem, Integer>>> s;
    public final Provider<Relay<Pair<SnippetItem, Boolean>>> t;
    public final Provider<PublishFloatingViewsProvider> u;
    public final Provider<BottomSheetBehaviourEventsProvider> v;
    public final Provider<BottomSheetBehaviourEventsProvider> w;
    public final Provider<SearchMapTracker> x;
    public final Provider<AvitoMapAttachHelper> y;
    public final Provider<InlineFiltersPresenter> z;

    public SearchMapViewFactoryImpl_Factory(Provider<SchedulersFactory3> provider, Provider<SuggestInteractor> provider2, Provider<MarkerIconFactory> provider3, Provider<Analytics> provider4, Provider<PinAdvertsListViewBinder> provider5, Provider<SimpleRecyclerAdapter> provider6, Provider<GridLayoutManager.SpanSizeLookup> provider7, Provider<SpannedGridPositionProvider> provider8, Provider<AppendingRetryListener> provider9, Provider<SerpListViewBinder> provider10, Provider<SimpleRecyclerAdapter> provider11, Provider<GridLayoutManager.SpanSizeLookup> provider12, Provider<SpannedGridPositionProvider> provider13, Provider<AppendingRetryListener> provider14, Provider<ItemVisibilityTracker> provider15, Provider<SerpListResourcesProvider> provider16, Provider<MapAreaConverter> provider17, Provider<Relay<Pair<SnippetItem, Integer>>> provider18, Provider<Relay<Pair<SnippetItem, Integer>>> provider19, Provider<Relay<Pair<SnippetItem, Boolean>>> provider20, Provider<PublishFloatingViewsProvider> provider21, Provider<BottomSheetBehaviourEventsProvider> provider22, Provider<BottomSheetBehaviourEventsProvider> provider23, Provider<SearchMapTracker> provider24, Provider<AvitoMapAttachHelper> provider25, Provider<InlineFiltersPresenter> provider26, Provider<InlineFilterDialogFactory> provider27, Provider<SavedSearchesPresenter> provider28, Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> provider29, Provider<SerpItemsPrefetchTestGroup> provider30, Provider<Features> provider31, Provider<FavoriteAdvertsPresenter> provider32, Provider<SnippetScrollDepthTracker> provider33) {
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
    }

    public static SearchMapViewFactoryImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<SuggestInteractor> provider2, Provider<MarkerIconFactory> provider3, Provider<Analytics> provider4, Provider<PinAdvertsListViewBinder> provider5, Provider<SimpleRecyclerAdapter> provider6, Provider<GridLayoutManager.SpanSizeLookup> provider7, Provider<SpannedGridPositionProvider> provider8, Provider<AppendingRetryListener> provider9, Provider<SerpListViewBinder> provider10, Provider<SimpleRecyclerAdapter> provider11, Provider<GridLayoutManager.SpanSizeLookup> provider12, Provider<SpannedGridPositionProvider> provider13, Provider<AppendingRetryListener> provider14, Provider<ItemVisibilityTracker> provider15, Provider<SerpListResourcesProvider> provider16, Provider<MapAreaConverter> provider17, Provider<Relay<Pair<SnippetItem, Integer>>> provider18, Provider<Relay<Pair<SnippetItem, Integer>>> provider19, Provider<Relay<Pair<SnippetItem, Boolean>>> provider20, Provider<PublishFloatingViewsProvider> provider21, Provider<BottomSheetBehaviourEventsProvider> provider22, Provider<BottomSheetBehaviourEventsProvider> provider23, Provider<SearchMapTracker> provider24, Provider<AvitoMapAttachHelper> provider25, Provider<InlineFiltersPresenter> provider26, Provider<InlineFilterDialogFactory> provider27, Provider<SavedSearchesPresenter> provider28, Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> provider29, Provider<SerpItemsPrefetchTestGroup> provider30, Provider<Features> provider31, Provider<FavoriteAdvertsPresenter> provider32, Provider<SnippetScrollDepthTracker> provider33) {
        return new SearchMapViewFactoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33);
    }

    public static SearchMapViewFactoryImpl newInstance(SchedulersFactory3 schedulersFactory3, SuggestInteractor suggestInteractor, MarkerIconFactory markerIconFactory, Analytics analytics, PinAdvertsListViewBinder pinAdvertsListViewBinder, SimpleRecyclerAdapter simpleRecyclerAdapter, GridLayoutManager.SpanSizeLookup spanSizeLookup, SpannedGridPositionProvider spannedGridPositionProvider, AppendingRetryListener appendingRetryListener, SerpListViewBinder serpListViewBinder, SimpleRecyclerAdapter simpleRecyclerAdapter2, GridLayoutManager.SpanSizeLookup spanSizeLookup2, SpannedGridPositionProvider spannedGridPositionProvider2, AppendingRetryListener appendingRetryListener2, ItemVisibilityTracker itemVisibilityTracker, SerpListResourcesProvider serpListResourcesProvider, MapAreaConverter mapAreaConverter, Relay<Pair<SnippetItem, Integer>> relay, Relay<Pair<SnippetItem, Integer>> relay2, Relay<Pair<SnippetItem, Boolean>> relay3, PublishFloatingViewsProvider publishFloatingViewsProvider, BottomSheetBehaviourEventsProvider bottomSheetBehaviourEventsProvider, BottomSheetBehaviourEventsProvider bottomSheetBehaviourEventsProvider2, SearchMapTracker searchMapTracker, AvitoMapAttachHelper avitoMapAttachHelper, InlineFiltersPresenter inlineFiltersPresenter, InlineFilterDialogFactory inlineFilterDialogFactory, SavedSearchesPresenter savedSearchesPresenter, ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup, SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup, Features features, FavoriteAdvertsPresenter favoriteAdvertsPresenter, SnippetScrollDepthTracker snippetScrollDepthTracker) {
        return new SearchMapViewFactoryImpl(schedulersFactory3, suggestInteractor, markerIconFactory, analytics, pinAdvertsListViewBinder, simpleRecyclerAdapter, spanSizeLookup, spannedGridPositionProvider, appendingRetryListener, serpListViewBinder, simpleRecyclerAdapter2, spanSizeLookup2, spannedGridPositionProvider2, appendingRetryListener2, itemVisibilityTracker, serpListResourcesProvider, mapAreaConverter, relay, relay2, relay3, publishFloatingViewsProvider, bottomSheetBehaviourEventsProvider, bottomSheetBehaviourEventsProvider2, searchMapTracker, avitoMapAttachHelper, inlineFiltersPresenter, inlineFilterDialogFactory, savedSearchesPresenter, manuallyExposedAbTestGroup, serpItemsPrefetchTestGroup, features, favoriteAdvertsPresenter, snippetScrollDepthTracker);
    }

    @Override // javax.inject.Provider
    public SearchMapViewFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get());
    }
}
