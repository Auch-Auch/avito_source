package com.avito.android.profile.sessions.social_logout;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsSocialLogoutInteractorImpl_Factory implements Factory<SessionsSocialLogoutInteractorImpl> {
    public final Provider<SessionsApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<AccountStorageInteractor> d;

    public SessionsSocialLogoutInteractorImpl_Factory(Provider<SessionsApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3, Provider<AccountStorageInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SessionsSocialLogoutInteractorImpl_Factory create(Provider<SessionsApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3, Provider<AccountStorageInteractor> provider4) {
        return new SessionsSocialLogoutInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SessionsSocialLogoutInteractorImpl newInstance(SessionsApi sessionsApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3, AccountStorageInteractor accountStorageInteractor) {
        return new SessionsSocialLogoutInteractorImpl(sessionsApi, typedErrorThrowableConverter, schedulersFactory3, accountStorageInteractor);
    }

    @Override // javax.inject.Provider
    public SessionsSocialLogoutInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
