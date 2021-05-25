package com.avito.android.shop.detailed;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.detailed.tracker.ShopDetailedTracker;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopDetailedPresenterImpl_Factory implements Factory<ShopDetailedPresenterImpl> {
    public final Provider<String> a;
    public final Provider<SearchParams> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<SerpSpanProvider> d;
    public final Provider<SpannedGridPositionProvider> e;
    public final Provider<ShopDetailedInteractor> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<ShopAdvertsResourceProvider> h;
    public final Provider<Formatter<Throwable>> i;
    public final Provider<FavoriteAdvertsPresenter> j;
    public final Provider<ViewedAdvertsPresenter> k;
    public final Provider<ShopDetailedItemsConverter> l;
    public final Provider<Analytics> m;
    public final Provider<ShopItemVisibilityProvider> n;
    public final Provider<TreeStateIdGenerator> o;
    public final Provider<TreeClickStreamParent> p;
    public final Provider<CompositeSnackbarPresenter> q;
    public final Provider<Kundle> r;
    public final Provider<Features> s;
    public final Provider<ShopDetailedTracker> t;
    public final Provider<MutableLiveData<String>> u;

    public ShopDetailedPresenterImpl_Factory(Provider<String> provider, Provider<SearchParams> provider2, Provider<AdapterPresenter> provider3, Provider<SerpSpanProvider> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<ShopDetailedInteractor> provider6, Provider<SchedulersFactory3> provider7, Provider<ShopAdvertsResourceProvider> provider8, Provider<Formatter<Throwable>> provider9, Provider<FavoriteAdvertsPresenter> provider10, Provider<ViewedAdvertsPresenter> provider11, Provider<ShopDetailedItemsConverter> provider12, Provider<Analytics> provider13, Provider<ShopItemVisibilityProvider> provider14, Provider<TreeStateIdGenerator> provider15, Provider<TreeClickStreamParent> provider16, Provider<CompositeSnackbarPresenter> provider17, Provider<Kundle> provider18, Provider<Features> provider19, Provider<ShopDetailedTracker> provider20, Provider<MutableLiveData<String>> provider21) {
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
    }

    public static ShopDetailedPresenterImpl_Factory create(Provider<String> provider, Provider<SearchParams> provider2, Provider<AdapterPresenter> provider3, Provider<SerpSpanProvider> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<ShopDetailedInteractor> provider6, Provider<SchedulersFactory3> provider7, Provider<ShopAdvertsResourceProvider> provider8, Provider<Formatter<Throwable>> provider9, Provider<FavoriteAdvertsPresenter> provider10, Provider<ViewedAdvertsPresenter> provider11, Provider<ShopDetailedItemsConverter> provider12, Provider<Analytics> provider13, Provider<ShopItemVisibilityProvider> provider14, Provider<TreeStateIdGenerator> provider15, Provider<TreeClickStreamParent> provider16, Provider<CompositeSnackbarPresenter> provider17, Provider<Kundle> provider18, Provider<Features> provider19, Provider<ShopDetailedTracker> provider20, Provider<MutableLiveData<String>> provider21) {
        return new ShopDetailedPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21);
    }

    public static ShopDetailedPresenterImpl newInstance(String str, SearchParams searchParams, AdapterPresenter adapterPresenter, SerpSpanProvider serpSpanProvider, SpannedGridPositionProvider spannedGridPositionProvider, ShopDetailedInteractor shopDetailedInteractor, SchedulersFactory3 schedulersFactory3, ShopAdvertsResourceProvider shopAdvertsResourceProvider, Formatter<Throwable> formatter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, ShopDetailedItemsConverter shopDetailedItemsConverter, Analytics analytics, ShopItemVisibilityProvider shopItemVisibilityProvider, TreeStateIdGenerator treeStateIdGenerator, TreeClickStreamParent treeClickStreamParent, CompositeSnackbarPresenter compositeSnackbarPresenter, Kundle kundle, Features features, ShopDetailedTracker shopDetailedTracker, MutableLiveData<String> mutableLiveData) {
        return new ShopDetailedPresenterImpl(str, searchParams, adapterPresenter, serpSpanProvider, spannedGridPositionProvider, shopDetailedInteractor, schedulersFactory3, shopAdvertsResourceProvider, formatter, favoriteAdvertsPresenter, viewedAdvertsPresenter, shopDetailedItemsConverter, analytics, shopItemVisibilityProvider, treeStateIdGenerator, treeClickStreamParent, compositeSnackbarPresenter, kundle, features, shopDetailedTracker, mutableLiveData);
    }

    @Override // javax.inject.Provider
    public ShopDetailedPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get());
    }
}
