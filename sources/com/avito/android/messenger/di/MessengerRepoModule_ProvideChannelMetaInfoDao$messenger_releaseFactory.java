package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory implements Factory<ChannelMetaInfoDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideChannelMetaInfoDao$messenger_releaseFactory(provider);
    }

    public static ChannelMetaInfoDao provideChannelMetaInfoDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (ChannelMetaInfoDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideChannelMetaInfoDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public ChannelMetaInfoDao get() {
        return provideChannelMetaInfoDao$messenger_release(this.a.get());
    }
}
