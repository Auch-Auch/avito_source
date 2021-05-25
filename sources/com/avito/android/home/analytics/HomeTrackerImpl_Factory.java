package com.avito.android.home.analytics;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HomeTrackerImpl_Factory implements Factory<HomeTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public HomeTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static HomeTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new HomeTrackerImpl_Factory(provider, provider2);
    }

    public static HomeTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new HomeTrackerImpl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public HomeTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
