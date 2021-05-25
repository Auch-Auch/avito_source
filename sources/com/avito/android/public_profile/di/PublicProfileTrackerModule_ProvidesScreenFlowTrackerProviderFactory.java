package com.avito.android.public_profile.di;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublicProfileTrackerModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<Screen> b;
    public final Provider<TimerFactory> c;

    public PublicProfileTrackerModule_ProvidesScreenFlowTrackerProviderFactory(Provider<ScreenTrackerFactory> provider, Provider<Screen> provider2, Provider<TimerFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublicProfileTrackerModule_ProvidesScreenFlowTrackerProviderFactory create(Provider<ScreenTrackerFactory> provider, Provider<Screen> provider2, Provider<TimerFactory> provider3) {
        return new PublicProfileTrackerModule_ProvidesScreenFlowTrackerProviderFactory(provider, provider2, provider3);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(ScreenTrackerFactory screenTrackerFactory, Screen screen, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(PublicProfileTrackerModule.INSTANCE.providesScreenFlowTrackerProvider(screenTrackerFactory, screen, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a.get(), this.b.get(), this.c.get());
    }
}
