package com.avito.android.di.module;

import com.avito.android.account.MutableLastUserStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAccountStorageModule_ProvideMutableLastUserStorageFactory implements Factory<MutableLastUserStorage> {
    public final PersistenceAccountStorageModule a;
    public final Provider<Preferences> b;

    public PersistenceAccountStorageModule_ProvideMutableLastUserStorageFactory(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Preferences> provider) {
        this.a = persistenceAccountStorageModule;
        this.b = provider;
    }

    public static PersistenceAccountStorageModule_ProvideMutableLastUserStorageFactory create(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Preferences> provider) {
        return new PersistenceAccountStorageModule_ProvideMutableLastUserStorageFactory(persistenceAccountStorageModule, provider);
    }

    public static MutableLastUserStorage provideMutableLastUserStorage(PersistenceAccountStorageModule persistenceAccountStorageModule, Preferences preferences) {
        return (MutableLastUserStorage) Preconditions.checkNotNullFromProvides(persistenceAccountStorageModule.provideMutableLastUserStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MutableLastUserStorage get() {
        return provideMutableLastUserStorage(this.a, this.b.get());
    }
}
