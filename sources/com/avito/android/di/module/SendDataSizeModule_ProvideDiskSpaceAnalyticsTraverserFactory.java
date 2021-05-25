package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDiskUsageDelegate;
import com.avito.android.util.DiskSpaceAnalyticsTraverser;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SendDataSizeModule_ProvideDiskSpaceAnalyticsTraverserFactory implements Factory<DiskSpaceAnalyticsTraverser> {
    public final Provider<DataDirectoryProvider> a;
    public final Provider<DataDiskUsageDelegate> b;
    public final Provider<GraphitePrefix> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;

    public SendDataSizeModule_ProvideDiskSpaceAnalyticsTraverserFactory(Provider<DataDirectoryProvider> provider, Provider<DataDiskUsageDelegate> provider2, Provider<GraphitePrefix> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SendDataSizeModule_ProvideDiskSpaceAnalyticsTraverserFactory create(Provider<DataDirectoryProvider> provider, Provider<DataDiskUsageDelegate> provider2, Provider<GraphitePrefix> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        return new SendDataSizeModule_ProvideDiskSpaceAnalyticsTraverserFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static DiskSpaceAnalyticsTraverser provideDiskSpaceAnalyticsTraverser(DataDirectoryProvider dataDirectoryProvider, DataDiskUsageDelegate dataDiskUsageDelegate, GraphitePrefix graphitePrefix, Analytics analytics, Features features) {
        return (DiskSpaceAnalyticsTraverser) Preconditions.checkNotNullFromProvides(SendDataSizeModule.provideDiskSpaceAnalyticsTraverser(dataDirectoryProvider, dataDiskUsageDelegate, graphitePrefix, analytics, features));
    }

    @Override // javax.inject.Provider
    public DiskSpaceAnalyticsTraverser get() {
        return provideDiskSpaceAnalyticsTraverser(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
