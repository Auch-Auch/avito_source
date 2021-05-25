package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import proto.events.apps.EventOuterClass;
public final class ClickStreamCommonModule_ProvideDiskStorageConverterFactory implements Factory<DiskStorageConverter<EventOuterClass.Event>> {

    public static final class a {
        public static final ClickStreamCommonModule_ProvideDiskStorageConverterFactory a = new ClickStreamCommonModule_ProvideDiskStorageConverterFactory();
    }

    public static ClickStreamCommonModule_ProvideDiskStorageConverterFactory create() {
        return a.a;
    }

    public static DiskStorageConverter<EventOuterClass.Event> provideDiskStorageConverter() {
        return (DiskStorageConverter) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideDiskStorageConverter());
    }

    @Override // javax.inject.Provider
    public DiskStorageConverter<EventOuterClass.Event> get() {
        return provideDiskStorageConverter();
    }
}
