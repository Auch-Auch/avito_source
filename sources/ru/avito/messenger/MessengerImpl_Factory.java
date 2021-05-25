package ru.avito.messenger;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.config.MessengerConfigProvider;
public final class MessengerImpl_Factory<T extends MessengerApi> implements Factory<MessengerImpl<T>> {
    public final Provider<MessengerClient<T>> a;
    public final Provider<MessengerImageUploadApi> b;
    public final Provider<Gson> c;
    public final Provider<MessengerConfigProvider> d;

    public MessengerImpl_Factory(Provider<MessengerClient<T>> provider, Provider<MessengerImageUploadApi> provider2, Provider<Gson> provider3, Provider<MessengerConfigProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static <T extends MessengerApi> MessengerImpl_Factory<T> create(Provider<MessengerClient<T>> provider, Provider<MessengerImageUploadApi> provider2, Provider<Gson> provider3, Provider<MessengerConfigProvider> provider4) {
        return new MessengerImpl_Factory<>(provider, provider2, provider3, provider4);
    }

    public static <T extends MessengerApi> MessengerImpl<T> newInstance(MessengerClient<T> messengerClient, MessengerImageUploadApi messengerImageUploadApi, Gson gson, MessengerConfigProvider messengerConfigProvider) {
        return new MessengerImpl<>(messengerClient, messengerImageUploadApi, gson, messengerConfigProvider);
    }

    @Override // javax.inject.Provider
    public MessengerImpl<T> get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
