package com.avito.android.favorites.di;

import com.avito.android.favorites.FavoriteAdvertsSyncEventInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoritesModule_ProvideFavoriteAdvertsSyncEventProviderFactory implements Factory<FavoriteAdvertsSyncEventProvider> {
    public final Provider<FavoriteAdvertsSyncEventInteractor> a;

    public FavoritesModule_ProvideFavoriteAdvertsSyncEventProviderFactory(Provider<FavoriteAdvertsSyncEventInteractor> provider) {
        this.a = provider;
    }

    public static FavoritesModule_ProvideFavoriteAdvertsSyncEventProviderFactory create(Provider<FavoriteAdvertsSyncEventInteractor> provider) {
        return new FavoritesModule_ProvideFavoriteAdvertsSyncEventProviderFactory(provider);
    }

    public static FavoriteAdvertsSyncEventProvider provideFavoriteAdvertsSyncEventProvider(FavoriteAdvertsSyncEventInteractor favoriteAdvertsSyncEventInteractor) {
        return (FavoriteAdvertsSyncEventProvider) Preconditions.checkNotNullFromProvides(FavoritesModule.provideFavoriteAdvertsSyncEventProvider(favoriteAdvertsSyncEventInteractor));
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsSyncEventProvider get() {
        return provideFavoriteAdvertsSyncEventProvider(this.a.get());
    }
}
