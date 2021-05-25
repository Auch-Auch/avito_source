package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.AccountStorageInteractorImpl;
import com.avito.android.account.account_manager.AccountManagerStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountStorageInteractorFactory implements Factory<AccountStorageInteractor> {
    public final Provider<AccountStorageInteractorImpl> a;
    public final Provider<AccountManagerStorage> b;
    public final Provider<Features> c;

    public AccountModule_ProvideAccountStorageInteractorFactory(Provider<AccountStorageInteractorImpl> provider, Provider<AccountManagerStorage> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AccountModule_ProvideAccountStorageInteractorFactory create(Provider<AccountStorageInteractorImpl> provider, Provider<AccountManagerStorage> provider2, Provider<Features> provider3) {
        return new AccountModule_ProvideAccountStorageInteractorFactory(provider, provider2, provider3);
    }

    public static AccountStorageInteractor provideAccountStorageInteractor(AccountStorageInteractorImpl accountStorageInteractorImpl, AccountManagerStorage accountManagerStorage, Features features) {
        return (AccountStorageInteractor) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountStorageInteractor(accountStorageInteractorImpl, accountManagerStorage, features));
    }

    @Override // javax.inject.Provider
    public AccountStorageInteractor get() {
        return provideAccountStorageInteractor(this.a.get(), this.b.get(), this.c.get());
    }
}
