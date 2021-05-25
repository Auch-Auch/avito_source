package com.avito.android.publish.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishAnalyticModule_ProvideAnalyticsSerializerFactory implements Factory<Gson> {

    public static final class a {
        public static final PublishAnalyticModule_ProvideAnalyticsSerializerFactory a = new PublishAnalyticModule_ProvideAnalyticsSerializerFactory();
    }

    public static PublishAnalyticModule_ProvideAnalyticsSerializerFactory create() {
        return a.a;
    }

    public static Gson provideAnalyticsSerializer() {
        return (Gson) Preconditions.checkNotNullFromProvides(PublishAnalyticModule.provideAnalyticsSerializer());
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideAnalyticsSerializer();
    }
}
