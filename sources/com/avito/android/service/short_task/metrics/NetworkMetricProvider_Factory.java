package com.avito.android.service.short_task.metrics;

import com.avito.android.analytics.NetworkTypeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NetworkMetricProvider_Factory implements Factory<NetworkMetricProvider> {
    public final Provider<NetworkTypeProvider> a;

    public NetworkMetricProvider_Factory(Provider<NetworkTypeProvider> provider) {
        this.a = provider;
    }

    public static NetworkMetricProvider_Factory create(Provider<NetworkTypeProvider> provider) {
        return new NetworkMetricProvider_Factory(provider);
    }

    public static NetworkMetricProvider newInstance(NetworkTypeProvider networkTypeProvider) {
        return new NetworkMetricProvider(networkTypeProvider);
    }

    @Override // javax.inject.Provider
    public NetworkMetricProvider get() {
        return newInstance(this.a.get());
    }
}
