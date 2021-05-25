package com.avito.android;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.app.task.LocalMessageSender;
import com.avito.android.app.task.MessageSendingTrackerFactory;
import com.avito.android.app.task.PendingMessageHandler;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class PendingMessageHandlerModule_ProvidePendingMessageHandlerFactory implements Factory<PendingMessageHandler> {
    public final Provider<AccountStateProvider> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<MessageRepo> c;
    public final Provider<LocalMessageSender> d;
    public final Provider<TimeSource> e;
    public final Provider<MessageSendingTrackerFactory> f;
    public final Provider<MessengerErrorTracker> g;
    public final Provider<SchedulersFactory> h;
    public final Provider<Features> i;
    public final Provider<Analytics> j;
    public final Provider<NetworkTypeProvider> k;

    public PendingMessageHandlerModule_ProvidePendingMessageHandlerFactory(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MessageRepo> provider3, Provider<LocalMessageSender> provider4, Provider<TimeSource> provider5, Provider<MessageSendingTrackerFactory> provider6, Provider<MessengerErrorTracker> provider7, Provider<SchedulersFactory> provider8, Provider<Features> provider9, Provider<Analytics> provider10, Provider<NetworkTypeProvider> provider11) {
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

    public static PendingMessageHandlerModule_ProvidePendingMessageHandlerFactory create(Provider<AccountStateProvider> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MessageRepo> provider3, Provider<LocalMessageSender> provider4, Provider<TimeSource> provider5, Provider<MessageSendingTrackerFactory> provider6, Provider<MessengerErrorTracker> provider7, Provider<SchedulersFactory> provider8, Provider<Features> provider9, Provider<Analytics> provider10, Provider<NetworkTypeProvider> provider11) {
        return new PendingMessageHandlerModule_ProvidePendingMessageHandlerFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static PendingMessageHandler providePendingMessageHandler(AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient, MessageRepo messageRepo, LocalMessageSender localMessageSender, TimeSource timeSource, MessageSendingTrackerFactory messageSendingTrackerFactory, MessengerErrorTracker messengerErrorTracker, SchedulersFactory schedulersFactory, Features features, Analytics analytics, NetworkTypeProvider networkTypeProvider) {
        return (PendingMessageHandler) Preconditions.checkNotNullFromProvides(PendingMessageHandlerModule.providePendingMessageHandler(accountStateProvider, messengerClient, messageRepo, localMessageSender, timeSource, messageSendingTrackerFactory, messengerErrorTracker, schedulersFactory, features, analytics, networkTypeProvider));
    }

    @Override // javax.inject.Provider
    public PendingMessageHandler get() {
        return providePendingMessageHandler(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
