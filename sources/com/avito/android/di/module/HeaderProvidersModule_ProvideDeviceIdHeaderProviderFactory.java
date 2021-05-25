package com.avito.android.di.module;

import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderProvidersModule_ProvideDeviceIdHeaderProviderFactory implements Factory<DeviceIdHeaderProvider> {
    public final HeaderProvidersModule a;
    public final Provider<DeviceIdProvider> b;

    public HeaderProvidersModule_ProvideDeviceIdHeaderProviderFactory(HeaderProvidersModule headerProvidersModule, Provider<DeviceIdProvider> provider) {
        this.a = headerProvidersModule;
        this.b = provider;
    }

    public static HeaderProvidersModule_ProvideDeviceIdHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule, Provider<DeviceIdProvider> provider) {
        return new HeaderProvidersModule_ProvideDeviceIdHeaderProviderFactory(headerProvidersModule, provider);
    }

    public static DeviceIdHeaderProvider provideDeviceIdHeaderProvider(HeaderProvidersModule headerProvidersModule, DeviceIdProvider deviceIdProvider) {
        return (DeviceIdHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.provideDeviceIdHeaderProvider(deviceIdProvider));
    }

    @Override // javax.inject.Provider
    public DeviceIdHeaderProvider get() {
        return provideDeviceIdHeaderProvider(this.a, this.b.get());
    }
}
