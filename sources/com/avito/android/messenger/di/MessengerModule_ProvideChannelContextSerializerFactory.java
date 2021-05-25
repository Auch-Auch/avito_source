package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class MessengerModule_ProvideChannelContextSerializerFactory implements Factory<ChannelContextSerializer> {
    public final MessengerModule a;
    public final Provider<Messenger<AvitoMessengerApi>> b;

    public MessengerModule_ProvideChannelContextSerializerFactory(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideChannelContextSerializerFactory create(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        return new MessengerModule_ProvideChannelContextSerializerFactory(messengerModule, provider);
    }

    public static ChannelContextSerializer provideChannelContextSerializer(MessengerModule messengerModule, Messenger<AvitoMessengerApi> messenger) {
        return (ChannelContextSerializer) Preconditions.checkNotNullFromProvides(messengerModule.provideChannelContextSerializer(messenger));
    }

    @Override // javax.inject.Provider
    public ChannelContextSerializer get() {
        return provideChannelContextSerializer(this.a, this.b.get());
    }
}
