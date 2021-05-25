package com.avito.android.profile.sessions;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsIntentFactoryImpl_Factory implements Factory<SessionsIntentFactoryImpl> {
    public final Provider<Application> a;

    public SessionsIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static SessionsIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new SessionsIntentFactoryImpl_Factory(provider);
    }

    public static SessionsIntentFactoryImpl newInstance(Application application) {
        return new SessionsIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public SessionsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
