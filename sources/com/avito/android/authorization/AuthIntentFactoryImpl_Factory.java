package com.avito.android.authorization;

import android.app.Application;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AuthIntentFactoryImpl_Factory implements Factory<AuthIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<Features> b;

    public AuthIntentFactoryImpl_Factory(Provider<Application> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AuthIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<Features> provider2) {
        return new AuthIntentFactoryImpl_Factory(provider, provider2);
    }

    public static AuthIntentFactoryImpl newInstance(Application application, Features features) {
        return new AuthIntentFactoryImpl(application, features);
    }

    @Override // javax.inject.Provider
    public AuthIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
