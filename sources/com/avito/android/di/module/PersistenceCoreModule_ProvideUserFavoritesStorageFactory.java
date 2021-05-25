package com.avito.android.di.module;

import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideUserFavoritesStorageFactory implements Factory<UserFavoritesStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;

    public PersistenceCoreModule_ProvideUserFavoritesStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideUserFavoritesStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        return new PersistenceCoreModule_ProvideUserFavoritesStorageFactory(persistenceCoreModule, provider);
    }

    public static UserFavoritesStorage provideUserFavoritesStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences) {
        return (UserFavoritesStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideUserFavoritesStorage(preferences));
    }

    @Override // javax.inject.Provider
    public UserFavoritesStorage get() {
        return provideUserFavoritesStorage(this.a, this.b.get());
    }
}
