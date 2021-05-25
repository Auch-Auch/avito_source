package com.avito.android;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CoreActivityIntentFactoryImpl_Factory implements Factory<CoreActivityIntentFactoryImpl> {
    public final Provider<Application> a;

    public CoreActivityIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static CoreActivityIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new CoreActivityIntentFactoryImpl_Factory(provider);
    }

    public static CoreActivityIntentFactoryImpl newInstance(Application application) {
        return new CoreActivityIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public CoreActivityIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
