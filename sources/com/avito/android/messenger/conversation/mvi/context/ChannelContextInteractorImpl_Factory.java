package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelContextInteractorImpl_Factory implements Factory<ChannelContextInteractorImpl> {
    public final Provider<String> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<MessengerClient<AvitoMessengerApi>> d;
    public final Provider<UserLastActivitySyncAgent> e;
    public final Provider<Analytics> f;
    public final Provider<OpenErrorTrackerScheduler> g;
    public final Provider<OpenedFrom> h;
    public final Provider<ChannelTracker> i;
    public final Provider<ChannelRepo> j;
    public final Provider<ChannelSyncAgent> k;

    public ChannelContextInteractorImpl_Factory(Provider<String> provider, Provider<SchedulersFactory> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<UserLastActivitySyncAgent> provider5, Provider<Analytics> provider6, Provider<OpenErrorTrackerScheduler> provider7, Provider<OpenedFrom> provider8, Provider<ChannelTracker> provider9, Provider<ChannelRepo> provider10, Provider<ChannelSyncAgent> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static ChannelContextInteractorImpl_Factory create(Provider<String> provider, Provider<SchedulersFactory> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<UserLastActivitySyncAgent> provider5, Provider<Analytics> provider6, Provider<OpenErrorTrackerScheduler> provider7, Provider<OpenedFrom> provider8, Provider<ChannelTracker> provider9, Provider<ChannelRepo> provider10, Provider<ChannelSyncAgent> provider11) {
        return new ChannelContextInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static ChannelContextInteractorImpl newInstance(String str, SchedulersFactory schedulersFactory, AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient, UserLastActivitySyncAgent userLastActivitySyncAgent, Analytics analytics, OpenErrorTrackerScheduler openErrorTrackerScheduler, OpenedFrom openedFrom, ChannelTracker channelTracker, ChannelRepo channelRepo, ChannelSyncAgent channelSyncAgent) {
        return new ChannelContextInteractorImpl(str, schedulersFactory, accountStateProvider, messengerClient, userLastActivitySyncAgent, analytics, openErrorTrackerScheduler, openedFrom, channelTracker, channelRepo, channelSyncAgent);
    }

    @Override // javax.inject.Provider
    public ChannelContextInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
