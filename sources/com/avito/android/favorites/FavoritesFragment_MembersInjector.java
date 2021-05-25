package com.avito.android.favorites;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorites.tracker.FavoritesTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FavoritesFragment_MembersInjector implements MembersInjector<FavoritesFragment> {
    public final Provider<FavoritesListPresenter> a;
    public final Provider<FavoritesListInteractor> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<Analytics> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<FavoriteAdvertsSyncRunner> g;
    public final Provider<DeepLinkIntentFactory> h;
    public final Provider<AbTestsConfigProvider> i;
    public final Provider<Features> j;
    public final Provider<FavoritesTracker> k;

    public FavoritesFragment_MembersInjector(Provider<FavoritesListPresenter> provider, Provider<FavoritesListInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<Analytics> provider5, Provider<ActivityIntentFactory> provider6, Provider<FavoriteAdvertsSyncRunner> provider7, Provider<DeepLinkIntentFactory> provider8, Provider<AbTestsConfigProvider> provider9, Provider<Features> provider10, Provider<FavoritesTracker> provider11) {
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
    }

    public static MembersInjector<FavoritesFragment> create(Provider<FavoritesListPresenter> provider, Provider<FavoritesListInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<Analytics> provider5, Provider<ActivityIntentFactory> provider6, Provider<FavoriteAdvertsSyncRunner> provider7, Provider<DeepLinkIntentFactory> provider8, Provider<AbTestsConfigProvider> provider9, Provider<Features> provider10, Provider<FavoritesTracker> provider11) {
        return new FavoritesFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.abTestsConfigProvider")
    public static void injectAbTestsConfigProvider(FavoritesFragment favoritesFragment, AbTestsConfigProvider abTestsConfigProvider) {
        favoritesFragment.abTestsConfigProvider = abTestsConfigProvider;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(FavoritesFragment favoritesFragment, ActivityIntentFactory activityIntentFactory) {
        favoritesFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.adapterPresenter")
    public static void injectAdapterPresenter(FavoritesFragment favoritesFragment, AdapterPresenter adapterPresenter) {
        favoritesFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.analytics")
    public static void injectAnalytics(FavoritesFragment favoritesFragment, Analytics analytics) {
        favoritesFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(FavoritesFragment favoritesFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        favoritesFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.favoriteAdvertsSyncRunner")
    public static void injectFavoriteAdvertsSyncRunner(FavoritesFragment favoritesFragment, FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner) {
        favoritesFragment.favoriteAdvertsSyncRunner = favoriteAdvertsSyncRunner;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.features")
    public static void injectFeatures(FavoritesFragment favoritesFragment, Features features) {
        favoritesFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.interactor")
    public static void injectInteractor(FavoritesFragment favoritesFragment, FavoritesListInteractor favoritesListInteractor) {
        favoritesFragment.interactor = favoritesListInteractor;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.itemBinder")
    public static void injectItemBinder(FavoritesFragment favoritesFragment, ItemBinder itemBinder) {
        favoritesFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.presenter")
    public static void injectPresenter(FavoritesFragment favoritesFragment, FavoritesListPresenter favoritesListPresenter) {
        favoritesFragment.presenter = favoritesListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.favorites.FavoritesFragment.tracker")
    public static void injectTracker(FavoritesFragment favoritesFragment, FavoritesTracker favoritesTracker) {
        favoritesFragment.tracker = favoritesTracker;
    }

    public void injectMembers(FavoritesFragment favoritesFragment) {
        injectPresenter(favoritesFragment, this.a.get());
        injectInteractor(favoritesFragment, this.b.get());
        injectAdapterPresenter(favoritesFragment, this.c.get());
        injectItemBinder(favoritesFragment, this.d.get());
        injectAnalytics(favoritesFragment, this.e.get());
        injectActivityIntentFactory(favoritesFragment, this.f.get());
        injectFavoriteAdvertsSyncRunner(favoritesFragment, this.g.get());
        injectDeepLinkIntentFactory(favoritesFragment, this.h.get());
        injectAbTestsConfigProvider(favoritesFragment, this.i.get());
        injectFeatures(favoritesFragment, this.j.get());
        injectTracker(favoritesFragment, this.k.get());
    }
}
