package com.avito.android.search.map.view;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PinAdvertsListViewBinderImpl_Factory implements Factory<PinAdvertsListViewBinderImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<FavoriteAdvertsPresenter> b;
    public final Provider<ViewedAdvertsPresenter> c;
    public final Provider<SerpSpanProvider> d;
    public final Provider<SpannedGridPositionProvider> e;
    public final Provider<AppendingRetryListener> f;
    public final Provider<PublishFloatingViewsProvider> g;

    public PinAdvertsListViewBinderImpl_Factory(Provider<AdapterPresenter> provider, Provider<FavoriteAdvertsPresenter> provider2, Provider<ViewedAdvertsPresenter> provider3, Provider<SerpSpanProvider> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<AppendingRetryListener> provider6, Provider<PublishFloatingViewsProvider> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static PinAdvertsListViewBinderImpl_Factory create(Provider<AdapterPresenter> provider, Provider<FavoriteAdvertsPresenter> provider2, Provider<ViewedAdvertsPresenter> provider3, Provider<SerpSpanProvider> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<AppendingRetryListener> provider6, Provider<PublishFloatingViewsProvider> provider7) {
        return new PinAdvertsListViewBinderImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PinAdvertsListViewBinderImpl newInstance(AdapterPresenter adapterPresenter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, SerpSpanProvider serpSpanProvider, SpannedGridPositionProvider spannedGridPositionProvider, AppendingRetryListener appendingRetryListener, PublishFloatingViewsProvider publishFloatingViewsProvider) {
        return new PinAdvertsListViewBinderImpl(adapterPresenter, favoriteAdvertsPresenter, viewedAdvertsPresenter, serpSpanProvider, spannedGridPositionProvider, appendingRetryListener, publishFloatingViewsProvider);
    }

    @Override // javax.inject.Provider
    public PinAdvertsListViewBinderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
