package com.avito.android.safedeal.delivery_courier.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryCourierOrderUpdateTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final DeliveryCourierOrderUpdateTrackerModule_ProvidesScreenContentTypeFactory a = new DeliveryCourierOrderUpdateTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static DeliveryCourierOrderUpdateTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(DeliveryCourierOrderUpdateTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
