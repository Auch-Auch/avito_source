package com.avito.android.memory_consumption;

import com.avito.android.memory_consumption.GcUsageCollector;
import dagger.internal.Factory;
public final class GcUsageCollector_Impl_Factory implements Factory<GcUsageCollector.Impl> {

    public static final class a {
        public static final GcUsageCollector_Impl_Factory a = new GcUsageCollector_Impl_Factory();
    }

    public static GcUsageCollector_Impl_Factory create() {
        return a.a;
    }

    public static GcUsageCollector.Impl newInstance() {
        return new GcUsageCollector.Impl();
    }

    @Override // javax.inject.Provider
    public GcUsageCollector.Impl get() {
        return newInstance();
    }
}
