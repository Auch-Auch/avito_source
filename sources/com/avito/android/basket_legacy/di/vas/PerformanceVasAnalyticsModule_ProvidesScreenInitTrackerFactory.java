package com.avito.android.basket_legacy.di.vas;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PerformanceVasAnalyticsModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<Screen> b;
    public final Provider<Boolean> c;
    public final Provider<TimerFactory> d;

    public PerformanceVasAnalyticsModule_ProvidesScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<Screen> provider2, Provider<Boolean> provider3, Provider<TimerFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PerformanceVasAnalyticsModule_ProvidesScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<Screen> provider2, Provider<Boolean> provider3, Provider<TimerFactory> provider4) {
        return new PerformanceVasAnalyticsModule_ProvidesScreenInitTrackerFactory(provider, provider2, provider3, provider4);
    }

    public static ScreenInitTracker providesScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, Screen screen, boolean z, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(PerformanceVasAnalyticsModule.providesScreenInitTracker(screenTrackerFactory, screen, z, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get());
    }
}
