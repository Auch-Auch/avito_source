package com.avito.android.di.module;

import com.avito.android.enabler.RemoteFeaturesLoadingMonitor;
import com.avito.android.enabler.RemoteTogglesFetcher;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.remote.FeaturesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticFeaturesModule_ProvideFetchRemoteTogglesInteractorFactory implements Factory<RemoteTogglesFetcher> {
    public final Provider<FeaturesApi> a;
    public final Provider<TogglesStorage> b;
    public final Provider<RemoteFeaturesLoadingMonitor> c;

    public AnalyticFeaturesModule_ProvideFetchRemoteTogglesInteractorFactory(Provider<FeaturesApi> provider, Provider<TogglesStorage> provider2, Provider<RemoteFeaturesLoadingMonitor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticFeaturesModule_ProvideFetchRemoteTogglesInteractorFactory create(Provider<FeaturesApi> provider, Provider<TogglesStorage> provider2, Provider<RemoteFeaturesLoadingMonitor> provider3) {
        return new AnalyticFeaturesModule_ProvideFetchRemoteTogglesInteractorFactory(provider, provider2, provider3);
    }

    public static RemoteTogglesFetcher provideFetchRemoteTogglesInteractor(FeaturesApi featuresApi, TogglesStorage togglesStorage, RemoteFeaturesLoadingMonitor remoteFeaturesLoadingMonitor) {
        return (RemoteTogglesFetcher) Preconditions.checkNotNullFromProvides(AnalyticFeaturesModule.provideFetchRemoteTogglesInteractor(featuresApi, togglesStorage, remoteFeaturesLoadingMonitor));
    }

    @Override // javax.inject.Provider
    public RemoteTogglesFetcher get() {
        return provideFetchRemoteTogglesInteractor(this.a.get(), this.b.get(), this.c.get());
    }
}
