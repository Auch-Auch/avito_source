package com.avito.android.messenger.support;

import com.avito.android.remote.SupportApi;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class SupportChatFormInteractorImpl_Factory implements Factory<SupportChatFormInteractorImpl> {
    public final Provider<SupportApi> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<RandomKeyProvider> c;

    public SupportChatFormInteractorImpl_Factory(Provider<SupportApi> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<RandomKeyProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SupportChatFormInteractorImpl_Factory create(Provider<SupportApi> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<RandomKeyProvider> provider3) {
        return new SupportChatFormInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SupportChatFormInteractorImpl newInstance(SupportApi supportApi, MessengerClient<AvitoMessengerApi> messengerClient, RandomKeyProvider randomKeyProvider) {
        return new SupportChatFormInteractorImpl(supportApi, messengerClient, randomKeyProvider);
    }

    @Override // javax.inject.Provider
    public SupportChatFormInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
