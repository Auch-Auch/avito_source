package com.avito.android.auto_catalog;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.auto_catalog.tracker.AutoCatalogTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AutoCatalogFragment_MembersInjector implements MembersInjector<AutoCatalogFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<Features> d;
    public final Provider<AutoCatalogPresenter> e;
    public final Provider<FavoriteAdvertsPresenter> f;
    public final Provider<ViewedAdvertsPresenter> g;
    public final Provider<AdapterPresenter> h;
    public final Provider<SafeRecyclerAdapter> i;
    public final Provider<DestroyableViewHolderBuilder> j;
    public final Provider<AutoCatalogResourceProvider> k;
    public final Provider<SpannedGridPositionProvider> l;
    public final Provider<GridLayoutManager.SpanSizeLookup> m;
    public final Provider<SerpSpanProvider> n;
    public final Provider<DeviceMetrics> o;
    public final Provider<AutoCatalogTracker> p;

    public AutoCatalogFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Features> provider4, Provider<AutoCatalogPresenter> provider5, Provider<FavoriteAdvertsPresenter> provider6, Provider<ViewedAdvertsPresenter> provider7, Provider<AdapterPresenter> provider8, Provider<SafeRecyclerAdapter> provider9, Provider<DestroyableViewHolderBuilder> provider10, Provider<AutoCatalogResourceProvider> provider11, Provider<SpannedGridPositionProvider> provider12, Provider<GridLayoutManager.SpanSizeLookup> provider13, Provider<SerpSpanProvider> provider14, Provider<DeviceMetrics> provider15, Provider<AutoCatalogTracker> provider16) {
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
    }

    public static MembersInjector<AutoCatalogFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Features> provider4, Provider<AutoCatalogPresenter> provider5, Provider<FavoriteAdvertsPresenter> provider6, Provider<ViewedAdvertsPresenter> provider7, Provider<AdapterPresenter> provider8, Provider<SafeRecyclerAdapter> provider9, Provider<DestroyableViewHolderBuilder> provider10, Provider<AutoCatalogResourceProvider> provider11, Provider<SpannedGridPositionProvider> provider12, Provider<GridLayoutManager.SpanSizeLookup> provider13, Provider<SerpSpanProvider> provider14, Provider<DeviceMetrics> provider15, Provider<AutoCatalogTracker> provider16) {
        return new AutoCatalogFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(AutoCatalogFragment autoCatalogFragment, ActivityIntentFactory activityIntentFactory) {
        autoCatalogFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.adapterPresenter")
    public static void injectAdapterPresenter(AutoCatalogFragment autoCatalogFragment, AdapterPresenter adapterPresenter) {
        autoCatalogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AutoCatalogFragment autoCatalogFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        autoCatalogFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(AutoCatalogFragment autoCatalogFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        autoCatalogFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.deviceMetrics")
    public static void injectDeviceMetrics(AutoCatalogFragment autoCatalogFragment, DeviceMetrics deviceMetrics) {
        autoCatalogFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(AutoCatalogFragment autoCatalogFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        autoCatalogFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.features")
    public static void injectFeatures(AutoCatalogFragment autoCatalogFragment, Features features) {
        autoCatalogFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.gridPositionProvider")
    public static void injectGridPositionProvider(AutoCatalogFragment autoCatalogFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        autoCatalogFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(AutoCatalogFragment autoCatalogFragment, ImplicitIntentFactory implicitIntentFactory) {
        autoCatalogFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.presenter")
    public static void injectPresenter(AutoCatalogFragment autoCatalogFragment, AutoCatalogPresenter autoCatalogPresenter) {
        autoCatalogFragment.presenter = autoCatalogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(AutoCatalogFragment autoCatalogFragment, SafeRecyclerAdapter safeRecyclerAdapter) {
        autoCatalogFragment.recyclerAdapter = safeRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.resourceProvider")
    public static void injectResourceProvider(AutoCatalogFragment autoCatalogFragment, AutoCatalogResourceProvider autoCatalogResourceProvider) {
        autoCatalogFragment.resourceProvider = autoCatalogResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.spanProvider")
    public static void injectSpanProvider(AutoCatalogFragment autoCatalogFragment, SerpSpanProvider serpSpanProvider) {
        autoCatalogFragment.spanProvider = serpSpanProvider;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(AutoCatalogFragment autoCatalogFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        autoCatalogFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.tracker")
    public static void injectTracker(AutoCatalogFragment autoCatalogFragment, AutoCatalogTracker autoCatalogTracker) {
        autoCatalogFragment.tracker = autoCatalogTracker;
    }

    @InjectedFieldSignature("com.avito.android.auto_catalog.AutoCatalogFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(AutoCatalogFragment autoCatalogFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        autoCatalogFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    public void injectMembers(AutoCatalogFragment autoCatalogFragment) {
        injectDeepLinkIntentFactory(autoCatalogFragment, this.a.get());
        injectImplicitIntentFactory(autoCatalogFragment, this.b.get());
        injectActivityIntentFactory(autoCatalogFragment, this.c.get());
        injectFeatures(autoCatalogFragment, this.d.get());
        injectPresenter(autoCatalogFragment, this.e.get());
        injectFavoriteAdvertsPresenter(autoCatalogFragment, this.f.get());
        injectViewedAdvertsPresenter(autoCatalogFragment, this.g.get());
        injectAdapterPresenter(autoCatalogFragment, this.h.get());
        injectRecyclerAdapter(autoCatalogFragment, this.i.get());
        injectDestroyableViewHolderBuilder(autoCatalogFragment, this.j.get());
        injectResourceProvider(autoCatalogFragment, this.k.get());
        injectGridPositionProvider(autoCatalogFragment, this.l.get());
        injectSpanSizeLookup(autoCatalogFragment, this.m.get());
        injectSpanProvider(autoCatalogFragment, this.n.get());
        injectDeviceMetrics(autoCatalogFragment, this.o.get());
        injectTracker(autoCatalogFragment, this.p.get());
    }
}
