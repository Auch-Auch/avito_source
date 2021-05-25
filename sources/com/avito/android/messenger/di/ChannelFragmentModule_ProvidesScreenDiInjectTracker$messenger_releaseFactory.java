package com.avito.android.messenger.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvidesScreenDiInjectTracker$messenger_releaseFactory implements Factory<ScreenDiInjectTracker> {
    public final ChannelFragmentModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public ChannelFragmentModule_ProvidesScreenDiInjectTracker$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvidesScreenDiInjectTracker$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new ChannelFragmentModule_ProvidesScreenDiInjectTracker$messenger_releaseFactory(channelFragmentModule, provider, provider2);
    }

    public static ScreenDiInjectTracker providesScreenDiInjectTracker$messenger_release(ChannelFragmentModule channelFragmentModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenDiInjectTracker) Preconditions.checkNotNullFromProvides(channelFragmentModule.providesScreenDiInjectTracker$messenger_release(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenDiInjectTracker get() {
        return providesScreenDiInjectTracker$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
