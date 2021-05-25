package com.avito.android.analytics.task;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StartupAnalyticsTrackerImpl_Factory implements Factory<StartupAnalyticsTrackerImpl> {
    public final Provider<GraphitePrefix> a;
    public final Provider<Analytics> b;

    public StartupAnalyticsTrackerImpl_Factory(Provider<GraphitePrefix> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static StartupAnalyticsTrackerImpl_Factory create(Provider<GraphitePrefix> provider, Provider<Analytics> provider2) {
        return new StartupAnalyticsTrackerImpl_Factory(provider, provider2);
    }

    public static StartupAnalyticsTrackerImpl newInstance(GraphitePrefix graphitePrefix, Analytics analytics) {
        return new StartupAnalyticsTrackerImpl(graphitePrefix, analytics);
    }

    @Override // javax.inject.Provider
    public StartupAnalyticsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
