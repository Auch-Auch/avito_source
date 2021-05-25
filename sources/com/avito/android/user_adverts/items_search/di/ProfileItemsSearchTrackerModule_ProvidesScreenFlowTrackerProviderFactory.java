package com.avito.android.user_adverts.items_search.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ProfileItemsSearchTrackerModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final Provider<ScreenTrackerFactory> a;
    public final Provider<TimerFactory> b;

    public ProfileItemsSearchTrackerModule_ProvidesScreenFlowTrackerProviderFactory(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileItemsSearchTrackerModule_ProvidesScreenFlowTrackerProviderFactory create(Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ProfileItemsSearchTrackerModule_ProvidesScreenFlowTrackerProviderFactory(provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(ProfileItemsSearchTrackerModule.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a.get(), this.b.get());
    }
}
