package com.avito.android.location;

import dagger.internal.Factory;
public final class LocationInfoProviderImpl_Factory implements Factory<LocationInfoProviderImpl> {

    public static final class a {
        public static final LocationInfoProviderImpl_Factory a = new LocationInfoProviderImpl_Factory();
    }

    public static LocationInfoProviderImpl_Factory create() {
        return a.a;
    }

    public static LocationInfoProviderImpl newInstance() {
        return new LocationInfoProviderImpl();
    }

    @Override // javax.inject.Provider
    public LocationInfoProviderImpl get() {
        return newInstance();
    }
}
