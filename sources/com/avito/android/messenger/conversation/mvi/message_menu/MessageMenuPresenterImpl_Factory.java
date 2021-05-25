package com.avito.android.messenger.conversation.mvi.message_menu;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
import ru.avito.messenger.config.MessengerConfigProvider;
public final class MessageMenuPresenterImpl_Factory implements Factory<MessageMenuPresenterImpl> {
    public final Provider<List<MenuElementProvider>> a;
    public final Provider<MessageContextDataFactory> b;
    public final Provider<MessengerConfigProvider> c;
    public final Provider<SchedulersFactory> d;

    public MessageMenuPresenterImpl_Factory(Provider<List<MenuElementProvider>> provider, Provider<MessageContextDataFactory> provider2, Provider<MessengerConfigProvider> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MessageMenuPresenterImpl_Factory create(Provider<List<MenuElementProvider>> provider, Provider<MessageContextDataFactory> provider2, Provider<MessengerConfigProvider> provider3, Provider<SchedulersFactory> provider4) {
        return new MessageMenuPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static MessageMenuPresenterImpl newInstance(List<MenuElementProvider> list, MessageContextDataFactory messageContextDataFactory, MessengerConfigProvider messengerConfigProvider, SchedulersFactory schedulersFactory) {
        return new MessageMenuPresenterImpl(list, messageContextDataFactory, messengerConfigProvider, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public MessageMenuPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
