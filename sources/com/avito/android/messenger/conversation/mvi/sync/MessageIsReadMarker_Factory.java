package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerHistory;
public final class MessageIsReadMarker_Factory implements Factory<MessageIsReadMarker> {
    public final Provider<MessageRepo> a;
    public final Provider<MessengerHistory> b;
    public final Provider<SchedulersFactory> c;

    public MessageIsReadMarker_Factory(Provider<MessageRepo> provider, Provider<MessengerHistory> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MessageIsReadMarker_Factory create(Provider<MessageRepo> provider, Provider<MessengerHistory> provider2, Provider<SchedulersFactory> provider3) {
        return new MessageIsReadMarker_Factory(provider, provider2, provider3);
    }

    public static MessageIsReadMarker newInstance(MessageRepo messageRepo, MessengerHistory messengerHistory, SchedulersFactory schedulersFactory) {
        return new MessageIsReadMarker(messageRepo, messengerHistory, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public MessageIsReadMarker get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
