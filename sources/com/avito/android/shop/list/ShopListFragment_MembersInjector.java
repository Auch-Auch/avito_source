package com.avito.android.shop.list;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.list.analytic.ShopListTracker;
import com.avito.android.shop.list.business.ShopListInteractor;
import com.avito.android.shop.list.presentation.ShopListDataChangeListener;
import com.avito.android.shop.list.presentation.ShopListPresenter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ShopListFragment_MembersInjector implements MembersInjector<ShopListFragment> {
    public final Provider<ShopListPresenter> a;
    public final Provider<ShopListInteractor> b;
    public final Provider<PersistableFloatingViewsPresenter> c;
    public final Provider<ImplicitIntentFactory> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<ShopListTracker> g;
    public final Provider<ShopListDataChangeListener> h;
    public final Provider<DeepLinkIntentFactory> i;
    public final Provider<DestroyableViewHolderBuilder> j;
    public final Provider<AdapterPresenter> k;
    public final Provider<Analytics> l;
    public final Provider<BuildInfo> m;
    public final Provider<SpannedGridPositionProvider> n;
    public final Provider<GridLayoutManager.SpanSizeLookup> o;
    public final Provider<SerpSpanProvider> p;
    public final Provider<Features> q;

    public ShopListFragment_MembersInjector(Provider<ShopListPresenter> provider, Provider<ShopListInteractor> provider2, Provider<PersistableFloatingViewsPresenter> provider3, Provider<ImplicitIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<SchedulersFactory3> provider6, Provider<ShopListTracker> provider7, Provider<ShopListDataChangeListener> provider8, Provider<DeepLinkIntentFactory> provider9, Provider<DestroyableViewHolderBuilder> provider10, Provider<AdapterPresenter> provider11, Provider<Analytics> provider12, Provider<BuildInfo> provider13, Provider<SpannedGridPositionProvider> provider14, Provider<GridLayoutManager.SpanSizeLookup> provider15, Provider<SerpSpanProvider> provider16, Provider<Features> provider17) {
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
    }

    public static MembersInjector<ShopListFragment> create(Provider<ShopListPresenter> provider, Provider<ShopListInteractor> provider2, Provider<PersistableFloatingViewsPresenter> provider3, Provider<ImplicitIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<SchedulersFactory3> provider6, Provider<ShopListTracker> provider7, Provider<ShopListDataChangeListener> provider8, Provider<DeepLinkIntentFactory> provider9, Provider<DestroyableViewHolderBuilder> provider10, Provider<AdapterPresenter> provider11, Provider<Analytics> provider12, Provider<BuildInfo> provider13, Provider<SpannedGridPositionProvider> provider14, Provider<GridLayoutManager.SpanSizeLookup> provider15, Provider<SerpSpanProvider> provider16, Provider<Features> provider17) {
        return new ShopListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ShopListFragment shopListFragment, ActivityIntentFactory activityIntentFactory) {
        shopListFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.adapterPresenter")
    public static void injectAdapterPresenter(ShopListFragment shopListFragment, AdapterPresenter adapterPresenter) {
        shopListFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.analytics")
    public static void injectAnalytics(ShopListFragment shopListFragment, Analytics analytics) {
        shopListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.buildInfo")
    public static void injectBuildInfo(ShopListFragment shopListFragment, BuildInfo buildInfo) {
        shopListFragment.buildInfo = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ShopListFragment shopListFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        shopListFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.features")
    public static void injectFeatures(ShopListFragment shopListFragment, Features features) {
        shopListFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.floatingViewsPresenter")
    public static void injectFloatingViewsPresenter(ShopListFragment shopListFragment, PersistableFloatingViewsPresenter persistableFloatingViewsPresenter) {
        shopListFragment.floatingViewsPresenter = persistableFloatingViewsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.gridPositionProvider")
    public static void injectGridPositionProvider(ShopListFragment shopListFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        shopListFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ShopListFragment shopListFragment, ImplicitIntentFactory implicitIntentFactory) {
        shopListFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.interactor")
    public static void injectInteractor(ShopListFragment shopListFragment, ShopListInteractor shopListInteractor) {
        shopListFragment.interactor = shopListInteractor;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.presenter")
    public static void injectPresenter(ShopListFragment shopListFragment, ShopListPresenter shopListPresenter) {
        shopListFragment.presenter = shopListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.schedulers")
    public static void injectSchedulers(ShopListFragment shopListFragment, SchedulersFactory3 schedulersFactory3) {
        shopListFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.shopListDataChangeListener")
    public static void injectShopListDataChangeListener(ShopListFragment shopListFragment, ShopListDataChangeListener shopListDataChangeListener) {
        shopListFragment.shopListDataChangeListener = shopListDataChangeListener;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.shopListTracker")
    public static void injectShopListTracker(ShopListFragment shopListFragment, ShopListTracker shopListTracker) {
        shopListFragment.shopListTracker = shopListTracker;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.spanProvider")
    public static void injectSpanProvider(ShopListFragment shopListFragment, SerpSpanProvider serpSpanProvider) {
        shopListFragment.spanProvider = serpSpanProvider;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(ShopListFragment shopListFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        shopListFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.shop.list.ShopListFragment.viewHolderBuilder")
    public static void injectViewHolderBuilder(ShopListFragment shopListFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        shopListFragment.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    public void injectMembers(ShopListFragment shopListFragment) {
        injectPresenter(shopListFragment, this.a.get());
        injectInteractor(shopListFragment, this.b.get());
        injectFloatingViewsPresenter(shopListFragment, this.c.get());
        injectImplicitIntentFactory(shopListFragment, this.d.get());
        injectActivityIntentFactory(shopListFragment, this.e.get());
        injectSchedulers(shopListFragment, this.f.get());
        injectShopListTracker(shopListFragment, this.g.get());
        injectShopListDataChangeListener(shopListFragment, this.h.get());
        injectDeepLinkIntentFactory(shopListFragment, this.i.get());
        injectViewHolderBuilder(shopListFragment, this.j.get());
        injectAdapterPresenter(shopListFragment, this.k.get());
        injectAnalytics(shopListFragment, this.l.get());
        injectBuildInfo(shopListFragment, this.m.get());
        injectGridPositionProvider(shopListFragment, this.n.get());
        injectSpanSizeLookup(shopListFragment, this.o.get());
        injectSpanProvider(shopListFragment, this.p.get());
        injectFeatures(shopListFragment, this.q.get());
    }
}
