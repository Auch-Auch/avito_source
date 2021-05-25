package com.avito.android.publish_limits_info.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishLimitsAnalyticsModule_ProvideAnalyticsFactory implements Factory<PublishLimitsEventTracker> {
    public final Provider<Analytics> a;

    public PublishLimitsAnalyticsModule_ProvideAnalyticsFactory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static PublishLimitsAnalyticsModule_ProvideAnalyticsFactory create(Provider<Analytics> provider) {
        return new PublishLimitsAnalyticsModule_ProvideAnalyticsFactory(provider);
    }

    public static PublishLimitsEventTracker provideAnalytics(Analytics analytics) {
        return (PublishLimitsEventTracker) Preconditions.checkNotNullFromProvides(PublishLimitsAnalyticsModule.INSTANCE.provideAnalytics(analytics));
    }

    @Override // javax.inject.Provider
    public PublishLimitsEventTracker get() {
        return provideAnalytics(this.a.get());
    }
}
