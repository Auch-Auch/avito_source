package com.avito.android.memory_consumption;

import com.avito.android.memory_consumption.MemoryMetricsProvider;
import dagger.internal.Factory;
public final class MemoryMetricsProvider_Impl_Factory implements Factory<MemoryMetricsProvider.Impl> {

    public static final class a {
        public static final MemoryMetricsProvider_Impl_Factory a = new MemoryMetricsProvider_Impl_Factory();
    }

    public static MemoryMetricsProvider_Impl_Factory create() {
        return a.a;
    }

    public static MemoryMetricsProvider.Impl newInstance() {
        return new MemoryMetricsProvider.Impl();
    }

    @Override // javax.inject.Provider
    public MemoryMetricsProvider.Impl get() {
        return newInstance();
    }
}
