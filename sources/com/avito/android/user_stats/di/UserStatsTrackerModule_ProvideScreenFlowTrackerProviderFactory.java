package com.avito.android.user_stats.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsTrackerModule_ProvideScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public UserStatsTrackerModule_ProvideScreenFlowTrackerProviderFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTrackerModule_ProvideScreenFlowTrackerProviderFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new UserStatsTrackerModule_ProvideScreenFlowTrackerProviderFactory(provider, provider2);
    }

    public static ScreenFlowTrackerProvider provideScreenFlowTrackerProvider(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(UserStatsTrackerModule.INSTANCE.provideScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return provideScreenFlowTrackerProvider(this.a.get(), this.b.get());
    }
}
