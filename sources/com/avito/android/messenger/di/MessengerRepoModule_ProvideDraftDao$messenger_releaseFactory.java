package com.avito.android.messenger.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory implements Factory<DraftDao> {
    public final Provider<MessengerDatabase> a;

    public MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory(Provider<MessengerDatabase> provider) {
        this.a = provider;
    }

    public static MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory create(Provider<MessengerDatabase> provider) {
        return new MessengerRepoModule_ProvideDraftDao$messenger_releaseFactory(provider);
    }

    public static DraftDao provideDraftDao$messenger_release(MessengerDatabase messengerDatabase) {
        return (DraftDao) Preconditions.checkNotNullFromProvides(MessengerRepoModule.provideDraftDao$messenger_release(messengerDatabase));
    }

    @Override // javax.inject.Provider
    public DraftDao get() {
        return provideDraftDao$messenger_release(this.a.get());
    }
}
