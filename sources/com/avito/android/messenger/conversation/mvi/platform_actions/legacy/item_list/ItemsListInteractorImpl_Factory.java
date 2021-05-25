package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ItemsListInteractorImpl_Factory implements Factory<ItemsListInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<SchedulersFactory> b;

    public ItemsListInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ItemsListInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2) {
        return new ItemsListInteractorImpl_Factory(provider, provider2);
    }

    public static ItemsListInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, SchedulersFactory schedulersFactory) {
        return new ItemsListInteractorImpl(messengerClient, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ItemsListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
