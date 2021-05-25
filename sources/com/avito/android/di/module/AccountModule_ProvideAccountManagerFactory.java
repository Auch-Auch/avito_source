package com.avito.android.di.module;

import android.accounts.AccountManager;
import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountManagerFactory implements Factory<AccountManager> {
    public final Provider<Application> a;

    public AccountModule_ProvideAccountManagerFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static AccountModule_ProvideAccountManagerFactory create(Provider<Application> provider) {
        return new AccountModule_ProvideAccountManagerFactory(provider);
    }

    public static AccountManager provideAccountManager(Application application) {
        return (AccountManager) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountManager(application));
    }

    @Override // javax.inject.Provider
    public AccountManager get() {
        return provideAccountManager(this.a.get());
    }
}
