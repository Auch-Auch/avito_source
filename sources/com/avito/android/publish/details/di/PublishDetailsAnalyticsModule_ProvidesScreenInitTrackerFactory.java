package com.avito.android.publish.details.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsAnalyticsModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final PublishDetailsAnalyticsModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public PublishDetailsAnalyticsModule_ProvidesScreenInitTrackerFactory(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = publishDetailsAnalyticsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsAnalyticsModule_ProvidesScreenInitTrackerFactory create(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new PublishDetailsAnalyticsModule_ProvidesScreenInitTrackerFactory(publishDetailsAnalyticsModule, provider, provider2);
    }

    public static ScreenInitTracker providesScreenInitTracker(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(publishDetailsAnalyticsModule.providesScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a, this.b.get(), this.c.get());
    }
}
