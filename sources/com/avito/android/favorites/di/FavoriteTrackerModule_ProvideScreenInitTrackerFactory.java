package com.avito.android.favorites.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteTrackerModule_ProvideScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public FavoriteTrackerModule_ProvideScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteTrackerModule_ProvideScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new FavoriteTrackerModule_ProvideScreenInitTrackerFactory(provider, provider2);
    }

    public static ScreenInitTracker provideScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(FavoriteTrackerModule.provideScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return provideScreenInitTracker(this.a.get(), this.b.get());
    }
}
