package com.avito.android.publish.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final PublishModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public PublishModule_ProvidesScreenFlowTrackerProviderFactory(PublishModule publishModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = publishModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishModule_ProvidesScreenFlowTrackerProviderFactory create(PublishModule publishModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new PublishModule_ProvidesScreenFlowTrackerProviderFactory(publishModule, provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(PublishModule publishModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(publishModule.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a, this.b.get(), this.c.get());
    }
}
