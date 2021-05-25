package com.avito.android.analytics;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishValidationLogger_Factory implements Factory<PublishValidationLogger> {
    public final Provider<Analytics> a;
    public final Provider<PublishAnalyticsDataProvider> b;

    public PublishValidationLogger_Factory(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PublishValidationLogger_Factory create(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        return new PublishValidationLogger_Factory(provider, provider2);
    }

    public static PublishValidationLogger newInstance(Analytics analytics, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return new PublishValidationLogger(analytics, publishAnalyticsDataProvider);
    }

    @Override // javax.inject.Provider
    public PublishValidationLogger get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
