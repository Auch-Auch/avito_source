package com.avito.android.di.module;

import com.avito.android.account.MutableLastLoggedEmailStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAccountStorageModule_ProvideLastLoggedEmailStorageFactory implements Factory<MutableLastLoggedEmailStorage> {
    public final PersistenceAccountStorageModule a;
    public final Provider<Preferences> b;

    public PersistenceAccountStorageModule_ProvideLastLoggedEmailStorageFactory(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Preferences> provider) {
        this.a = persistenceAccountStorageModule;
        this.b = provider;
    }

    public static PersistenceAccountStorageModule_ProvideLastLoggedEmailStorageFactory create(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Preferences> provider) {
        return new PersistenceAccountStorageModule_ProvideLastLoggedEmailStorageFactory(persistenceAccountStorageModule, provider);
    }

    public static MutableLastLoggedEmailStorage provideLastLoggedEmailStorage(PersistenceAccountStorageModule persistenceAccountStorageModule, Preferences preferences) {
        return (MutableLastLoggedEmailStorage) Preconditions.checkNotNullFromProvides(persistenceAccountStorageModule.provideLastLoggedEmailStorage(preferences));
    }

    @Override // javax.inject.Provider
    public MutableLastLoggedEmailStorage get() {
        return provideLastLoggedEmailStorage(this.a, this.b.get());
    }
}
