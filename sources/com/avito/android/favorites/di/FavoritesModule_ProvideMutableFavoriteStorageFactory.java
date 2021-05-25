package com.avito.android.favorites.di;

import com.avito.android.favorites.MutableFavoriteStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoritesModule_ProvideMutableFavoriteStorageFactory implements Factory<MutableFavoriteStorage> {
    public final Provider<Preferences> a;

    public FavoritesModule_ProvideMutableFavoriteStorageFactory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static FavoritesModule_ProvideMutableFavoriteStorageFactory create(Provider<Preferences> provider) {
        return new FavoritesModule_ProvideMutableFavoriteStorageFactory(provider);
    }

    public static MutableFavoriteStorage provideMutableFavoriteStorage(Preferences preferences) {
        return (MutableFavoriteStorage) Preconditions.checkNotNullFromProvides(FavoritesModule.provideMutableFavoriteStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MutableFavoriteStorage get() {
        return provideMutableFavoriteStorage(this.a.get());
    }
}
