package com.avito.android.grouping_adverts.tracker;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupingAdvertsTrackerImpl_Factory implements Factory<GroupingAdvertsTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public GroupingAdvertsTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GroupingAdvertsTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new GroupingAdvertsTrackerImpl_Factory(provider, provider2);
    }

    public static GroupingAdvertsTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new GroupingAdvertsTrackerImpl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public GroupingAdvertsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
