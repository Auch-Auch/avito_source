package com.avito.android.advert.tracker;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsTrackerImpl_Factory implements Factory<AdvertDetailsTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;
    public final Provider<TrackerInfoProvider> c;
    public final Provider<Analytics> d;

    public AdvertDetailsTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<TrackerInfoProvider> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertDetailsTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2, Provider<TrackerInfoProvider> provider3, Provider<Analytics> provider4) {
        return new AdvertDetailsTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AdvertDetailsTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory, TrackerInfoProvider trackerInfoProvider, Analytics analytics) {
        return new AdvertDetailsTrackerImpl(screenTrackerFactory, timerFactory, trackerInfoProvider, analytics);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
