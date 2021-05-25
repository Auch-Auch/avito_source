package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerConnection;
public final class MessageListInteractorImpl_Factory implements Factory<MessageListInteractorImpl> {
    public final Provider<MessageRepo> a;
    public final Provider<MessageSyncAgent> b;
    public final Provider<MessengerConnection> c;
    public final Provider<AnalyticsTimer<ChatLoadingResult>> d;
    public final Provider<Analytics> e;
    public final Provider<ChannelFragment.Params> f;
    public final Provider<MessageListInteractor.State> g;
    public final Provider<SchedulersFactory> h;

    public MessageListInteractorImpl_Factory(Provider<MessageRepo> provider, Provider<MessageSyncAgent> provider2, Provider<MessengerConnection> provider3, Provider<AnalyticsTimer<ChatLoadingResult>> provider4, Provider<Analytics> provider5, Provider<ChannelFragment.Params> provider6, Provider<MessageListInteractor.State> provider7, Provider<SchedulersFactory> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MessageListInteractorImpl_Factory create(Provider<MessageRepo> provider, Provider<MessageSyncAgent> provider2, Provider<MessengerConnection> provider3, Provider<AnalyticsTimer<ChatLoadingResult>> provider4, Provider<Analytics> provider5, Provider<ChannelFragment.Params> provider6, Provider<MessageListInteractor.State> provider7, Provider<SchedulersFactory> provider8) {
        return new MessageListInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static MessageListInteractorImpl newInstance(MessageRepo messageRepo, MessageSyncAgent messageSyncAgent, MessengerConnection messengerConnection, AnalyticsTimer<ChatLoadingResult> analyticsTimer, Analytics analytics, ChannelFragment.Params params, MessageListInteractor.State state, SchedulersFactory schedulersFactory) {
        return new MessageListInteractorImpl(messageRepo, messageSyncAgent, messengerConnection, analyticsTimer, analytics, params, state, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public MessageListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
