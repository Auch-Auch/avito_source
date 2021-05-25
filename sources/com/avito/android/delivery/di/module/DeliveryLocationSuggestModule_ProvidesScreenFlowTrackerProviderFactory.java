package com.avito.android.delivery.di.module;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryLocationSuggestModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public DeliveryLocationSuggestModule_ProvidesScreenFlowTrackerProviderFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DeliveryLocationSuggestModule_ProvidesScreenFlowTrackerProviderFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new DeliveryLocationSuggestModule_ProvidesScreenFlowTrackerProviderFactory(provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(DeliveryLocationSuggestModule.INSTANCE.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a.get(), this.b.get());
    }
}
