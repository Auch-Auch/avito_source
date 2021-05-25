package com.avito.android.stories;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StoriesIntentFactoryImpl_Factory implements Factory<StoriesIntentFactoryImpl> {
    public final Provider<Application> a;

    public StoriesIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static StoriesIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new StoriesIntentFactoryImpl_Factory(provider);
    }

    public static StoriesIntentFactoryImpl newInstance(Application application) {
        return new StoriesIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public StoriesIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
