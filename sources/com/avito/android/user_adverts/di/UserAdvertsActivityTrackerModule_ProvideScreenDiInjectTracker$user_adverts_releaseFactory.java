package com.avito.android.user_adverts.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsActivityTrackerModule_ProvideScreenDiInjectTracker$user_adverts_releaseFactory implements Factory<ScreenDiInjectTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public UserAdvertsActivityTrackerModule_ProvideScreenDiInjectTracker$user_adverts_releaseFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserAdvertsActivityTrackerModule_ProvideScreenDiInjectTracker$user_adverts_releaseFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new UserAdvertsActivityTrackerModule_ProvideScreenDiInjectTracker$user_adverts_releaseFactory(provider, provider2);
    }

    public static ScreenDiInjectTracker provideScreenDiInjectTracker$user_adverts_release(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(UserAdvertsActivityTrackerModule.provideScreenDiInjectTracker$user_adverts_release(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return provideScreenDiInjectTracker$user_adverts_release(this.a.get(), this.b.get());
    }
}
