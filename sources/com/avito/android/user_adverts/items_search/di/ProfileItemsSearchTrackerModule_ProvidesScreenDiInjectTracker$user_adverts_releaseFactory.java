package com.avito.android.user_adverts.items_search.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ProfileItemsSearchTrackerModule_ProvidesScreenDiInjectTracker$user_adverts_releaseFactory implements Factory<ScreenDiInjectTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public ProfileItemsSearchTrackerModule_ProvidesScreenDiInjectTracker$user_adverts_releaseFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileItemsSearchTrackerModule_ProvidesScreenDiInjectTracker$user_adverts_releaseFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ProfileItemsSearchTrackerModule_ProvidesScreenDiInjectTracker$user_adverts_releaseFactory(provider, provider2);
    }

    public static ScreenDiInjectTracker providesScreenDiInjectTracker$user_adverts_release(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(ProfileItemsSearchTrackerModule.providesScreenDiInjectTracker$user_adverts_release(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return providesScreenDiInjectTracker$user_adverts_release(this.a.get(), this.b.get());
    }
}
