package com.avito.android.vas_performance.di.perfomance;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PerformanceVasAnalyticsModuleNew_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<Screen> b;
    public final Provider<TimerFactory> c;

    public PerformanceVasAnalyticsModuleNew_ProvidesScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<Screen> provider2, Provider<TimerFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PerformanceVasAnalyticsModuleNew_ProvidesScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<Screen> provider2, Provider<TimerFactory> provider3) {
        return new PerformanceVasAnalyticsModuleNew_ProvidesScreenInitTrackerFactory(provider, provider2, provider3);
    }

    public static ScreenInitTracker providesScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, Screen screen, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(PerformanceVasAnalyticsModuleNew.providesScreenInitTracker(screenTrackerFactory, screen, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a.get(), this.b.get(), this.c.get());
    }
}
