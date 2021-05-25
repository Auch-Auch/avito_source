package com.avito.android.developments_catalog.tracker;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DevelopmentsCatalogTrackerImpl_Factory implements Factory<DevelopmentsCatalogTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public DevelopmentsCatalogTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DevelopmentsCatalogTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new DevelopmentsCatalogTrackerImpl_Factory(provider, provider2);
    }

    public static DevelopmentsCatalogTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new DevelopmentsCatalogTrackerImpl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public DevelopmentsCatalogTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
