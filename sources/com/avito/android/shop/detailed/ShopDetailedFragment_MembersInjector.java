package com.avito.android.shop.detailed;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenter;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenter;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenter;
import com.avito.android.shop.detailed.tracker.ShopDetailedTracker;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ShopDetailedFragment_MembersInjector implements MembersInjector<ShopDetailedFragment> {
    public final Provider<Analytics> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<ShopDetailedPresenter> c;
    public final Provider<ShopDetailedInteractor> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<ImplicitIntentFactory> f;
    public final Provider<DestroyableViewHolderBuilder> g;
    public final Provider<GridLayoutManager.SpanSizeLookup> h;
    public final Provider<SpannedGridPositionProvider> i;
    public final Provider<ShopGoldItemPresenter> j;
    public final Provider<ShopRegularItemPresenter> k;
    public final Provider<FavoriteAdvertsPresenter> l;
    public final Provider<ViewedAdvertsPresenter> m;
    public final Provider<ShowcaseItemPresenter> n;
    public final Provider<SubscriptionsPresenter> o;
    public final Provider<CompositeSnackbarPresenter> p;
    public final Provider<DeepLinkIntentFactory> q;
    public final Provider<Features> r;
    public final Provider<CartFabViewModel> s;
    public final Provider<CartQuantityChangesHandler> t;
    public final Provider<FavoriteAdvertsPresenter> u;
    public final Provider<ResponsiveAdapterPresenter> v;
    public final Provider<ShopDetailedTracker> w;

    public ShopDetailedFragment_MembersInjector(Provider<Analytics> provider, Provider<SchedulersFactory3> provider2, Provider<ShopDetailedPresenter> provider3, Provider<ShopDetailedInteractor> provider4, Provider<ActivityIntentFactory> provider5, Provider<ImplicitIntentFactory> provider6, Provider<DestroyableViewHolderBuilder> provider7, Provider<GridLayoutManager.SpanSizeLookup> provider8, Provider<SpannedGridPositionProvider> provider9, Provider<ShopGoldItemPresenter> provider10, Provider<ShopRegularItemPresenter> provider11, Provider<FavoriteAdvertsPresenter> provider12, Provider<ViewedAdvertsPresenter> provider13, Provider<ShowcaseItemPresenter> provider14, Provider<SubscriptionsPresenter> provider15, Provider<CompositeSnackbarPresenter> provider16, Provider<DeepLinkIntentFactory> provider17, Provider<Features> provider18, Provider<CartFabViewModel> provider19, Provider<CartQuantityChangesHandler> provider20, Provider<FavoriteAdvertsPresenter> provider21, Provider<ResponsiveAdapterPresenter> provider22, Provider<ShopDetailedTracker> provider23) {
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
    }

    public static MembersInjector<ShopDetailedFragment> create(Provider<Analytics> provider, Provider<SchedulersFactory3> provider2, Provider<ShopDetailedPresenter> provider3, Provider<ShopDetailedInteractor> provider4, Provider<ActivityIntentFactory> provider5, Provider<ImplicitIntentFactory> provider6, Provider<DestroyableViewHolderBuilder> provider7, Provider<GridLayoutManager.SpanSizeLookup> provider8, Provider<SpannedGridPositionProvider> provider9, Provider<ShopGoldItemPresenter> provider10, Provider<ShopRegularItemPresenter> provider11, Provider<FavoriteAdvertsPresenter> provider12, Provider<ViewedAdvertsPresenter> provider13, Provider<ShowcaseItemPresenter> provider14, Provider<SubscriptionsPresenter> provider15, Provider<CompositeSnackbarPresenter> provider16, Provider<DeepLinkIntentFactory> provider17, Provider<Features> provider18, Provider<CartFabViewModel> provider19, Provider<CartQuantityChangesHandler> provider20, Provider<FavoriteAdvertsPresenter> provider21, Provider<ResponsiveAdapterPresenter> provider22, Provider<ShopDetailedTracker> provider23) {
        return new ShopDetailedFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23);
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ShopDetailedFragment shopDetailedFragment, ActivityIntentFactory activityIntentFactory) {
        shopDetailedFragment.activityIntentFactory = activityIntentFactory;
    }

    @ShopDetailedModule.ItemResponsiveAdapter
    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.adapterPresenter")
    public static void injectAdapterPresenter(ShopDetailedFragment shopDetailedFragment, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        shopDetailedFragment.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.analytics")
    public static void injectAnalytics(ShopDetailedFragment shopDetailedFragment, Analytics analytics) {
        shopDetailedFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.cartFabViewModel")
    public static void injectCartFabViewModel(ShopDetailedFragment shopDetailedFragment, CartFabViewModel cartFabViewModel) {
        shopDetailedFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.cartQuantityHandler")
    public static void injectCartQuantityHandler(ShopDetailedFragment shopDetailedFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        shopDetailedFragment.cartQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ShopDetailedFragment shopDetailedFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        shopDetailedFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(ShopDetailedFragment shopDetailedFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        shopDetailedFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(ShopDetailedFragment shopDetailedFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        shopDetailedFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @ShopDetailedModule.ShowcaseFavoritePresenter
    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.favoriteShowcasePresenter")
    public static void injectFavoriteShowcasePresenter(ShopDetailedFragment shopDetailedFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        shopDetailedFragment.favoriteShowcasePresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.features")
    public static void injectFeatures(ShopDetailedFragment shopDetailedFragment, Features features) {
        shopDetailedFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.gridPositionProvider")
    public static void injectGridPositionProvider(ShopDetailedFragment shopDetailedFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        shopDetailedFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ShopDetailedFragment shopDetailedFragment, ImplicitIntentFactory implicitIntentFactory) {
        shopDetailedFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.interactor")
    public static void injectInteractor(ShopDetailedFragment shopDetailedFragment, ShopDetailedInteractor shopDetailedInteractor) {
        shopDetailedFragment.interactor = shopDetailedInteractor;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.presenter")
    public static void injectPresenter(ShopDetailedFragment shopDetailedFragment, ShopDetailedPresenter shopDetailedPresenter) {
        shopDetailedFragment.presenter = shopDetailedPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.schedulers")
    public static void injectSchedulers(ShopDetailedFragment shopDetailedFragment, SchedulersFactory3 schedulersFactory3) {
        shopDetailedFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.shopGoldItemPresenter")
    public static void injectShopGoldItemPresenter(ShopDetailedFragment shopDetailedFragment, ShopGoldItemPresenter shopGoldItemPresenter) {
        shopDetailedFragment.shopGoldItemPresenter = shopGoldItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.shopRegularItemPresenter")
    public static void injectShopRegularItemPresenter(ShopDetailedFragment shopDetailedFragment, ShopRegularItemPresenter shopRegularItemPresenter) {
        shopDetailedFragment.shopRegularItemPresenter = shopRegularItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.showcaseItemPresenter")
    public static void injectShowcaseItemPresenter(ShopDetailedFragment shopDetailedFragment, ShowcaseItemPresenter showcaseItemPresenter) {
        shopDetailedFragment.showcaseItemPresenter = showcaseItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.snackbarPresenter")
    public static void injectSnackbarPresenter(ShopDetailedFragment shopDetailedFragment, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        shopDetailedFragment.snackbarPresenter = compositeSnackbarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(ShopDetailedFragment shopDetailedFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        shopDetailedFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.subscriptionsPresenter")
    public static void injectSubscriptionsPresenter(ShopDetailedFragment shopDetailedFragment, SubscriptionsPresenter subscriptionsPresenter) {
        shopDetailedFragment.subscriptionsPresenter = subscriptionsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.tracker")
    public static void injectTracker(ShopDetailedFragment shopDetailedFragment, ShopDetailedTracker shopDetailedTracker) {
        shopDetailedFragment.tracker = shopDetailedTracker;
    }

    @InjectedFieldSignature("com.avito.android.shop.detailed.ShopDetailedFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(ShopDetailedFragment shopDetailedFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        shopDetailedFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    public void injectMembers(ShopDetailedFragment shopDetailedFragment) {
        injectAnalytics(shopDetailedFragment, this.a.get());
        injectSchedulers(shopDetailedFragment, this.b.get());
        injectPresenter(shopDetailedFragment, this.c.get());
        injectInteractor(shopDetailedFragment, this.d.get());
        injectActivityIntentFactory(shopDetailedFragment, this.e.get());
        injectImplicitIntentFactory(shopDetailedFragment, this.f.get());
        injectDestroyableViewHolderBuilder(shopDetailedFragment, this.g.get());
        injectSpanSizeLookup(shopDetailedFragment, this.h.get());
        injectGridPositionProvider(shopDetailedFragment, this.i.get());
        injectShopGoldItemPresenter(shopDetailedFragment, this.j.get());
        injectShopRegularItemPresenter(shopDetailedFragment, this.k.get());
        injectFavoriteAdvertsPresenter(shopDetailedFragment, this.l.get());
        injectViewedAdvertsPresenter(shopDetailedFragment, this.m.get());
        injectShowcaseItemPresenter(shopDetailedFragment, this.n.get());
        injectSubscriptionsPresenter(shopDetailedFragment, this.o.get());
        injectSnackbarPresenter(shopDetailedFragment, this.p.get());
        injectDeepLinkIntentFactory(shopDetailedFragment, this.q.get());
        injectFeatures(shopDetailedFragment, this.r.get());
        injectCartFabViewModel(shopDetailedFragment, this.s.get());
        injectCartQuantityHandler(shopDetailedFragment, this.t.get());
        injectFavoriteShowcasePresenter(shopDetailedFragment, this.u.get());
        injectAdapterPresenter(shopDetailedFragment, this.v.get());
        injectTracker(shopDetailedFragment, this.w.get());
    }
}
