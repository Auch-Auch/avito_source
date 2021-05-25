package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory implements Factory<ChannelTagDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideChannelTagDao$messenger_releaseFactory(provider);
    }

    public static ChannelTagDao provideChannelTagDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (ChannelTagDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideChannelTagDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public ChannelTagDao get() {
        return provideChannelTagDao$messenger_release(this.a.get());
    }
}
