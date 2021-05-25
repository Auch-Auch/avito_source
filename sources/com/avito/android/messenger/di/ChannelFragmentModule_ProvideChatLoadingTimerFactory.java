package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideChatLoadingTimerFactory implements Factory<AnalyticsTimer<ChatLoadingResult>> {
    public final ChannelFragmentModule a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public ChannelFragmentModule_ProvideChatLoadingTimerFactory(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvideChatLoadingTimerFactory create(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelFragmentModule_ProvideChatLoadingTimerFactory(channelFragmentModule, provider, provider2);
    }

    public static AnalyticsTimer<ChatLoadingResult> provideChatLoadingTimer(ChannelFragmentModule channelFragmentModule, Analytics analytics, Features features) {
        return (AnalyticsTimer) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideChatLoadingTimer(analytics, features));
    }

    @Override // javax.inject.Provider
    public AnalyticsTimer<ChatLoadingResult> get() {
        return provideChatLoadingTimer(this.a, this.b.get(), this.c.get());
    }
}
