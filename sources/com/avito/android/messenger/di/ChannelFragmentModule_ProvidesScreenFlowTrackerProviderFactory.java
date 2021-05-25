package com.avito.android.messenger.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final ChannelFragmentModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public ChannelFragmentModule_ProvidesScreenFlowTrackerProviderFactory(ChannelFragmentModule channelFragmentModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvidesScreenFlowTrackerProviderFactory create(ChannelFragmentModule channelFragmentModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ChannelFragmentModule_ProvidesScreenFlowTrackerProviderFactory(channelFragmentModule, provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(ChannelFragmentModule channelFragmentModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(channelFragmentModule.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a, this.b.get(), this.c.get());
    }
}
