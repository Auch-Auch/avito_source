package com.avito.android.di.module;

import com.avito.android.enabler.FetchRemoteTogglesStartUpTask;
import com.avito.android.enabler.RemoteFeaturesTouchMonitor;
import com.avito.android.enabler.RemoteTogglesFetcher;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticFeaturesModule_ProvideFetchRemoteTogglesStartUpTaskFactory implements Factory<FetchRemoteTogglesStartUpTask> {
    public final Provider<RemoteTogglesFetcher> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<RemoteFeaturesTouchMonitor> c;

    public AnalyticFeaturesModule_ProvideFetchRemoteTogglesStartUpTaskFactory(Provider<RemoteTogglesFetcher> provider, Provider<SchedulersFactory3> provider2, Provider<RemoteFeaturesTouchMonitor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticFeaturesModule_ProvideFetchRemoteTogglesStartUpTaskFactory create(Provider<RemoteTogglesFetcher> provider, Provider<SchedulersFactory3> provider2, Provider<RemoteFeaturesTouchMonitor> provider3) {
        return new AnalyticFeaturesModule_ProvideFetchRemoteTogglesStartUpTaskFactory(provider, provider2, provider3);
    }

    public static FetchRemoteTogglesStartUpTask provideFetchRemoteTogglesStartUpTask(RemoteTogglesFetcher remoteTogglesFetcher, SchedulersFactory3 schedulersFactory3, RemoteFeaturesTouchMonitor remoteFeaturesTouchMonitor) {
        return (FetchRemoteTogglesStartUpTask) Preconditions.checkNotNullFromProvides(AnalyticFeaturesModule.provideFetchRemoteTogglesStartUpTask(remoteTogglesFetcher, schedulersFactory3, remoteFeaturesTouchMonitor));
    }

    @Override // javax.inject.Provider
    public FetchRemoteTogglesStartUpTask get() {
        return provideFetchRemoteTogglesStartUpTask(this.a.get(), this.b.get(), this.c.get());
    }
}
