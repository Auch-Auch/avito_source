package com.avito.android.enabler;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RemoteFeaturesLoadingMonitor_Factory implements Factory<RemoteFeaturesLoadingMonitor> {
    private final Provider<Analytics> analyticsProvider;
    private final Provider<BuildInfo> buildInfoProvider;

    public RemoteFeaturesLoadingMonitor_Factory(Provider<Analytics> provider, Provider<BuildInfo> provider2) {
        this.analyticsProvider = provider;
        this.buildInfoProvider = provider2;
    }

    public static RemoteFeaturesLoadingMonitor_Factory create(Provider<Analytics> provider, Provider<BuildInfo> provider2) {
        return new RemoteFeaturesLoadingMonitor_Factory(provider, provider2);
    }

    public static RemoteFeaturesLoadingMonitor newInstance(Analytics analytics, BuildInfo buildInfo) {
        return new RemoteFeaturesLoadingMonitor(analytics, buildInfo);
    }

    @Override // javax.inject.Provider
    public RemoteFeaturesLoadingMonitor get() {
        return newInstance(this.analyticsProvider.get(), this.buildInfoProvider.get());
    }
}
