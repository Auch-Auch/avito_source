package com.avito.android.geo;

import com.avito.android.server_time.TimeSource;
import com.avito.android.version_conflict.ConfigStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GeoPositionModel_Factory implements Factory<GeoPositionModel> {
    public final Provider<TimeSource> a;
    public final Provider<GeoStorage> b;
    public final Provider<ConfigStorage> c;

    public GeoPositionModel_Factory(Provider<TimeSource> provider, Provider<GeoStorage> provider2, Provider<ConfigStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static GeoPositionModel_Factory create(Provider<TimeSource> provider, Provider<GeoStorage> provider2, Provider<ConfigStorage> provider3) {
        return new GeoPositionModel_Factory(provider, provider2, provider3);
    }

    public static GeoPositionModel newInstance(TimeSource timeSource, GeoStorage geoStorage, ConfigStorage configStorage) {
        return new GeoPositionModel(timeSource, geoStorage, configStorage);
    }

    @Override // javax.inject.Provider
    public GeoPositionModel get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
