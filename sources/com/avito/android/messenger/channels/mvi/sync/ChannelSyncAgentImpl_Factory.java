package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelSyncAgentImpl_Factory implements Factory<ChannelSyncAgentImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<MessengerEntityConverter> c;
    public final Provider<ChannelRepo> d;
    public final Provider<DraftRepoWriter> e;
    public final Provider<Features> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<TimeSource> h;

    public ChannelSyncAgentImpl_Factory(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MessengerEntityConverter> provider3, Provider<ChannelRepo> provider4, Provider<DraftRepoWriter> provider5, Provider<Features> provider6, Provider<SchedulersFactory> provider7, Provider<TimeSource> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ChannelSyncAgentImpl_Factory create(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MessengerEntityConverter> provider3, Provider<ChannelRepo> provider4, Provider<DraftRepoWriter> provider5, Provider<Features> provider6, Provider<SchedulersFactory> provider7, Provider<TimeSource> provider8) {
        return new ChannelSyncAgentImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ChannelSyncAgentImpl newInstance(AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient, MessengerEntityConverter messengerEntityConverter, ChannelRepo channelRepo, DraftRepoWriter draftRepoWriter, Features features, SchedulersFactory schedulersFactory, TimeSource timeSource) {
        return new ChannelSyncAgentImpl(accountStateProvider, messengerClient, messengerEntityConverter, channelRepo, draftRepoWriter, features, schedulersFactory, timeSource);
    }

    @Override // javax.inject.Provider
    public ChannelSyncAgentImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
