package com.avito.android.enabler;

import com.avito.android.RemoteToggles;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RemoteFeaturesStartupMonitor_Factory implements Factory<RemoteFeaturesStartupMonitor> {
    private final Provider<Analytics> analyticsProvider;
    private final Provider<BuildInfo> buildInfoProvider;
    private final Provider<RemoteToggles> remoteTogglesProvider;

    public RemoteFeaturesStartupMonitor_Factory(Provider<RemoteToggles> provider, Provider<Analytics> provider2, Provider<BuildInfo> provider3) {
        this.remoteTogglesProvider = provider;
        this.analyticsProvider = provider2;
        this.buildInfoProvider = provider3;
    }

    public static RemoteFeaturesStartupMonitor_Factory create(Provider<RemoteToggles> provider, Provider<Analytics> provider2, Provider<BuildInfo> provider3) {
        return new RemoteFeaturesStartupMonitor_Factory(provider, provider2, provider3);
    }

    public static RemoteFeaturesStartupMonitor newInstance(RemoteToggles remoteToggles, Analytics analytics, BuildInfo buildInfo) {
        return new RemoteFeaturesStartupMonitor(remoteToggles, analytics, buildInfo);
    }

    @Override // javax.inject.Provider
    public RemoteFeaturesStartupMonitor get() {
        return newInstance(this.remoteTogglesProvider.get(), this.analyticsProvider.get(), this.buildInfoProvider.get());
    }
}
