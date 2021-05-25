package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerEventObserver;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.config.MessengerConfigProvider;
public final class MessageSyncAgentImpl_Factory implements Factory<MessageSyncAgentImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessageRepo> b;
    public final Provider<MessengerEventObserver> c;
    public final Provider<MessengerHistory> d;
    public final Provider<MessageBodyResolver> e;
    public final Provider<MessengerEntityConverter> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<SyncJobsScheduler> h;
    public final Provider<Analytics> i;
    public final Provider<MessengerConfigProvider> j;
    public final Provider<MissingUsersSyncAgent> k;

    public MessageSyncAgentImpl_Factory(Provider<AccountStateProvider> provider, Provider<MessageRepo> provider2, Provider<MessengerEventObserver> provider3, Provider<MessengerHistory> provider4, Provider<MessageBodyResolver> provider5, Provider<MessengerEntityConverter> provider6, Provider<SchedulersFactory> provider7, Provider<SyncJobsScheduler> provider8, Provider<Analytics> provider9, Provider<MessengerConfigProvider> provider10, Provider<MissingUsersSyncAgent> provider11) {
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

    public static MessageSyncAgentImpl_Factory create(Provider<AccountStateProvider> provider, Provider<MessageRepo> provider2, Provider<MessengerEventObserver> provider3, Provider<MessengerHistory> provider4, Provider<MessageBodyResolver> provider5, Provider<MessengerEntityConverter> provider6, Provider<SchedulersFactory> provider7, Provider<SyncJobsScheduler> provider8, Provider<Analytics> provider9, Provider<MessengerConfigProvider> provider10, Provider<MissingUsersSyncAgent> provider11) {
        return new MessageSyncAgentImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static MessageSyncAgentImpl newInstance(AccountStateProvider accountStateProvider, MessageRepo messageRepo, MessengerEventObserver messengerEventObserver, MessengerHistory messengerHistory, MessageBodyResolver messageBodyResolver, MessengerEntityConverter messengerEntityConverter, SchedulersFactory schedulersFactory, SyncJobsScheduler syncJobsScheduler, Analytics analytics, MessengerConfigProvider messengerConfigProvider, MissingUsersSyncAgent missingUsersSyncAgent) {
        return new MessageSyncAgentImpl(accountStateProvider, messageRepo, messengerEventObserver, messengerHistory, messageBodyResolver, messengerEntityConverter, schedulersFactory, syncJobsScheduler, analytics, messengerConfigProvider, missingUsersSyncAgent);
    }

    @Override // javax.inject.Provider
    public MessageSyncAgentImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
