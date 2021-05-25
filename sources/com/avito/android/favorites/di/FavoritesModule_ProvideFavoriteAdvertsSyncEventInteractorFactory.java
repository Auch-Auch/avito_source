package com.avito.android.favorites.di;

import com.avito.android.favorites.FavoriteAdvertsSyncEventInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class FavoritesModule_ProvideFavoriteAdvertsSyncEventInteractorFactory implements Factory<FavoriteAdvertsSyncEventInteractor> {

    public static final class a {
        public static final FavoritesModule_ProvideFavoriteAdvertsSyncEventInteractorFactory a = new FavoritesModule_ProvideFavoriteAdvertsSyncEventInteractorFactory();
    }

    public static FavoritesModule_ProvideFavoriteAdvertsSyncEventInteractorFactory create() {
        return a.a;
    }

    public static FavoriteAdvertsSyncEventInteractor provideFavoriteAdvertsSyncEventInteractor() {
        return (FavoriteAdvertsSyncEventInteractor) Preconditions.checkNotNullFromProvides(FavoritesModule.provideFavoriteAdvertsSyncEventInteractor());
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsSyncEventInteractor get() {
        return provideFavoriteAdvertsSyncEventInteractor();
    }
}
