package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class MessengerModule_ProvideChannelPropertySerializerFactory implements Factory<ChannelPropertySerializer> {
    public final MessengerModule a;
    public final Provider<Messenger<AvitoMessengerApi>> b;

    public MessengerModule_ProvideChannelPropertySerializerFactory(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideChannelPropertySerializerFactory create(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        return new MessengerModule_ProvideChannelPropertySerializerFactory(messengerModule, provider);
    }

    public static ChannelPropertySerializer provideChannelPropertySerializer(MessengerModule messengerModule, Messenger<AvitoMessengerApi> messenger) {
        return (ChannelPropertySerializer) Preconditions.checkNotNullFromProvides(messengerModule.provideChannelPropertySerializer(messenger));
    }

    @Override // javax.inject.Provider
    public ChannelPropertySerializer get() {
        return provideChannelPropertySerializer(this.a, this.b.get());
    }
}
