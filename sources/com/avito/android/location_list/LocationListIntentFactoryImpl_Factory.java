package com.avito.android.location_list;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationListIntentFactoryImpl_Factory implements Factory<LocationListIntentFactoryImpl> {
    public final Provider<Application> a;

    public LocationListIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static LocationListIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new LocationListIntentFactoryImpl_Factory(provider);
    }

    public static LocationListIntentFactoryImpl newInstance(Application application) {
        return new LocationListIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public LocationListIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
