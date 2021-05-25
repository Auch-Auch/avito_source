package com.avito.android.di.module;

import com.avito.android.remote.DeviceIdProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreAnalyticsModule_ProvideDeviceIdFactory implements Factory<String> {
    public final CoreAnalyticsModule a;
    public final Provider<DeviceIdProvider> b;

    public CoreAnalyticsModule_ProvideDeviceIdFactory(CoreAnalyticsModule coreAnalyticsModule, Provider<DeviceIdProvider> provider) {
        this.a = coreAnalyticsModule;
        this.b = provider;
    }

    public static CoreAnalyticsModule_ProvideDeviceIdFactory create(CoreAnalyticsModule coreAnalyticsModule, Provider<DeviceIdProvider> provider) {
        return new CoreAnalyticsModule_ProvideDeviceIdFactory(coreAnalyticsModule, provider);
    }

    public static String provideDeviceId(CoreAnalyticsModule coreAnalyticsModule, DeviceIdProvider deviceIdProvider) {
        return (String) Preconditions.checkNotNullFromProvides(coreAnalyticsModule.provideDeviceId(deviceIdProvider));
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideDeviceId(this.a, this.b.get());
    }
}
