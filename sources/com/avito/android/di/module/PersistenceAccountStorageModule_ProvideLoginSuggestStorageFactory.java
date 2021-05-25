package com.avito.android.di.module;

import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.db.sqlbrite.Database;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAccountStorageModule_ProvideLoginSuggestStorageFactory implements Factory<LoginSuggestStorage> {
    public final PersistenceAccountStorageModule a;
    public final Provider<Database> b;

    public PersistenceAccountStorageModule_ProvideLoginSuggestStorageFactory(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Database> provider) {
        this.a = persistenceAccountStorageModule;
        this.b = provider;
    }

    public static PersistenceAccountStorageModule_ProvideLoginSuggestStorageFactory create(PersistenceAccountStorageModule persistenceAccountStorageModule, Provider<Database> provider) {
        return new PersistenceAccountStorageModule_ProvideLoginSuggestStorageFactory(persistenceAccountStorageModule, provider);
    }

    public static LoginSuggestStorage provideLoginSuggestStorage(PersistenceAccountStorageModule persistenceAccountStorageModule, Database database) {
        return (LoginSuggestStorage) Preconditions.checkNotNullFromProvides(persistenceAccountStorageModule.provideLoginSuggestStorage(database));
    }

    @Override // javax.inject.Provider
    public LoginSuggestStorage get() {
        return provideLoginSuggestStorage(this.a, this.b.get());
    }
}
