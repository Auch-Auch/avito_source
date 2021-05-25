package com.avito.android.delivery.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryProfileSettingsTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final DeliveryProfileSettingsTrackerModule_ProvidesScreenContentTypeFactory a = new DeliveryProfileSettingsTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static DeliveryProfileSettingsTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(DeliveryProfileSettingsTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
