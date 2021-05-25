package com.avito.android.messenger.channels.mvi.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideChatListRefreshTimerFactory implements Factory<AnalyticsTimer<ChatListRefreshResult>> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;

    public ChannelsModule_ProvideChatListRefreshTimerFactory(Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChannelsModule_ProvideChatListRefreshTimerFactory create(Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelsModule_ProvideChatListRefreshTimerFactory(provider, provider2);
    }

    public static AnalyticsTimer<ChatListRefreshResult> provideChatListRefreshTimer(Analytics analytics, Features features) {
        return (AnalyticsTimer) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideChatListRefreshTimer(analytics, features));
    }

    @Override // javax.inject.Provider
    public AnalyticsTimer<ChatListRefreshResult> get() {
        return provideChatListRefreshTimer(this.a.get(), this.b.get());
    }
}
