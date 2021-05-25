package com.avito.android.remote.interceptor;

import com.avito.android.account.AccountStorageInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionCookieProvider_Factory implements Factory<SessionCookieProvider> {
    public final Provider<AccountStorageInteractor> a;

    public SessionCookieProvider_Factory(Provider<AccountStorageInteractor> provider) {
        this.a = provider;
    }

    public static SessionCookieProvider_Factory create(Provider<AccountStorageInteractor> provider) {
        return new SessionCookieProvider_Factory(provider);
    }

    public static SessionCookieProvider newInstance(AccountStorageInteractor accountStorageInteractor) {
        return new SessionCookieProvider(accountStorageInteractor);
    }

    @Override // javax.inject.Provider
    public SessionCookieProvider get() {
        return newInstance(this.a.get());
    }
}
