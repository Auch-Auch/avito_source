package com.avito.android.favorites;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsListInteractorImpl_Factory implements Factory<FavoriteAdvertsListInteractorImpl> {
    public final Provider<FavoriteAdvertsSyncEventProvider> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<FavoritesApi> c;
    public final Provider<FavoriteItemsDao> d;
    public final Provider<FavoritesSyncDao> e;
    public final Provider<FavoriteAdvertsEventInteractor> f;
    public final Provider<TypedErrorThrowableConverter> g;
    public final Provider<FavoriteStorage> h;
    public final Provider<SchedulersFactory> i;
    public final Provider<FavoriteAdvertItemConverter> j;
    public final Provider<CounterInteractor> k;
    public final Provider<Features> l;

    public FavoriteAdvertsListInteractorImpl_Factory(Provider<FavoriteAdvertsSyncEventProvider> provider, Provider<AccountStateProvider> provider2, Provider<FavoritesApi> provider3, Provider<FavoriteItemsDao> provider4, Provider<FavoritesSyncDao> provider5, Provider<FavoriteAdvertsEventInteractor> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<FavoriteStorage> provider8, Provider<SchedulersFactory> provider9, Provider<FavoriteAdvertItemConverter> provider10, Provider<CounterInteractor> provider11, Provider<Features> provider12) {
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
    }

    public static FavoriteAdvertsListInteractorImpl_Factory create(Provider<FavoriteAdvertsSyncEventProvider> provider, Provider<AccountStateProvider> provider2, Provider<FavoritesApi> provider3, Provider<FavoriteItemsDao> provider4, Provider<FavoritesSyncDao> provider5, Provider<FavoriteAdvertsEventInteractor> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<FavoriteStorage> provider8, Provider<SchedulersFactory> provider9, Provider<FavoriteAdvertItemConverter> provider10, Provider<CounterInteractor> provider11, Provider<Features> provider12) {
        return new FavoriteAdvertsListInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static FavoriteAdvertsListInteractorImpl newInstance(FavoriteAdvertsSyncEventProvider favoriteAdvertsSyncEventProvider, AccountStateProvider accountStateProvider, FavoritesApi favoritesApi, FavoriteItemsDao favoriteItemsDao, FavoritesSyncDao favoritesSyncDao, FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor, TypedErrorThrowableConverter typedErrorThrowableConverter, FavoriteStorage favoriteStorage, SchedulersFactory schedulersFactory, FavoriteAdvertItemConverter favoriteAdvertItemConverter, CounterInteractor counterInteractor, Features features) {
        return new FavoriteAdvertsListInteractorImpl(favoriteAdvertsSyncEventProvider, accountStateProvider, favoritesApi, favoriteItemsDao, favoritesSyncDao, favoriteAdvertsEventInteractor, typedErrorThrowableConverter, favoriteStorage, schedulersFactory, favoriteAdvertItemConverter, counterInteractor, features);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
