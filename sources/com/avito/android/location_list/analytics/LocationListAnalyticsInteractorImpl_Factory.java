package com.avito.android.location_list.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationListAnalyticsInteractorImpl_Factory implements Factory<LocationListAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public LocationListAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static LocationListAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new LocationListAnalyticsInteractorImpl_Factory(provider);
    }

    public static LocationListAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new LocationListAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public LocationListAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
