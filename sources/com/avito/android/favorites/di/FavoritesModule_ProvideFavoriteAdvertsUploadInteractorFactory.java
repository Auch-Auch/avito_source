package com.avito.android.favorites.di;

import android.content.Context;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoritesModule_ProvideFavoriteAdvertsUploadInteractorFactory implements Factory<FavoriteAdvertsUploadInteractor> {
    public final Provider<Context> a;
    public final Provider<FavoriteAdvertsSyncRunner> b;

    public FavoritesModule_ProvideFavoriteAdvertsUploadInteractorFactory(Provider<Context> provider, Provider<FavoriteAdvertsSyncRunner> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoritesModule_ProvideFavoriteAdvertsUploadInteractorFactory create(Provider<Context> provider, Provider<FavoriteAdvertsSyncRunner> provider2) {
        return new FavoritesModule_ProvideFavoriteAdvertsUploadInteractorFactory(provider, provider2);
    }

    public static FavoriteAdvertsUploadInteractor provideFavoriteAdvertsUploadInteractor(Context context, FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner) {
        return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromProvides(FavoritesModule.provideFavoriteAdvertsUploadInteractor(context, favoriteAdvertsSyncRunner));
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsUploadInteractor get() {
        return provideFavoriteAdvertsUploadInteractor(this.a.get(), this.b.get());
    }
}
