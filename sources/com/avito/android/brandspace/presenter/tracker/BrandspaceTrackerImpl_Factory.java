package com.avito.android.brandspace.presenter.tracker;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceTrackerImpl_Factory implements Factory<BrandspaceTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public BrandspaceTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BrandspaceTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new BrandspaceTrackerImpl_Factory(provider, provider2);
    }

    public static BrandspaceTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new BrandspaceTrackerImpl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public BrandspaceTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
