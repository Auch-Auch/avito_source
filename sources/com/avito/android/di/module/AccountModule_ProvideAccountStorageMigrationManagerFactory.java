package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractorImpl;
import com.avito.android.account.AccountStorageMigrationManager;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountStorageMigrationManagerFactory implements Factory<AccountStorageMigrationManager> {
    public final Provider<Preferences> a;
    public final Provider<AccountStorageInteractorImpl> b;
    public final Provider<AccountManagerStorage> c;
    public final Provider<Features> d;

    public AccountModule_ProvideAccountStorageMigrationManagerFactory(Provider<Preferences> provider, Provider<AccountStorageInteractorImpl> provider2, Provider<AccountManagerStorage> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AccountModule_ProvideAccountStorageMigrationManagerFactory create(Provider<Preferences> provider, Provider<AccountStorageInteractorImpl> provider2, Provider<AccountManagerStorage> provider3, Provider<Features> provider4) {
        return new AccountModule_ProvideAccountStorageMigrationManagerFactory(provider, provider2, provider3, provider4);
    }

    public static AccountStorageMigrationManager provideAccountStorageMigrationManager(Preferences preferences, AccountStorageInteractorImpl accountStorageInteractorImpl, AccountManagerStorage accountManagerStorage, Features features) {
        return (AccountStorageMigrationManager) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountStorageMigrationManager(preferences, accountStorageInteractorImpl, accountManagerStorage, features));
    }

    @Override // javax.inject.Provider
    public AccountStorageMigrationManager get() {
        return provideAccountStorageMigrationManager(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
