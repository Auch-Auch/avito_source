package com.avito.android.profile.sessions.list;

import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsListInteractorImpl_Factory implements Factory<SessionsListInteractorImpl> {
    public final Provider<SessionsApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory3> c;

    public SessionsListInteractorImpl_Factory(Provider<SessionsApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SessionsListInteractorImpl_Factory create(Provider<SessionsApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        return new SessionsListInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SessionsListInteractorImpl newInstance(SessionsApi sessionsApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new SessionsListInteractorImpl(sessionsApi, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public SessionsListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
