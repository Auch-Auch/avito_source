package com.avito.android.di.module;

import com.avito.android.app.task.FavoritesMigrationTask;
import com.avito.android.db.FavoriteDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.FavoriteMigrationStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoritesTasksModule_ProvideFavoritesMigrationTask$favorites_releaseFactory implements Factory<FavoritesMigrationTask> {
    public final Provider<FavoriteDao> a;
    public final Provider<FavoritesSyncDao> b;
    public final Provider<FavoriteMigrationStorage> c;

    public FavoritesTasksModule_ProvideFavoritesMigrationTask$favorites_releaseFactory(Provider<FavoriteDao> provider, Provider<FavoritesSyncDao> provider2, Provider<FavoriteMigrationStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoritesTasksModule_ProvideFavoritesMigrationTask$favorites_releaseFactory create(Provider<FavoriteDao> provider, Provider<FavoritesSyncDao> provider2, Provider<FavoriteMigrationStorage> provider3) {
        return new FavoritesTasksModule_ProvideFavoritesMigrationTask$favorites_releaseFactory(provider, provider2, provider3);
    }

    public static FavoritesMigrationTask provideFavoritesMigrationTask$favorites_release(FavoriteDao favoriteDao, FavoritesSyncDao favoritesSyncDao, FavoriteMigrationStorage favoriteMigrationStorage) {
        return (FavoritesMigrationTask) Preconditions.checkNotNullFromProvides(FavoritesTasksModule.INSTANCE.provideFavoritesMigrationTask$favorites_release(favoriteDao, favoritesSyncDao, favoriteMigrationStorage));
    }

    @Override // javax.inject.Provider
    public FavoritesMigrationTask get() {
        return provideFavoritesMigrationTask$favorites_release(this.a.get(), this.b.get(), this.c.get());
    }
}
