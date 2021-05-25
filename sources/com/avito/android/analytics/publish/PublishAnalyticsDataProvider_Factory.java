package com.avito.android.analytics.publish;

import dagger.internal.Factory;
public final class PublishAnalyticsDataProvider_Factory implements Factory<PublishAnalyticsDataProvider> {

    public static final class a {
        public static final PublishAnalyticsDataProvider_Factory a = new PublishAnalyticsDataProvider_Factory();
    }

    public static PublishAnalyticsDataProvider_Factory create() {
        return a.a;
    }

    public static PublishAnalyticsDataProvider newInstance() {
        return new PublishAnalyticsDataProvider();
    }

    @Override // javax.inject.Provider
    public PublishAnalyticsDataProvider get() {
        return newInstance();
    }
}
