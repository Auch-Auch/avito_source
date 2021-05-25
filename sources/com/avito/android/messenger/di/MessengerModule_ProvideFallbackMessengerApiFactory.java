package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class MessengerModule_ProvideFallbackMessengerApiFactory implements Factory<AvitoMessengerApi> {
    public final MessengerModule a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;

    public MessengerModule_ProvideFallbackMessengerApiFactory(MessengerModule messengerModule, Provider<MessengerClient<AvitoMessengerApi>> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideFallbackMessengerApiFactory create(MessengerModule messengerModule, Provider<MessengerClient<AvitoMessengerApi>> provider) {
        return new MessengerModule_ProvideFallbackMessengerApiFactory(messengerModule, provider);
    }

    public static AvitoMessengerApi provideFallbackMessengerApi(MessengerModule messengerModule, MessengerClient<AvitoMessengerApi> messengerClient) {
        return (AvitoMessengerApi) Preconditions.checkNotNullFromProvides(messengerModule.provideFallbackMessengerApi(messengerClient));
    }

    @Override // javax.inject.Provider
    public AvitoMessengerApi get() {
        return provideFallbackMessengerApi(this.a, this.b.get());
    }
}
