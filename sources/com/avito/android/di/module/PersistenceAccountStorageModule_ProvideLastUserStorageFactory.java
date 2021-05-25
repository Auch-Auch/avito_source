package com.avito.android.di.module;

import com.avito.android.account.LastUserStorage;
import com.avito.android.account.MutableLastUserStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAccountStorageModule_ProvideLastUserStorageFactory implements Factory<LastUserStorage> {
    public final PersistenceAccountStorageModule a;
    public final Provider<MutableLastUserStorage> b;

    public PersistenceAccountStorageModule_ProvideLastUserStorageFactory(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<MutableLastUserStorage> provider) {
        this.a = persistenceAccountStorageModule;
        this.b = provider;
    }

    public static PersistenceAccountStorageModule_ProvideLastUserStorageFactory create(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<MutableLastUserStorage> provider) {
        return new PersistenceAccountStorageModule_ProvideLastUserStorageFactory(persistenceAccountStorageModule, provider);
    }

    public static LastUserStorage provideLastUserStorage(PersistenceAccountStorageModule persistenceAccountStorageModule, MutableLastUserStorage mutableLastUserStorage) {
        return (LastUserStorage) Preconditions.checkNotNullFromProvides(persistenceAccountStorageModule.provideLastUserStorage(mutableLastUserStorage));
    }

    @Override // javax.inject.Provider
    public LastUserStorage get() {
        return provideLastUserStorage(this.a, this.b.get());
    }
}
