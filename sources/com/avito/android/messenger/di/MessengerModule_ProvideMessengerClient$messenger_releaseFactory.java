package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class MessengerModule_ProvideMessengerClient$messenger_releaseFactory implements Factory<MessengerClient<AvitoMessengerApi>> {
    public final MessengerModule a;
    public final Provider<Messenger<AvitoMessengerApi>> b;

    public MessengerModule_ProvideMessengerClient$messenger_releaseFactory(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideMessengerClient$messenger_releaseFactory create(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        return new MessengerModule_ProvideMessengerClient$messenger_releaseFactory(messengerModule, provider);
    }

    public static MessengerClient<AvitoMessengerApi> provideMessengerClient$messenger_release(MessengerModule messengerModule, Messenger<AvitoMessengerApi> messenger) {
        return (MessengerClient) Preconditions.checkNotNullFromProvides(messengerModule.provideMessengerClient$messenger_release(messenger));
    }

    @Override // javax.inject.Provider
    public MessengerClient<AvitoMessengerApi> get() {
        return provideMessengerClient$messenger_release(this.a, this.b.get());
    }
}
