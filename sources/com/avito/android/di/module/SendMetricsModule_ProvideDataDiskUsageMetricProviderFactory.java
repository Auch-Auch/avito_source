package com.avito.android.di.module;

import com.avito.android.service.short_task.metrics.DataDiskUsageMetricProvider;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDiskUsageDelegate;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SendMetricsModule_ProvideDataDiskUsageMetricProviderFactory implements Factory<DataDiskUsageMetricProvider> {
    public final Provider<DataDirectoryProvider> a;
    public final Provider<DataDiskUsageDelegate> b;

    public SendMetricsModule_ProvideDataDiskUsageMetricProviderFactory(Provider<DataDirectoryProvider> provider, Provider<DataDiskUsageDelegate> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SendMetricsModule_ProvideDataDiskUsageMetricProviderFactory create(Provider<DataDirectoryProvider> provider, Provider<DataDiskUsageDelegate> provider2) {
        return new SendMetricsModule_ProvideDataDiskUsageMetricProviderFactory(provider, provider2);
    }

    public static DataDiskUsageMetricProvider provideDataDiskUsageMetricProvider(DataDirectoryProvider dataDirectoryProvider, DataDiskUsageDelegate dataDiskUsageDelegate) {
        return (DataDiskUsageMetricProvider) Preconditions.checkNotNullFromProvides(SendMetricsModule.provideDataDiskUsageMetricProvider(dataDirectoryProvider, dataDiskUsageDelegate));
    }

    @Override // javax.inject.Provider
    public DataDiskUsageMetricProvider get() {
        return provideDataDiskUsageMetricProvider(this.a.get(), this.b.get());
    }
}
