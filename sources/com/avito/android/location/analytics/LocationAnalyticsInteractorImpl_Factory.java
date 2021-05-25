package com.avito.android.location.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationAnalyticsInteractorImpl_Factory implements Factory<LocationAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;
    public final Provider<TimeSource> b;

    public LocationAnalyticsInteractorImpl_Factory(Provider<Analytics> provider, Provider<TimeSource> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LocationAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider, Provider<TimeSource> provider2) {
        return new LocationAnalyticsInteractorImpl_Factory(provider, provider2);
    }

    public static LocationAnalyticsInteractorImpl newInstance(Analytics analytics, TimeSource timeSource) {
        return new LocationAnalyticsInteractorImpl(analytics, timeSource);
    }

    @Override // javax.inject.Provider
    public LocationAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
