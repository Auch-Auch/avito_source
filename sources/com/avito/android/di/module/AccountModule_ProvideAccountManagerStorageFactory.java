package com.avito.android.di.module;

import android.accounts.AccountManager;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountManagerStorageFactory implements Factory<AccountManagerStorage> {
    public final Provider<AccountManager> a;
    public final Provider<BuildInfo> b;

    public AccountModule_ProvideAccountManagerStorageFactory(Provider<AccountManager> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AccountModule_ProvideAccountManagerStorageFactory create(Provider<AccountManager> provider, Provider<BuildInfo> provider2) {
        return new AccountModule_ProvideAccountManagerStorageFactory(provider, provider2);
    }

    public static AccountManagerStorage provideAccountManagerStorage(AccountManager accountManager, BuildInfo buildInfo) {
        return (AccountManagerStorage) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountManagerStorage(accountManager, buildInfo));
    }

    @Override // javax.inject.Provider
    public AccountManagerStorage get() {
        return provideAccountManagerStorage(this.a.get(), this.b.get());
    }
}
