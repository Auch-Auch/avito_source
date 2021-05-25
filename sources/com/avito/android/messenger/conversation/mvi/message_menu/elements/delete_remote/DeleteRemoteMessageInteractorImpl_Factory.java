package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DeleteRemoteMessageInteractorImpl_Factory implements Factory<DeleteRemoteMessageInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<MessengerEntityConverter> b;
    public final Provider<MessageRepoWriter> c;

    public DeleteRemoteMessageInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<MessengerEntityConverter> provider2, Provider<MessageRepoWriter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeleteRemoteMessageInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<MessengerEntityConverter> provider2, Provider<MessageRepoWriter> provider3) {
        return new DeleteRemoteMessageInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static DeleteRemoteMessageInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, MessengerEntityConverter messengerEntityConverter, MessageRepoWriter messageRepoWriter) {
        return new DeleteRemoteMessageInteractorImpl(messengerClient, messengerEntityConverter, messageRepoWriter);
    }

    @Override // javax.inject.Provider
    public DeleteRemoteMessageInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
