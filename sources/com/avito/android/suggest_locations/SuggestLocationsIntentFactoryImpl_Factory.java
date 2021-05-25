package com.avito.android.suggest_locations;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SuggestLocationsIntentFactoryImpl_Factory implements Factory<SuggestLocationsIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<Features> b;
    public final Provider<CoreActivityIntentFactory> c;

    public SuggestLocationsIntentFactoryImpl_Factory(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SuggestLocationsIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new SuggestLocationsIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static SuggestLocationsIntentFactoryImpl newInstance(Application application, Features features, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new SuggestLocationsIntentFactoryImpl(application, features, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public SuggestLocationsIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
