package com.avito.android.serp;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpIntentFactoryImpl_Factory implements Factory<SerpIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<CoreActivityIntentFactory> b;

    public SerpIntentFactoryImpl_Factory(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2) {
        return new SerpIntentFactoryImpl_Factory(provider, provider2);
    }

    public static SerpIntentFactoryImpl newInstance(Application application, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new SerpIntentFactoryImpl(application, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public SerpIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
