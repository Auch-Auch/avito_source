package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StatsdCommonModule_ProvideDiskStorageConverterFactory implements Factory<DiskStorageConverter<StatsdRecord>> {

    public static final class a {
        public static final StatsdCommonModule_ProvideDiskStorageConverterFactory a = new StatsdCommonModule_ProvideDiskStorageConverterFactory();
    }

    public static StatsdCommonModule_ProvideDiskStorageConverterFactory create() {
        return a.a;
    }

    public static DiskStorageConverter<StatsdRecord> provideDiskStorageConverter() {
        return (DiskStorageConverter) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideDiskStorageConverter());
    }

    @Override // javax.inject.Provider
    public DiskStorageConverter<StatsdRecord> get() {
        return provideDiskStorageConverter();
    }
}
