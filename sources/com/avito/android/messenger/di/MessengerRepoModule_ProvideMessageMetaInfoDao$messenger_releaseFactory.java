package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory implements Factory<MessageMetaInfoDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideMessageMetaInfoDao$messenger_releaseFactory(provider);
    }

    public static MessageMetaInfoDao provideMessageMetaInfoDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (MessageMetaInfoDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideMessageMetaInfoDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public MessageMetaInfoDao get() {
        return provideMessageMetaInfoDao$messenger_release(this.a.get());
    }
}
