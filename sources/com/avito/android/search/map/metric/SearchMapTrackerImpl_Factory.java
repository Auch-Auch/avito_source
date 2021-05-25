package com.avito.android.search.map.metric;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchMapTrackerImpl_Factory implements Factory<SearchMapTrackerImpl> {
    public final Provider<TimerFactory> a;
    public final Provider<ScreenTrackerFactory> b;

    public SearchMapTrackerImpl_Factory(Provider<TimerFactory> provider, Provider<ScreenTrackerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SearchMapTrackerImpl_Factory create(Provider<TimerFactory> provider, Provider<ScreenTrackerFactory> provider2) {
        return new SearchMapTrackerImpl_Factory(provider, provider2);
    }

    public static SearchMapTrackerImpl newInstance(TimerFactory timerFactory, ScreenTrackerFactory screenTrackerFactory) {
        return new SearchMapTrackerImpl(timerFactory, screenTrackerFactory);
    }

    @Override // javax.inject.Provider
    public SearchMapTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
