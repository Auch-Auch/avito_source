package com.avito.android.favorites;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.favorites.tracker.FavoritesTracker;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class FavoritesListPresenterImpl_Factory implements Factory<FavoritesListPresenterImpl> {
    public final Provider<FavoritesListInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<FavoriteAdvertsInteractor> d;
    public final Provider<FavoriteListResourceProvider> e;
    public final Provider<TreeStateIdGenerator> f;
    public final Provider<FavoritesTracker> g;
    public final Provider<Analytics> h;
    public final Provider<AccountStateProvider> i;
    public final Provider<Observable<FavoriteItemAction>> j;
    public final Provider<ErrorFormatter> k;
    public final Provider<FavoritesListStorage> l;
    public final Provider<Kundle> m;
    public final Provider<Features> n;

    public FavoritesListPresenterImpl_Factory(Provider<FavoritesListInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AdapterPresenter> provider3, Provider<FavoriteAdvertsInteractor> provider4, Provider<FavoriteListResourceProvider> provider5, Provider<TreeStateIdGenerator> provider6, Provider<FavoritesTracker> provider7, Provider<Analytics> provider8, Provider<AccountStateProvider> provider9, Provider<Observable<FavoriteItemAction>> provider10, Provider<ErrorFormatter> provider11, Provider<FavoritesListStorage> provider12, Provider<Kundle> provider13, Provider<Features> provider14) {
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
    }

    public static FavoritesListPresenterImpl_Factory create(Provider<FavoritesListInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AdapterPresenter> provider3, Provider<FavoriteAdvertsInteractor> provider4, Provider<FavoriteListResourceProvider> provider5, Provider<TreeStateIdGenerator> provider6, Provider<FavoritesTracker> provider7, Provider<Analytics> provider8, Provider<AccountStateProvider> provider9, Provider<Observable<FavoriteItemAction>> provider10, Provider<ErrorFormatter> provider11, Provider<FavoritesListStorage> provider12, Provider<Kundle> provider13, Provider<Features> provider14) {
        return new FavoritesListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static FavoritesListPresenterImpl newInstance(FavoritesListInteractor favoritesListInteractor, SchedulersFactory schedulersFactory, AdapterPresenter adapterPresenter, FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteListResourceProvider favoriteListResourceProvider, TreeStateIdGenerator treeStateIdGenerator, FavoritesTracker favoritesTracker, Analytics analytics, AccountStateProvider accountStateProvider, Observable<FavoriteItemAction> observable, ErrorFormatter errorFormatter, FavoritesListStorage favoritesListStorage, Kundle kundle, Features features) {
        return new FavoritesListPresenterImpl(favoritesListInteractor, schedulersFactory, adapterPresenter, favoriteAdvertsInteractor, favoriteListResourceProvider, treeStateIdGenerator, favoritesTracker, analytics, accountStateProvider, observable, errorFormatter, favoritesListStorage, kundle, features);
    }

    @Override // javax.inject.Provider
    public FavoritesListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get());
    }
}
