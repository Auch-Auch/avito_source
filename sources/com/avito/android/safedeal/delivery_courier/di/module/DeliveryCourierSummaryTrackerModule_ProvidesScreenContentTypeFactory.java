package com.avito.android.safedeal.delivery_courier.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory a = new DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(DeliveryCourierSummaryTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
