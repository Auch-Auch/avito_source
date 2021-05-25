package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.config.MessengerConfigProvider;
public final class MessengerModule_ProviderMessengerConfigProviderFactory implements Factory<MessengerConfigProvider> {
    public final MessengerModule a;
    public final Provider<Messenger<AvitoMessengerApi>> b;

    public MessengerModule_ProviderMessengerConfigProviderFactory(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProviderMessengerConfigProviderFactory create(MessengerModule messengerModule, Provider<Messenger<AvitoMessengerApi>> provider) {
        return new MessengerModule_ProviderMessengerConfigProviderFactory(messengerModule, provider);
    }

    public static MessengerConfigProvider providerMessengerConfigProvider(MessengerModule messengerModule, Messenger<AvitoMessengerApi> messenger) {
        return (MessengerConfigProvider) Preconditions.checkNotNullFromProvides(messengerModule.providerMessengerConfigProvider(messenger));
    }

    @Override // javax.inject.Provider
    public MessengerConfigProvider get() {
        return providerMessengerConfigProvider(this.a, this.b.get());
    }
}
