package com.avito.android.delivery.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryLocationSuggestModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final DeliveryLocationSuggestModule_ProvidesScreenContentTypeFactory a = new DeliveryLocationSuggestModule_ProvidesScreenContentTypeFactory();
    }

    public static DeliveryLocationSuggestModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(DeliveryLocationSuggestModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
