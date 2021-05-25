package com.avito.android.di.module;

import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideUserAdvertsInfoStorageFactory implements Factory<UserAdvertsInfoStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;

    public PersistenceCoreModule_ProvideUserAdvertsInfoStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideUserAdvertsInfoStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        return new PersistenceCoreModule_ProvideUserAdvertsInfoStorageFactory(persistenceCoreModule, provider);
    }

    public static UserAdvertsInfoStorage provideUserAdvertsInfoStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences) {
        return (UserAdvertsInfoStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideUserAdvertsInfoStorage(preferences));
    }

    @Override // javax.inject.Provider
    public UserAdvertsInfoStorage get() {
        return provideUserAdvertsInfoStorage(this.a, this.b.get());
    }
}
