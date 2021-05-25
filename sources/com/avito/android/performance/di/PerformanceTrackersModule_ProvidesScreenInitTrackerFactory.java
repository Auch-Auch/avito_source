package com.avito.android.performance.di;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PerformanceTrackersModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;
    public final Provider<Screen> c;

    public PerformanceTrackersModule_ProvidesScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<Screen> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PerformanceTrackersModule_ProvidesScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<Screen> provider3) {
        return new PerformanceTrackersModule_ProvidesScreenInitTrackerFactory(provider, provider2, provider3);
    }

    public static ScreenInitTracker providesScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory, Screen screen) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(PerformanceTrackersModule.providesScreenInitTracker(screenTrackerFactory, timerFactory, screen));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a.get(), this.b.get(), this.c.get());
    }
}
