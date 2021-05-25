package com.avito.android.delivery.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryRdsStartOrderingTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final DeliveryRdsStartOrderingTrackerModule_ProvidesScreenContentTypeFactory a = new DeliveryRdsStartOrderingTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static DeliveryRdsStartOrderingTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(DeliveryRdsStartOrderingTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
