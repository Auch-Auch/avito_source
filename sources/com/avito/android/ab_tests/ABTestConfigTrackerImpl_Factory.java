package com.avito.android.ab_tests;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ABTestConfigTrackerImpl_Factory implements Factory<ABTestConfigTrackerImpl> {
    public final Provider<Analytics> a;
    public final Provider<GraphitePrefix> b;

    public ABTestConfigTrackerImpl_Factory(Provider<Analytics> provider, Provider<GraphitePrefix> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ABTestConfigTrackerImpl_Factory create(Provider<Analytics> provider, Provider<GraphitePrefix> provider2) {
        return new ABTestConfigTrackerImpl_Factory(provider, provider2);
    }

    public static ABTestConfigTrackerImpl newInstance(Analytics analytics, GraphitePrefix graphitePrefix) {
        return new ABTestConfigTrackerImpl(analytics, graphitePrefix);
    }

    @Override // javax.inject.Provider
    public ABTestConfigTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
