package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory implements Factory<MessageDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideMessageDao$messenger_releaseFactory(provider);
    }

    public static MessageDao provideMessageDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (MessageDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideMessageDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public MessageDao get() {
        return provideMessageDao$messenger_release(this.a.get());
    }
}
