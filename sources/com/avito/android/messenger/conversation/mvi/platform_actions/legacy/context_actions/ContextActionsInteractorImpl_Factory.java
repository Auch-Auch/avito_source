package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ContextActionsInteractorImpl_Factory implements Factory<ContextActionsInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<ChannelSyncAgent> b;
    public final Provider<SendMessageInteractor> c;

    public ContextActionsInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<ChannelSyncAgent> provider2, Provider<SendMessageInteractor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ContextActionsInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<ChannelSyncAgent> provider2, Provider<SendMessageInteractor> provider3) {
        return new ContextActionsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static ContextActionsInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, ChannelSyncAgent channelSyncAgent, SendMessageInteractor sendMessageInteractor) {
        return new ContextActionsInteractorImpl(messengerClient, channelSyncAgent, sendMessageInteractor);
    }

    @Override // javax.inject.Provider
    public ContextActionsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
