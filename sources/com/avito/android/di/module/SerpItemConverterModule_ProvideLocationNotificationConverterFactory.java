package com.avito.android.di.module;

import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideLocationNotificationConverterFactory implements Factory<LocationNotificationItemConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideLocationNotificationConverterFactory a = new SerpItemConverterModule_ProvideLocationNotificationConverterFactory();
    }

    public static SerpItemConverterModule_ProvideLocationNotificationConverterFactory create() {
        return a.a;
    }

    public static LocationNotificationItemConverter provideLocationNotificationConverter() {
        return (LocationNotificationItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideLocationNotificationConverter());
    }

    @Override // javax.inject.Provider
    public LocationNotificationItemConverter get() {
        return provideLocationNotificationConverter();
    }
}
