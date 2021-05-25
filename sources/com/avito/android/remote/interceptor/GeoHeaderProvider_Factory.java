package com.avito.android.remote.interceptor;

import com.avito.android.geo.GeoStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GeoHeaderProvider_Factory implements Factory<GeoHeaderProvider> {
    public final Provider<GeoStorage> a;

    public GeoHeaderProvider_Factory(Provider<GeoStorage> provider) {
        this.a = provider;
    }

    public static GeoHeaderProvider_Factory create(Provider<GeoStorage> provider) {
        return new GeoHeaderProvider_Factory(provider);
    }

    public static GeoHeaderProvider newInstance(GeoStorage geoStorage) {
        return new GeoHeaderProvider(geoStorage);
    }

    @Override // javax.inject.Provider
    public GeoHeaderProvider get() {
        return newInstance(this.a.get());
    }
}
