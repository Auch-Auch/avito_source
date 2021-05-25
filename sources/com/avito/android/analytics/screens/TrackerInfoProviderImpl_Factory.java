package com.avito.android.analytics.screens;

import com.avito.android.analytics.grafana.GraphitePrefix;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TrackerInfoProviderImpl_Factory implements Factory<TrackerInfoProviderImpl> {
    public final Provider<GraphitePrefix> a;

    public TrackerInfoProviderImpl_Factory(Provider<GraphitePrefix> provider) {
        this.a = provider;
    }

    public static TrackerInfoProviderImpl_Factory create(Provider<GraphitePrefix> provider) {
        return new TrackerInfoProviderImpl_Factory(provider);
    }

    public static TrackerInfoProviderImpl newInstance(GraphitePrefix graphitePrefix) {
        return new TrackerInfoProviderImpl(graphitePrefix);
    }

    @Override // javax.inject.Provider
    public TrackerInfoProviderImpl get() {
        return newInstance(this.a.get());
    }
}
