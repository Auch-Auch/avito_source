package com.avito.android.analytics.screens.fps;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FpsMetricsTracker_Impl_Factory implements Factory<FpsMetricsTracker.Impl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<RefreshRateProvider> b;
    public final Provider<FpsMetricsCalculator> c;
    public final Provider<TrackerInfoProvider> d;
    public final Provider<Analytics> e;
    public final Provider<Features> f;

    public FpsMetricsTracker_Impl_Factory(Provider<SchedulersFactory> provider, Provider<RefreshRateProvider> provider2, Provider<FpsMetricsCalculator> provider3, Provider<TrackerInfoProvider> provider4, Provider<Analytics> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static FpsMetricsTracker_Impl_Factory create(Provider<SchedulersFactory> provider, Provider<RefreshRateProvider> provider2, Provider<FpsMetricsCalculator> provider3, Provider<TrackerInfoProvider> provider4, Provider<Analytics> provider5, Provider<Features> provider6) {
        return new FpsMetricsTracker_Impl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FpsMetricsTracker.Impl newInstance(SchedulersFactory schedulersFactory, RefreshRateProvider refreshRateProvider, FpsMetricsCalculator fpsMetricsCalculator, TrackerInfoProvider trackerInfoProvider, Analytics analytics, Features features) {
        return new FpsMetricsTracker.Impl(schedulersFactory, refreshRateProvider, fpsMetricsCalculator, trackerInfoProvider, analytics, features);
    }

    @Override // javax.inject.Provider
    public FpsMetricsTracker.Impl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
