package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.SessionsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SessionsApiModule_ProvideSessionsApiFactory implements Factory<SessionsApi> {
    public final SessionsApiModule a;
    public final Provider<RetrofitFactory> b;

    public SessionsApiModule_ProvideSessionsApiFactory(SessionsApiModule sessionsApiModule, Provider<RetrofitFactory> provider) {
        this.a = sessionsApiModule;
        this.b = provider;
    }

    public static SessionsApiModule_ProvideSessionsApiFactory create(SessionsApiModule sessionsApiModule, Provider<RetrofitFactory> provider) {
        return new SessionsApiModule_ProvideSessionsApiFactory(sessionsApiModule, provider);
    }

    public static SessionsApi provideSessionsApi(SessionsApiModule sessionsApiModule, RetrofitFactory retrofitFactory) {
        return (SessionsApi) Preconditions.checkNotNullFromProvides(sessionsApiModule.provideSessionsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SessionsApi get() {
        return provideSessionsApi(this.a, this.b.get());
    }
}
