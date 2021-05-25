package com.avito.android.search.map.view;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpListViewBinderImpl_Factory implements Factory<SerpListViewBinderImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<FavoriteAdvertsPresenter> b;
    public final Provider<ViewedAdvertsPresenter> c;
    public final Provider<SerpSpanProvider> d;
    public final Provider<SpannedGridPositionProvider> e;
    public final Provider<ItemVisibilityTracker> f;
    public final Provider<ClosedItemPresenter> g;
    public final Provider<AppendingRetryListener> h;
    public final Provider<PublishFloatingViewsProvider> i;
    public final Provider<SnippetScrollDepthTracker> j;

    public SerpListViewBinderImpl_Factory(Provider<AdapterPresenter> provider, Provider<FavoriteAdvertsPresenter> provider2, Provider<ViewedAdvertsPresenter> provider3, Provider<SerpSpanProvider> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<ItemVisibilityTracker> provider6, Provider<ClosedItemPresenter> provider7, Provider<AppendingRetryListener> provider8, Provider<PublishFloatingViewsProvider> provider9, Provider<SnippetScrollDepthTracker> provider10) {
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
    }

    public static SerpListViewBinderImpl_Factory create(Provider<AdapterPresenter> provider, Provider<FavoriteAdvertsPresenter> provider2, Provider<ViewedAdvertsPresenter> provider3, Provider<SerpSpanProvider> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<ItemVisibilityTracker> provider6, Provider<ClosedItemPresenter> provider7, Provider<AppendingRetryListener> provider8, Provider<PublishFloatingViewsProvider> provider9, Provider<SnippetScrollDepthTracker> provider10) {
        return new SerpListViewBinderImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static SerpListViewBinderImpl newInstance(AdapterPresenter adapterPresenter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, SerpSpanProvider serpSpanProvider, SpannedGridPositionProvider spannedGridPositionProvider, ItemVisibilityTracker itemVisibilityTracker, ClosedItemPresenter closedItemPresenter, AppendingRetryListener appendingRetryListener, PublishFloatingViewsProvider publishFloatingViewsProvider, SnippetScrollDepthTracker snippetScrollDepthTracker) {
        return new SerpListViewBinderImpl(adapterPresenter, favoriteAdvertsPresenter, viewedAdvertsPresenter, serpSpanProvider, spannedGridPositionProvider, itemVisibilityTracker, closedItemPresenter, appendingRetryListener, publishFloatingViewsProvider, snippetScrollDepthTracker);
    }

    @Override // javax.inject.Provider
    public SerpListViewBinderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
