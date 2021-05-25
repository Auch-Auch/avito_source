package com.avito.android.di.module;

import com.avito.android.account.LastLoggedEmailStorage;
import com.avito.android.account.MutableLastLoggedEmailStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAccountStorageModule_ProvideReadOnlyLastLoggedEmailStorageFactory implements Factory<LastLoggedEmailStorage> {
    public final PersistenceAccountStorageModule a;
    public final Provider<MutableLastLoggedEmailStorage> b;

    public PersistenceAccountStorageModule_ProvideReadOnlyLastLoggedEmailStorageFactory(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<MutableLastLoggedEmailStorage> provider) {
        this.a = persistenceAccountStorageModule;
        this.b = provider;
    }

    public static PersistenceAccountStorageModule_ProvideReadOnlyLastLoggedEmailStorageFactory create(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<MutableLastLoggedEmailStorage> provider) {
        return new PersistenceAccountStorageModule_ProvideReadOnlyLastLoggedEmailStorageFactory(persistenceAccountStorageModule, provider);
    }

    public static LastLoggedEmailStorage provideReadOnlyLastLoggedEmailStorage(PersistenceAccountStorageModule persistenceAccountStorageModule, MutableLastLoggedEmailStorage mutableLastLoggedEmailStorage) {
        return (LastLoggedEmailStorage) Preconditions.checkNotNullFromProvides(persistenceAccountStorageModule.provideReadOnlyLastLoggedEmailStorage(mutableLastLoggedEmailStorage));
    }

    @Override // javax.inject.Provider
    public LastLoggedEmailStorage get() {
        return provideReadOnlyLastLoggedEmailStorage(this.a, this.b.get());
    }
}
