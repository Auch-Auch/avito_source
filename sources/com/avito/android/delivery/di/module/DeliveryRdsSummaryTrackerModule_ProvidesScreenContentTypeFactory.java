package com.avito.android.delivery.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryRdsSummaryTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final DeliveryRdsSummaryTrackerModule_ProvidesScreenContentTypeFactory a = new DeliveryRdsSummaryTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static DeliveryRdsSummaryTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(DeliveryRdsSummaryTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
