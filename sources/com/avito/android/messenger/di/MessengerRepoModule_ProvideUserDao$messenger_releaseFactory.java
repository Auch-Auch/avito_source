package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.android.persistence.messenger.UserDao;
public final class MessengerRepoModule_ProvideUserDao$messenger_releaseFactory implements Factory<UserDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideUserDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideUserDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideUserDao$messenger_releaseFactory(provider);
    }

    public static UserDao provideUserDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (UserDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideUserDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public UserDao get() {
        return provideUserDao$messenger_release(this.a.get());
    }
}
