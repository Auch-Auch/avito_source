package com.avito.android.memory_consumption;

import com.avito.android.memory_consumption.MemoryMetricsReporter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MemoryMetricsReporter_Impl_Factory implements Factory<MemoryMetricsReporter.Impl> {
    public final Provider<MemoryMetricsProvider> a;
    public final Provider<GcUsageCollector> b;

    public MemoryMetricsReporter_Impl_Factory(Provider<MemoryMetricsProvider> provider, Provider<GcUsageCollector> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MemoryMetricsReporter_Impl_Factory create(Provider<MemoryMetricsProvider> provider, Provider<GcUsageCollector> provider2) {
        return new MemoryMetricsReporter_Impl_Factory(provider, provider2);
    }

    public static MemoryMetricsReporter.Impl newInstance(MemoryMetricsProvider memoryMetricsProvider, GcUsageCollector gcUsageCollector) {
        return new MemoryMetricsReporter.Impl(memoryMetricsProvider, gcUsageCollector);
    }

    @Override // javax.inject.Provider
    public MemoryMetricsReporter.Impl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
