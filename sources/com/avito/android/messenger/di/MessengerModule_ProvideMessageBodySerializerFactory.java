package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class MessengerModule_ProvideMessageBodySerializerFactory implements Factory<MessageBodySerializer> {
    public final MessengerModule a;
    public final Provider<Messenger<AvitoMessengerApi>> b;

    public MessengerModule_ProvideMessageBodySerializerFactory(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideMessageBodySerializerFactory create(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        return new MessengerModule_ProvideMessageBodySerializerFactory(messengerModule, provider);
    }

    public static MessageBodySerializer provideMessageBodySerializer(MessengerModule messengerModule, Messenger<AvitoMessengerApi> messenger) {
        return (MessageBodySerializer) Preconditions.checkNotNullFromProvides(messengerModule.provideMessageBodySerializer(messenger));
    }

    @Override // javax.inject.Provider
    public MessageBodySerializer get() {
        return provideMessageBodySerializer(this.a, this.b.get());
    }
}
