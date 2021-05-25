package com.avito.android.remote.interceptor;

import com.avito.android.account.AccountStorageInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionHeaderProvider_Factory implements Factory<SessionHeaderProvider> {
    public final Provider<AccountStorageInteractor> a;

    public SessionHeaderProvider_Factory(Provider<AccountStorageInteractor> provider) {
        this.a = provider;
    }

    public static SessionHeaderProvider_Factory create(Provider<AccountStorageInteractor> provider) {
        return new SessionHeaderProvider_Factory(provider);
    }

    public static SessionHeaderProvider newInstance(AccountStorageInteractor accountStorageInteractor) {
        return new SessionHeaderProvider(accountStorageInteractor);
    }

    @Override // javax.inject.Provider
    public SessionHeaderProvider get() {
        return newInstance(this.a.get());
    }
}
