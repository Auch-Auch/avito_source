package com.avito.android.profile.tfa;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TfaIntentFactoryImpl_Factory implements Factory<TfaIntentFactoryImpl> {
    public final Provider<Application> a;

    public TfaIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static TfaIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new TfaIntentFactoryImpl_Factory(provider);
    }

    public static TfaIntentFactoryImpl newInstance(Application application) {
        return new TfaIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public TfaIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
