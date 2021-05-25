package com.avito.android.messenger.channels.mvi.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideChatListLoadingTimerFactory implements Factory<AnalyticsTimer<ChatListLoadingResult>> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;

    public ChannelsModule_ProvideChatListLoadingTimerFactory(Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideChatListLoadingTimerFactory create(Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelsModule_ProvideChatListLoadingTimerFactory(provider, provider2);
    }

    public static AnalyticsTimer<ChatListLoadingResult> provideChatListLoadingTimer(Analytics analytics, Features features) {
        return (AnalyticsTimer) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideChatListLoadingTimer(analytics, features));
    }

    @Override // javax.inject.Provider
    public AnalyticsTimer<ChatListLoadingResult> get() {
        return provideChatListLoadingTimer(this.a.get(), this.b.get());
    }
}
