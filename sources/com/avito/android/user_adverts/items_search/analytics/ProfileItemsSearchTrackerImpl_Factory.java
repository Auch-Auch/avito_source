package com.avito.android.user_adverts.items_search.analytics;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileItemsSearchTrackerImpl_Factory implements Factory<ProfileItemsSearchTrackerImpl> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public ProfileItemsSearchTrackerImpl_Factory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileItemsSearchTrackerImpl_Factory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ProfileItemsSearchTrackerImpl_Factory(provider, provider2);
    }

    public static ProfileItemsSearchTrackerImpl newInstance(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return new ProfileItemsSearchTrackerImpl(screenTrackerFactory, timerFactory);
    }

    @Override // javax.inject.Provider
    public ProfileItemsSearchTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
