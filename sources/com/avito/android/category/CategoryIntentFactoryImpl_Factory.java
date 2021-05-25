package com.avito.android.category;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryIntentFactoryImpl_Factory implements Factory<CategoryIntentFactoryImpl> {
    public final Provider<Application> a;

    public CategoryIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static CategoryIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new CategoryIntentFactoryImpl_Factory(provider);
    }

    public static CategoryIntentFactoryImpl newInstance(Application application) {
        return new CategoryIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public CategoryIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
