package com.avito.android.service.short_task.clickstream;

import com.avito.android.geo.GeoStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.UserAgentProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoCommonParametersProvider_Factory implements Factory<AvitoCommonParametersProvider> {
    public final Provider<DeviceIdProvider> a;
    public final Provider<UserAgentProvider> b;
    public final Provider<GeoStorage> c;

    public AvitoCommonParametersProvider_Factory(Provider<DeviceIdProvider> provider, Provider<UserAgentProvider> provider2, Provider<GeoStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AvitoCommonParametersProvider_Factory create(Provider<DeviceIdProvider> provider, Provider<UserAgentProvider> provider2, Provider<GeoStorage> provider3) {
        return new AvitoCommonParametersProvider_Factory(provider, provider2, provider3);
    }

    public static AvitoCommonParametersProvider newInstance(DeviceIdProvider deviceIdProvider, UserAgentProvider userAgentProvider, GeoStorage geoStorage) {
        return new AvitoCommonParametersProvider(deviceIdProvider, userAgentProvider, geoStorage);
    }

    @Override // javax.inject.Provider
    public AvitoCommonParametersProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
