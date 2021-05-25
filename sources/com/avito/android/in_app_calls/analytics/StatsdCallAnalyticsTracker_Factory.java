package com.avito.android.in_app_calls.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StatsdCallAnalyticsTracker_Factory implements Factory<StatsdCallAnalyticsTracker> {
    public final Provider<Analytics> a;

    public StatsdCallAnalyticsTracker_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static StatsdCallAnalyticsTracker_Factory create(Provider<Analytics> provider) {
        return new StatsdCallAnalyticsTracker_Factory(provider);
    }

    public static StatsdCallAnalyticsTracker newInstance(Analytics analytics) {
        return new StatsdCallAnalyticsTracker(analytics);
    }

    @Override // javax.inject.Provider
    public StatsdCallAnalyticsTracker get() {
        return newInstance(this.a.get());
    }
}
