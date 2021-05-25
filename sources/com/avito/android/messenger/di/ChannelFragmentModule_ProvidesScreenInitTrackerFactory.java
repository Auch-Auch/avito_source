package com.avito.android.messenger.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final ChannelFragmentModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public ChannelFragmentModule_ProvidesScreenInitTrackerFactory(ChannelFragmentModule channelFragmentModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvidesScreenInitTrackerFactory create(ChannelFragmentModule channelFragmentModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ChannelFragmentModule_ProvidesScreenInitTrackerFactory(channelFragmentModule, provider, provider2);
    }

    public static ScreenInitTracker providesScreenInitTracker(ChannelFragmentModule channelFragmentModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(channelFragmentModule.providesScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a, this.b.get(), this.c.get());
    }
}
