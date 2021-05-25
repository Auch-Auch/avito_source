package com.avito.android.user_stats.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsTrackerModule_ProvideScreenDiInjectTrackerFactory implements Factory<ScreenDiInjectTracker> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public UserStatsTrackerModule_ProvideScreenDiInjectTrackerFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTrackerModule_ProvideScreenDiInjectTrackerFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new UserStatsTrackerModule_ProvideScreenDiInjectTrackerFactory(provider, provider2);
    }

    public static ScreenDiInjectTracker provideScreenDiInjectTracker(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(UserStatsTrackerModule.INSTANCE.provideScreenDiInjectTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return provideScreenDiInjectTracker(this.a.get(), this.b.get());
    }
}
