package com.avito.android.di.module;

import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAccountStorageModule_GetProfileInfoStorageFactory implements Factory<ProfileInfoStorage> {
    public final PersistenceAccountStorageModule a;
    public final Provider<Preferences> b;

    public PersistenceAccountStorageModule_GetProfileInfoStorageFactory(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Preferences> provider) {
        this.a = persistenceAccountStorageModule;
        this.b = provider;
    }

    public static PersistenceAccountStorageModule_GetProfileInfoStorageFactory create(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Preferences> provider) {
        return new PersistenceAccountStorageModule_GetProfileInfoStorageFactory(persistenceAccountStorageModule, provider);
    }

    public static ProfileInfoStorage getProfileInfoStorage(PersistenceAccountStorageModule persistenceAccountStorageModule, Preferences preferences) {
        return (ProfileInfoStorage) Preconditions.checkNotNullFromProvides(persistenceAccountStorageModule.getProfileInfoStorage(preferences));
    }

    @Override // javax.inject.Provider
    public ProfileInfoStorage get() {
        return getProfileInfoStorage(this.a, this.b.get());
    }
}
