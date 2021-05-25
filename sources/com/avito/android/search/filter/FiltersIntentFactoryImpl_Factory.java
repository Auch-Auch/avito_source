package com.avito.android.search.filter;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FiltersIntentFactoryImpl_Factory implements Factory<FiltersIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<Features> b;
    public final Provider<CoreActivityIntentFactory> c;

    public FiltersIntentFactoryImpl_Factory(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FiltersIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new FiltersIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static FiltersIntentFactoryImpl newInstance(Application application, Features features, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new FiltersIntentFactoryImpl(application, features, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public FiltersIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
