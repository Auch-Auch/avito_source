package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoReader;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelSyncOnPushAgentImpl_Factory implements Factory<ChannelSyncOnPushAgentImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<ChannelRepoReader> c;
    public final Provider<ChannelSyncAgent> d;
    public final Provider<MessageRepoReader> e;
    public final Provider<MessageSyncAgent> f;
    public final Provider<SchedulersFactory> g;

    public ChannelSyncOnPushAgentImpl_Factory(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<ChannelRepoReader> provider3, Provider<ChannelSyncAgent> provider4, Provider<MessageRepoReader> provider5, Provider<MessageSyncAgent> provider6, Provider<SchedulersFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ChannelSyncOnPushAgentImpl_Factory create(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<ChannelRepoReader> provider3, Provider<ChannelSyncAgent> provider4, Provider<MessageRepoReader> provider5, Provider<MessageSyncAgent> provider6, Provider<SchedulersFactory> provider7) {
        return new ChannelSyncOnPushAgentImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ChannelSyncOnPushAgentImpl newInstance(AccountStateProvider accountStateProvider, Lazy<MessengerClient<AvitoMessengerApi>> lazy, Lazy<ChannelRepoReader> lazy2, Lazy<ChannelSyncAgent> lazy3, Lazy<MessageRepoReader> lazy4, Lazy<MessageSyncAgent> lazy5, SchedulersFactory schedulersFactory) {
        return new ChannelSyncOnPushAgentImpl(accountStateProvider, lazy, lazy2, lazy3, lazy4, lazy5, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ChannelSyncOnPushAgentImpl get() {
        return newInstance(this.a.get(), DoubleCheck.lazy(this.b), DoubleCheck.lazy(this.c), DoubleCheck.lazy(this.d), DoubleCheck.lazy(this.e), DoubleCheck.lazy(this.f), this.g.get());
    }
}
