package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class BlockUserInteractorImpl_Factory implements Factory<BlockUserInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<SchedulersFactory> b;

    public BlockUserInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BlockUserInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2) {
        return new BlockUserInteractorImpl_Factory(provider, provider2);
    }

    public static BlockUserInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, SchedulersFactory schedulersFactory) {
        return new BlockUserInteractorImpl(messengerClient, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public BlockUserInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
