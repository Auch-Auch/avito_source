package com.avito.android.auto_catalog.tracker;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoCatalogTrackerImpl_Factory implements Factory<AutoCatalogTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public AutoCatalogTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutoCatalogTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new AutoCatalogTrackerImpl_Factory(provider, provider2);
    }

    public static AutoCatalogTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new AutoCatalogTrackerImpl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public AutoCatalogTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
