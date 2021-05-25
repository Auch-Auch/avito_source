package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDiskUsageDelegate;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SendDataSizeModule_ProvideDataDiskUsageDelegateFactory implements Factory<DataDiskUsageDelegate> {
    public final Provider<DataDirectoryProvider> a;
    public final Provider<Context> b;

    public SendDataSizeModule_ProvideDataDiskUsageDelegateFactory(Provider<DataDirectoryProvider> provider, Provider<Context> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SendDataSizeModule_ProvideDataDiskUsageDelegateFactory create(Provider<DataDirectoryProvider> provider, Provider<Context> provider2) {
        return new SendDataSizeModule_ProvideDataDiskUsageDelegateFactory(provider, provider2);
    }

    public static DataDiskUsageDelegate provideDataDiskUsageDelegate(DataDirectoryProvider dataDirectoryProvider, Context context) {
        return (DataDiskUsageDelegate) Preconditions.checkNotNullFromProvides(SendDataSizeModule.provideDataDiskUsageDelegate(dataDirectoryProvider, context));
    }

    @Override // javax.inject.Provider
    public DataDiskUsageDelegate get() {
        return provideDataDiskUsageDelegate(this.a.get(), this.b.get());
    }
}
