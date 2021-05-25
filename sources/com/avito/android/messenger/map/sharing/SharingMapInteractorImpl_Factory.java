package com.avito.android.messenger.map.sharing;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class SharingMapInteractorImpl_Factory implements Factory<SharingMapInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;

    public SharingMapInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider) {
        this.a = provider;
    }

    public static SharingMapInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider) {
        return new SharingMapInteractorImpl_Factory(provider);
    }

    public static SharingMapInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient) {
        return new SharingMapInteractorImpl(messengerClient);
    }

    @Override // javax.inject.Provider
    public SharingMapInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
