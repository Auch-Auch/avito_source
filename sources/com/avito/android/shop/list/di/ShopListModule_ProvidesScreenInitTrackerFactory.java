package com.avito.android.shop.list.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopListModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public ShopListModule_ProvidesScreenInitTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopListModule_ProvidesScreenInitTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ShopListModule_ProvidesScreenInitTrackerFactory(provider, provider2);
    }

    public static ScreenInitTracker providesScreenInitTracker(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(ShopListModule.providesScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a.get(), this.b.get());
    }
}
