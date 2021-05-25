package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class BlacklistReasonsProviderImpl_Factory implements Factory<BlacklistReasonsProviderImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<SchedulersFactory> b;

    public BlacklistReasonsProviderImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BlacklistReasonsProviderImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2) {
        return new BlacklistReasonsProviderImpl_Factory(provider, provider2);
    }

    public static BlacklistReasonsProviderImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, SchedulersFactory schedulersFactory) {
        return new BlacklistReasonsProviderImpl(messengerClient, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public BlacklistReasonsProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
