package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerModule_ProvideYandexApiKeyFactory implements Factory<YandexApiKey> {
    public final MessengerModule a;
    public final Provider<Context> b;

    public MessengerModule_ProvideYandexApiKeyFactory(MessengerModule messengerModule, Provider<Context> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideYandexApiKeyFactory create(MessengerModule messengerModule, Provider<Context> provider) {
        return new MessengerModule_ProvideYandexApiKeyFactory(messengerModule, provider);
    }

    public static YandexApiKey provideYandexApiKey(MessengerModule messengerModule, Context context) {
        return (YandexApiKey) Preconditions.checkNotNullFromProvides(messengerModule.provideYandexApiKey(context));
    }

    @Override // javax.inject.Provider
    public YandexApiKey get() {
        return provideYandexApiKey(this.a, this.b.get());
    }
}
