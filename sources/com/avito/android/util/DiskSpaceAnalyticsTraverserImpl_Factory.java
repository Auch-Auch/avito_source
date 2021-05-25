package com.avito.android.util;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DiskSpaceAnalyticsTraverserImpl_Factory implements Factory<DiskSpaceAnalyticsTraverserImpl> {
    public final Provider<DataDirectoryProvider> a;
    public final Provider<DataDiskUsageDelegate> b;
    public final Provider<GraphitePrefix> c;
    public final Provider<Analytics> d;

    public DiskSpaceAnalyticsTraverserImpl_Factory(Provider<DataDirectoryProvider> provider, Provider<DataDiskUsageDelegate> provider2, Provider<GraphitePrefix> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DiskSpaceAnalyticsTraverserImpl_Factory create(Provider<DataDirectoryProvider> provider, Provider<DataDiskUsageDelegate> provider2, Provider<GraphitePrefix> provider3, Provider<Analytics> provider4) {
        return new DiskSpaceAnalyticsTraverserImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DiskSpaceAnalyticsTraverserImpl newInstance(DataDirectoryProvider dataDirectoryProvider, DataDiskUsageDelegate dataDiskUsageDelegate, GraphitePrefix graphitePrefix, Analytics analytics) {
        return new DiskSpaceAnalyticsTraverserImpl(dataDirectoryProvider, dataDiskUsageDelegate, graphitePrefix, analytics);
    }

    @Override // javax.inject.Provider
    public DiskSpaceAnalyticsTraverserImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
