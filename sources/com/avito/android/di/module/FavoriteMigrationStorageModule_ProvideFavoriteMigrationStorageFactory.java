package com.avito.android.di.module;

import com.avito.android.favorites.FavoriteMigrationStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteMigrationStorageModule_ProvideFavoriteMigrationStorageFactory implements Factory<FavoriteMigrationStorage> {
    public final FavoriteMigrationStorageModule a;
    public final Provider<Preferences> b;

    public FavoriteMigrationStorageModule_ProvideFavoriteMigrationStorageFactory(FavoriteMigrationStorageModule favoriteMigrationStorageModule, Provider<Preferences> provider) {
        this.a = favoriteMigrationStorageModule;
        this.b = provider;
    }

    public static FavoriteMigrationStorageModule_ProvideFavoriteMigrationStorageFactory create(FavoriteMigrationStorageModule favoriteMigrationStorageModule, Provider<Preferences> provider) {
        return new FavoriteMigrationStorageModule_ProvideFavoriteMigrationStorageFactory(favoriteMigrationStorageModule, provider);
    }

    public static FavoriteMigrationStorage provideFavoriteMigrationStorage(FavoriteMigrationStorageModule favoriteMigrationStorageModule, Preferences preferences) {
        return (FavoriteMigrationStorage) Preconditions.checkNotNullFromProvides(favoriteMigrationStorageModule.provideFavoriteMigrationStorage(preferences));
    }

    @Override // javax.inject.Provider
    public FavoriteMigrationStorage get() {
        return provideFavoriteMigrationStorage(this.a, this.b.get());
    }
}
