package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.graphite_counter.ChatAppendCounter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideChatAppendCounterFactory implements Factory<ChatAppendCounter> {
    public final ChannelFragmentModule a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public ChannelFragmentModule_ProvideChatAppendCounterFactory(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvideChatAppendCounterFactory create(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelFragmentModule_ProvideChatAppendCounterFactory(channelFragmentModule, provider, provider2);
    }

    public static ChatAppendCounter provideChatAppendCounter(ChannelFragmentModule channelFragmentModule, Analytics analytics, Features features) {
        return (ChatAppendCounter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideChatAppendCounter(analytics, features));
    }

    @Override // javax.inject.Provider
    public ChatAppendCounter get() {
        return provideChatAppendCounter(this.a, this.b.get(), this.c.get());
    }
}
