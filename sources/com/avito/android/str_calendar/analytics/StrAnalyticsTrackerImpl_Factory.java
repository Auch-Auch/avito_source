package com.avito.android.str_calendar.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrAnalyticsTrackerImpl_Factory implements Factory<StrAnalyticsTrackerImpl> {
    public final Provider<Analytics> a;

    public StrAnalyticsTrackerImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static StrAnalyticsTrackerImpl_Factory create(Provider<Analytics> provider) {
        return new StrAnalyticsTrackerImpl_Factory(provider);
    }

    public static StrAnalyticsTrackerImpl newInstance(Analytics analytics) {
        return new StrAnalyticsTrackerImpl(analytics);
    }

    @Override // javax.inject.Provider
    public StrAnalyticsTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
