package com.avito.android.app.task;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmptyChatsCleanerImpl_Factory implements Factory<EmptyChatsCleanerImpl> {
    public final Provider<TimeSource> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<MessageRepoWriter> c;
    public final Provider<ChannelRepo> d;
    public final Provider<SchedulersFactory> e;

    public EmptyChatsCleanerImpl_Factory(Provider<TimeSource> provider, Provider<AccountStateProvider> provider2, Provider<MessageRepoWriter> provider3, Provider<ChannelRepo> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static EmptyChatsCleanerImpl_Factory create(Provider<TimeSource> provider, Provider<AccountStateProvider> provider2, Provider<MessageRepoWriter> provider3, Provider<ChannelRepo> provider4, Provider<SchedulersFactory> provider5) {
        return new EmptyChatsCleanerImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static EmptyChatsCleanerImpl newInstance(TimeSource timeSource, AccountStateProvider accountStateProvider, MessageRepoWriter messageRepoWriter, ChannelRepo channelRepo, SchedulersFactory schedulersFactory) {
        return new EmptyChatsCleanerImpl(timeSource, accountStateProvider, messageRepoWriter, channelRepo, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public EmptyChatsCleanerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
