package com.avito.android.publish.details.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.validation.ValidationLogger;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideValidationLoggerFactory implements Factory<ValidationLogger> {
    public final PublishDetailsModule a;
    public final Provider<Analytics> b;
    public final Provider<PublishAnalyticsDataProvider> c;

    public PublishDetailsModule_ProvideValidationLoggerFactory(PublishDetailsModule publishDetailsModule, Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsModule_ProvideValidationLoggerFactory create(PublishDetailsModule publishDetailsModule, Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        return new PublishDetailsModule_ProvideValidationLoggerFactory(publishDetailsModule, provider, provider2);
    }

    public static ValidationLogger provideValidationLogger(PublishDetailsModule publishDetailsModule, Analytics analytics, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return (ValidationLogger) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideValidationLogger(analytics, publishAnalyticsDataProvider));
    }

    @Override // javax.inject.Provider
    public ValidationLogger get() {
        return provideValidationLogger(this.a, this.b.get(), this.c.get());
    }
}
