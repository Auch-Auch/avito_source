package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.image.ImageBucketProvider;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.screens.tracker.SessionResolver;
import com.avito.android.connection_quality.NetworkSpeedProvider;
import com.avito.android.memory_consumption.MemoryMetricsReporter;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ScreenGraphiteAnalyticsModule_ProvidesScreenTrackerFactoryFactory implements Factory<ScreenTrackerFactory> {
    public final ScreenGraphiteAnalyticsModule a;
    public final Provider<Analytics> b;
    public final Provider<TrackerInfoProvider> c;
    public final Provider<NetworkTypeProvider> d;
    public final Provider<NetworkSpeedProvider> e;
    public final Provider<ScreenTimeProvider> f;
    public final Provider<ImageBucketProvider> g;
    public final Provider<SessionResolver> h;
    public final Provider<Features> i;
    public final Provider<MemoryMetricsReporter> j;
    public final Provider<BuildInfo> k;

    public ScreenGraphiteAnalyticsModule_ProvidesScreenTrackerFactoryFactory(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Provider<Analytics> provider, Provider<TrackerInfoProvider> provider2, Provider<NetworkTypeProvider> provider3, Provider<NetworkSpeedProvider> provider4, Provider<ScreenTimeProvider> provider5, Provider<ImageBucketProvider> provider6, Provider<SessionResolver> provider7, Provider<Features> provider8, Provider<MemoryMetricsReporter> provider9, Provider<BuildInfo> provider10) {
        this.a = screenGraphiteAnalyticsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
    }

    public static ScreenGraphiteAnalyticsModule_ProvidesScreenTrackerFactoryFactory create(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Provider<Analytics> provider, Provider<TrackerInfoProvider> provider2, Provider<NetworkTypeProvider> provider3, Provider<NetworkSpeedProvider> provider4, Provider<ScreenTimeProvider> provider5, Provider<ImageBucketProvider> provider6, Provider<SessionResolver> provider7, Provider<Features> provider8, Provider<MemoryMetricsReporter> provider9, Provider<BuildInfo> provider10) {
        return new ScreenGraphiteAnalyticsModule_ProvidesScreenTrackerFactoryFactory(screenGraphiteAnalyticsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static ScreenTrackerFactory providesScreenTrackerFactory(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Analytics analytics, TrackerInfoProvider trackerInfoProvider, NetworkTypeProvider networkTypeProvider, NetworkSpeedProvider networkSpeedProvider, ScreenTimeProvider screenTimeProvider, ImageBucketProvider imageBucketProvider, SessionResolver sessionResolver, Features features, MemoryMetricsReporter memoryMetricsReporter, BuildInfo buildInfo) {
        return (ScreenTrackerFactory) Preconditions.checkNotNullFromProvides(screenGraphiteAnalyticsModule.providesScreenTrackerFactory(analytics, trackerInfoProvider, networkTypeProvider, networkSpeedProvider, screenTimeProvider, imageBucketProvider, sessionResolver, features, memoryMetricsReporter, buildInfo));
    }

    @Override // javax.inject.Provider
    public ScreenTrackerFactory get() {
        return providesScreenTrackerFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
