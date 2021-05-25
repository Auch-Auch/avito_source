package com.avito.android.messenger.di;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class MessengerDatabaseModule_ProvideMessengerDatabaseFactory implements Factory<MessengerDatabase> {
    public final Provider<Application> a;

    public MessengerDatabaseModule_ProvideMessengerDatabaseFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static MessengerDatabaseModule_ProvideMessengerDatabaseFactory create(Provider<Application> provider) {
        return new MessengerDatabaseModule_ProvideMessengerDatabaseFactory(provider);
    }

    public static MessengerDatabase provideMessengerDatabase(Application application) {
        return (MessengerDatabase) Preconditions.checkNotNullFromProvides(MessengerDatabaseModule.provideMessengerDatabase(application));
    }

    @Override // javax.inject.Provider
    public MessengerDatabase get() {
        return provideMessengerDatabase(this.a.get());
    }
}
