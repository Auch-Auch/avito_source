package com.avito.android.favorite_sellers;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FavoriteSellersFragment_MembersInjector implements MembersInjector<FavoriteSellersFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<ResponsiveAdapterPresenter> d;
    public final Provider<DestroyableViewHolderBuilder> e;
    public final Provider<FavoriteSellersPresenter> f;
    public final Provider<RecommendationItemPresenter> g;
    public final Provider<AdvertListItemPresenter> h;
    public final Provider<Analytics> i;
    public final Provider<ScreenTracker> j;
    public final Provider<Features> k;
    public final Provider<AbTestsConfigProvider> l;
    public final Provider<CompositeSnackbarPresenter> m;

    public FavoriteSellersFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ResponsiveAdapterPresenter> provider4, Provider<DestroyableViewHolderBuilder> provider5, Provider<FavoriteSellersPresenter> provider6, Provider<RecommendationItemPresenter> provider7, Provider<AdvertListItemPresenter> provider8, Provider<Analytics> provider9, Provider<ScreenTracker> provider10, Provider<Features> provider11, Provider<AbTestsConfigProvider> provider12, Provider<CompositeSnackbarPresenter> provider13) {
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
    }

    public static MembersInjector<FavoriteSellersFragment> create(Provider<ActivityIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ResponsiveAdapterPresenter> provider4, Provider<DestroyableViewHolderBuilder> provider5, Provider<FavoriteSellersPresenter> provider6, Provider<RecommendationItemPresenter> provider7, Provider<AdvertListItemPresenter> provider8, Provider<Analytics> provider9, Provider<ScreenTracker> provider10, Provider<Features> provider11, Provider<AbTestsConfigProvider> provider12, Provider<CompositeSnackbarPresenter> provider13) {
        return new FavoriteSellersFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.abTestsConfigProvider")
    public static void injectAbTestsConfigProvider(FavoriteSellersFragment favoriteSellersFragment, AbTestsConfigProvider abTestsConfigProvider) {
        favoriteSellersFragment.abTestsConfigProvider = abTestsConfigProvider;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.adapterPresenter")
    public static void injectAdapterPresenter(FavoriteSellersFragment favoriteSellersFragment, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        favoriteSellersFragment.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.advertListItemPresenter")
    public static void injectAdvertListItemPresenter(FavoriteSellersFragment favoriteSellersFragment, AdvertListItemPresenter advertListItemPresenter) {
        favoriteSellersFragment.advertListItemPresenter = advertListItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.analytics")
    public static void injectAnalytics(FavoriteSellersFragment favoriteSellersFragment, Analytics analytics) {
        favoriteSellersFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(FavoriteSellersFragment favoriteSellersFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        favoriteSellersFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.features")
    public static void injectFeatures(FavoriteSellersFragment favoriteSellersFragment, Features features) {
        favoriteSellersFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(FavoriteSellersFragment favoriteSellersFragment, ImplicitIntentFactory implicitIntentFactory) {
        favoriteSellersFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.intentFactory")
    public static void injectIntentFactory(FavoriteSellersFragment favoriteSellersFragment, ActivityIntentFactory activityIntentFactory) {
        favoriteSellersFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.presenter")
    public static void injectPresenter(FavoriteSellersFragment favoriteSellersFragment, FavoriteSellersPresenter favoriteSellersPresenter) {
        favoriteSellersFragment.presenter = favoriteSellersPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.recommendationPresenter")
    public static void injectRecommendationPresenter(FavoriteSellersFragment favoriteSellersFragment, RecommendationItemPresenter recommendationItemPresenter) {
        favoriteSellersFragment.recommendationPresenter = recommendationItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.screenTracker")
    public static void injectScreenTracker(FavoriteSellersFragment favoriteSellersFragment, ScreenTracker screenTracker) {
        favoriteSellersFragment.screenTracker = screenTracker;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.snackbarPresenter")
    public static void injectSnackbarPresenter(FavoriteSellersFragment favoriteSellersFragment, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        favoriteSellersFragment.snackbarPresenter = compositeSnackbarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.FavoriteSellersFragment.viewHolderBuilder")
    public static void injectViewHolderBuilder(FavoriteSellersFragment favoriteSellersFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        favoriteSellersFragment.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    public void injectMembers(FavoriteSellersFragment favoriteSellersFragment) {
        injectIntentFactory(favoriteSellersFragment, this.a.get());
        injectImplicitIntentFactory(favoriteSellersFragment, this.b.get());
        injectDeepLinkIntentFactory(favoriteSellersFragment, this.c.get());
        injectAdapterPresenter(favoriteSellersFragment, this.d.get());
        injectViewHolderBuilder(favoriteSellersFragment, this.e.get());
        injectPresenter(favoriteSellersFragment, this.f.get());
        injectRecommendationPresenter(favoriteSellersFragment, this.g.get());
        injectAdvertListItemPresenter(favoriteSellersFragment, this.h.get());
        injectAnalytics(favoriteSellersFragment, this.i.get());
        injectScreenTracker(favoriteSellersFragment, this.j.get());
        injectFeatures(favoriteSellersFragment, this.k.get());
        injectAbTestsConfigProvider(favoriteSellersFragment, this.l.get());
        injectSnackbarPresenter(favoriteSellersFragment, this.m.get());
    }
}
