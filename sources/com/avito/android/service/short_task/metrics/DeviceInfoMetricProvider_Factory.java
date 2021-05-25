package com.avito.android.service.short_task.metrics;

import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeviceInfoMetricProvider_Factory implements Factory<DeviceInfoMetricProvider> {
    public final Provider<DeviceMetrics> a;

    public DeviceInfoMetricProvider_Factory(Provider<DeviceMetrics> provider) {
        this.a = provider;
    }

    public static DeviceInfoMetricProvider_Factory create(Provider<DeviceMetrics> provider) {
        return new DeviceInfoMetricProvider_Factory(provider);
    }

    public static DeviceInfoMetricProvider newInstance(DeviceMetrics deviceMetrics) {
        return new DeviceInfoMetricProvider(deviceMetrics);
    }

    @Override // javax.inject.Provider
    public DeviceInfoMetricProvider get() {
        return newInstance(this.a.get());
    }
}
