package com.avito.android.publish.details.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final PublishDetailsAnalyticsModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public PublishDetailsAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = publishDetailsAnalyticsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory create(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new PublishDetailsAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory(publishDetailsAnalyticsModule, provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(publishDetailsAnalyticsModule.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a, this.b.get(), this.c.get());
    }
}
