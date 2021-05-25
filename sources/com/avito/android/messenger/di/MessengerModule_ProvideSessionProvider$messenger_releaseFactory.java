package com.avito.android.messenger.di;

import com.avito.android.account.AccountStorageInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.SessionProvider;
public final class MessengerModule_ProvideSessionProvider$messenger_releaseFactory implements Factory<SessionProvider> {
    public final MessengerModule a;
    public final Provider<AccountStorageInteractor> b;

    public MessengerModule_ProvideSessionProvider$messenger_releaseFactory(MessengerModule messengerModule, Provider<AccountStorageInteractor> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideSessionProvider$messenger_releaseFactory create(MessengerModule messengerModule, Provider<AccountStorageInteractor> provider) {
        return new MessengerModule_ProvideSessionProvider$messenger_releaseFactory(messengerModule, provider);
    }

    public static SessionProvider provideSessionProvider$messenger_release(MessengerModule messengerModule, AccountStorageInteractor accountStorageInteractor) {
        return (SessionProvider) Preconditions.checkNotNullFromProvides(messengerModule.provideSessionProvider$messenger_release(accountStorageInteractor));
    }

    @Override // javax.inject.Provider
    public SessionProvider get() {
        return provideSessionProvider$messenger_release(this.a, this.b.get());
    }
}
