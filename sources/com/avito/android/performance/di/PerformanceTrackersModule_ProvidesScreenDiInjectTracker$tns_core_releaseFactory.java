package com.avito.android.performance.di;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory implements Factory<ScreenDiInjectTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;
    public final Provider<Screen> c;

    public PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<Screen> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<Screen> provider3) {
        return new PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory(provider, provider2, provider3);
    }

    public static ScreenDiInjectTracker providesScreenDiInjectTracker$tns_core_release(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory, Screen screen) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(PerformanceTrackersModule.providesScreenDiInjectTracker$tns_core_release(screenTrackerFactory, timerFactory, screen));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return providesScreenDiInjectTracker$tns_core_release(this.a.get(), this.b.get(), this.c.get());
    }
}
