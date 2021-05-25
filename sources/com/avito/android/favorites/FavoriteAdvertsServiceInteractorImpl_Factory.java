package com.avito.android.favorites;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsServiceInteractorImpl_Factory implements Factory<FavoriteAdvertsServiceInteractorImpl> {
    public final Provider<FavoritesApi> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<FavoritesSyncDao> c;
    public final Provider<FavoriteItemsDao> d;
    public final Provider<MutableFavoriteStorage> e;
    public final Provider<TimeSource> f;
    public final Provider<Analytics> g;
    public final Provider<FavoriteAdvertsSyncEventInteractor> h;
    public final Provider<FavoriteAdvertItemConverter> i;

    public FavoriteAdvertsServiceInteractorImpl_Factory(Provider<FavoritesApi> provider, Provider<AccountStateProvider> provider2, Provider<FavoritesSyncDao> provider3, Provider<FavoriteItemsDao> provider4, Provider<MutableFavoriteStorage> provider5, Provider<TimeSource> provider6, Provider<Analytics> provider7, Provider<FavoriteAdvertsSyncEventInteractor> provider8, Provider<FavoriteAdvertItemConverter> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static FavoriteAdvertsServiceInteractorImpl_Factory create(Provider<FavoritesApi> provider, Provider<AccountStateProvider> provider2, Provider<FavoritesSyncDao> provider3, Provider<FavoriteItemsDao> provider4, Provider<MutableFavoriteStorage> provider5, Provider<TimeSource> provider6, Provider<Analytics> provider7, Provider<FavoriteAdvertsSyncEventInteractor> provider8, Provider<FavoriteAdvertItemConverter> provider9) {
        return new FavoriteAdvertsServiceInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static FavoriteAdvertsServiceInteractorImpl newInstance(FavoritesApi favoritesApi, AccountStateProvider accountStateProvider, FavoritesSyncDao favoritesSyncDao, FavoriteItemsDao favoriteItemsDao, MutableFavoriteStorage mutableFavoriteStorage, TimeSource timeSource, Analytics analytics, FavoriteAdvertsSyncEventInteractor favoriteAdvertsSyncEventInteractor, FavoriteAdvertItemConverter favoriteAdvertItemConverter) {
        return new FavoriteAdvertsServiceInteractorImpl(favoritesApi, accountStateProvider, favoritesSyncDao, favoriteItemsDao, mutableFavoriteStorage, timeSource, analytics, favoriteAdvertsSyncEventInteractor, favoriteAdvertItemConverter);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsServiceInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
