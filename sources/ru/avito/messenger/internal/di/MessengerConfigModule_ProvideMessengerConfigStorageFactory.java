package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.Config;
public final class MessengerConfigModule_ProvideMessengerConfigStorageFactory implements Factory<MessengerConfigStorage> {
    public final MessengerConfigModule a;
    public final Provider<Config> b;

    public MessengerConfigModule_ProvideMessengerConfigStorageFactory(MessengerConfigModule messengerConfigModule, Provider<Config> provider) {
        this.a = messengerConfigModule;
        this.b = provider;
    }

    public static MessengerConfigModule_ProvideMessengerConfigStorageFactory create(MessengerConfigModule messengerConfigModule, Provider<Config> provider) {
        return new MessengerConfigModule_ProvideMessengerConfigStorageFactory(messengerConfigModule, provider);
    }

    public static MessengerConfigStorage provideMessengerConfigStorage(MessengerConfigModule messengerConfigModule, Config config) {
        return (MessengerConfigStorage) Preconditions.checkNotNullFromProvides(messengerConfigModule.provideMessengerConfigStorage(config));
    }

    @Override // javax.inject.Provider
    public MessengerConfigStorage get() {
        return provideMessengerConfigStorage(this.a, this.b.get());
    }
}
