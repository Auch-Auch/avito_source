package com.avito.android.publish.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final PublishModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public PublishModule_ProvidesScreenInitTrackerFactory(PublishModule publishModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = publishModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishModule_ProvidesScreenInitTrackerFactory create(PublishModule publishModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new PublishModule_ProvidesScreenInitTrackerFactory(publishModule, provider, provider2);
    }

    public static ScreenInitTracker providesScreenInitTracker(PublishModule publishModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(publishModule.providesScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a, this.b.get(), this.c.get());
    }
}
