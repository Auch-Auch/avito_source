package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.features.AvitoAnalyticFeatures;
import com.avito.android.enabler.RemoteFeaturesCrashlyticsMonitor;
import com.avito.android.enabler.RemoteFeaturesTouchMonitor;
import com.avito.android.util.AvitoBuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticFeaturesModule_ProvideRemoteFeaturesTouchMonitorFactory implements Factory<RemoteFeaturesTouchMonitor> {
    public final Provider<AvitoAnalyticFeatures> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<RemoteFeaturesCrashlyticsMonitor> c;
    public final Provider<Analytics> d;
    public final Provider<AvitoBuildInfo> e;

    public AnalyticFeaturesModule_ProvideRemoteFeaturesTouchMonitorFactory(Provider<AvitoAnalyticFeatures> provider, Provider<SchedulersFactory> provider2, Provider<RemoteFeaturesCrashlyticsMonitor> provider3, Provider<Analytics> provider4, Provider<AvitoBuildInfo> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AnalyticFeaturesModule_ProvideRemoteFeaturesTouchMonitorFactory create(Provider<AvitoAnalyticFeatures> provider, Provider<SchedulersFactory> provider2, Provider<RemoteFeaturesCrashlyticsMonitor> provider3, Provider<Analytics> provider4, Provider<AvitoBuildInfo> provider5) {
        return new AnalyticFeaturesModule_ProvideRemoteFeaturesTouchMonitorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static RemoteFeaturesTouchMonitor provideRemoteFeaturesTouchMonitor(AvitoAnalyticFeatures avitoAnalyticFeatures, SchedulersFactory schedulersFactory, RemoteFeaturesCrashlyticsMonitor remoteFeaturesCrashlyticsMonitor, Analytics analytics, AvitoBuildInfo avitoBuildInfo) {
        return (RemoteFeaturesTouchMonitor) Preconditions.checkNotNullFromProvides(AnalyticFeaturesModule.provideRemoteFeaturesTouchMonitor(avitoAnalyticFeatures, schedulersFactory, remoteFeaturesCrashlyticsMonitor, analytics, avitoBuildInfo));
    }

    @Override // javax.inject.Provider
    public RemoteFeaturesTouchMonitor get() {
        return provideRemoteFeaturesTouchMonitor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
