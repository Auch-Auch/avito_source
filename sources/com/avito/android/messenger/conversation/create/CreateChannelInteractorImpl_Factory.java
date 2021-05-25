package com.avito.android.messenger.conversation.create;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreateChannelInteractorImpl_Factory implements Factory<CreateChannelInteractorImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ChannelRepoReader> c;
    public final Provider<ChannelSyncAgent> d;
    public final Provider<DraftRepoWriter> e;

    public CreateChannelInteractorImpl_Factory(Provider<AccountStateProvider> provider, Provider<SchedulersFactory> provider2, Provider<ChannelRepoReader> provider3, Provider<ChannelSyncAgent> provider4, Provider<DraftRepoWriter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static CreateChannelInteractorImpl_Factory create(Provider<AccountStateProvider> provider, Provider<SchedulersFactory> provider2, Provider<ChannelRepoReader> provider3, Provider<ChannelSyncAgent> provider4, Provider<DraftRepoWriter> provider5) {
        return new CreateChannelInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CreateChannelInteractorImpl newInstance(AccountStateProvider accountStateProvider, SchedulersFactory schedulersFactory, ChannelRepoReader channelRepoReader, ChannelSyncAgent channelSyncAgent, DraftRepoWriter draftRepoWriter) {
        return new CreateChannelInteractorImpl(accountStateProvider, schedulersFactory, channelRepoReader, channelSyncAgent, draftRepoWriter);
    }

    @Override // javax.inject.Provider
    public CreateChannelInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
