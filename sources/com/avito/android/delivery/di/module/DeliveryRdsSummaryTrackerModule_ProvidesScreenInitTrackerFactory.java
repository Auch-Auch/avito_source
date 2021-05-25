package com.avito.android.delivery.di.module;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryRdsSummaryTrackerModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;
    public final Provider<String> c;

    public DeliveryRdsSummaryTrackerModule_ProvidesScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<String> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeliveryRdsSummaryTrackerModule_ProvidesScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<String> provider3) {
        return new DeliveryRdsSummaryTrackerModule_ProvidesScreenInitTrackerFactory(provider, provider2, provider3);
    }

    public static ScreenInitTracker providesScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory, String str) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(DeliveryRdsSummaryTrackerModule.INSTANCE.providesScreenInitTracker(screenTrackerFactory, timerFactory, str));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a.get(), this.b.get(), this.c.get());
    }
}
