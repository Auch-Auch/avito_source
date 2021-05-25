package com.avito.android.short_term_rent.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NonFatalAnalyticsTrackerImpl_Factory implements Factory<NonFatalAnalyticsTrackerImpl> {
    public final Provider<Analytics> a;

    public NonFatalAnalyticsTrackerImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static NonFatalAnalyticsTrackerImpl_Factory create(Provider<Analytics> provider) {
        return new NonFatalAnalyticsTrackerImpl_Factory(provider);
    }

    public static NonFatalAnalyticsTrackerImpl newInstance(Analytics analytics) {
        return new NonFatalAnalyticsTrackerImpl(analytics);
    }

    @Override // javax.inject.Provider
    public NonFatalAnalyticsTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
