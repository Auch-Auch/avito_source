package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.interceptor.SessionInterceptor;
import com.avito.android.session_refresh.SessionRefresher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SessionRefresherModule_ProvideSessionInterceptorFactory implements Factory<SessionInterceptor> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<SessionRefresher> b;
    public final Provider<Features> c;

    public SessionRefresherModule_ProvideSessionInterceptorFactory(Provider<AccountStorageInteractor> provider, Provider<SessionRefresher> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SessionRefresherModule_ProvideSessionInterceptorFactory create(Provider<AccountStorageInteractor> provider, Provider<SessionRefresher> provider2, Provider<Features> provider3) {
        return new SessionRefresherModule_ProvideSessionInterceptorFactory(provider, provider2, provider3);
    }

    public static SessionInterceptor provideSessionInterceptor(AccountStorageInteractor accountStorageInteractor, SessionRefresher sessionRefresher, Features features) {
        return (SessionInterceptor) Preconditions.checkNotNullFromProvides(SessionRefresherModule.INSTANCE.provideSessionInterceptor(accountStorageInteractor, sessionRefresher, features));
    }

    @Override // javax.inject.Provider
    public SessionInterceptor get() {
        return provideSessionInterceptor(this.a.get(), this.b.get(), this.c.get());
    }
}
