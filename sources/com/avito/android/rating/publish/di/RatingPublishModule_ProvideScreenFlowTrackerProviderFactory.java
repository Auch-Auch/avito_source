package com.avito.android.rating.publish.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RatingPublishModule_ProvideScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public RatingPublishModule_ProvideScreenFlowTrackerProviderFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RatingPublishModule_ProvideScreenFlowTrackerProviderFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new RatingPublishModule_ProvideScreenFlowTrackerProviderFactory(provider, provider2);
    }

    public static ScreenFlowTrackerProvider provideScreenFlowTrackerProvider(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(RatingPublishModule.provideScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return provideScreenFlowTrackerProvider(this.a.get(), this.b.get());
    }
}
