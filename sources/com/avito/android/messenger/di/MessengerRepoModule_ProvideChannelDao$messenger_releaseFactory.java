package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory implements Factory<ChannelDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideChannelDao$messenger_releaseFactory(provider);
    }

    public static ChannelDao provideChannelDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (ChannelDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideChannelDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public ChannelDao get() {
        return provideChannelDao$messenger_release(this.a.get());
    }
}
