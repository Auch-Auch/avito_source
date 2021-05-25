package com.avito.android.analytics.provider;

import com.avito.android.account.AccountStorageInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CurrentUserIdProviderImpl_Factory implements Factory<CurrentUserIdProviderImpl> {
    public final Provider<AccountStorageInteractor> a;

    public CurrentUserIdProviderImpl_Factory(Provider<AccountStorageInteractor> provider) {
        this.a = provider;
    }

    public static CurrentUserIdProviderImpl_Factory create(Provider<AccountStorageInteractor> provider) {
        return new CurrentUserIdProviderImpl_Factory(provider);
    }

    public static CurrentUserIdProviderImpl newInstance(AccountStorageInteractor accountStorageInteractor) {
        return new CurrentUserIdProviderImpl(accountStorageInteractor);
    }

    @Override // javax.inject.Provider
    public CurrentUserIdProviderImpl get() {
        return newInstance(this.a.get());
    }
}
