package com.avito.android.di.module;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountStatusProviderFactory implements Factory<AccountStateProvider> {
    public final Provider<AccountStorageInteractor> a;

    public AccountModule_ProvideAccountStatusProviderFactory(Provider<AccountStorageInteractor> provider) {
        this.a = provider;
    }

    public static AccountModule_ProvideAccountStatusProviderFactory create(Provider<AccountStorageInteractor> provider) {
        return new AccountModule_ProvideAccountStatusProviderFactory(provider);
    }

    public static AccountStateProvider provideAccountStatusProvider(AccountStorageInteractor accountStorageInteractor) {
        return (AccountStateProvider) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountStatusProvider(accountStorageInteractor));
    }

    @Override // javax.inject.Provider
    public AccountStateProvider get() {
        return provideAccountStatusProvider(this.a.get());
    }
}
