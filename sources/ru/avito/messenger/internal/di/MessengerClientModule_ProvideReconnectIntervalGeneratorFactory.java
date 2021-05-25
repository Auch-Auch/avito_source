package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.ReconnectIntervalGenerator;
import ru.avito.messenger.internal.Config;
public final class MessengerClientModule_ProvideReconnectIntervalGeneratorFactory implements Factory<ReconnectIntervalGenerator> {
    public final Provider<Config> a;

    public MessengerClientModule_ProvideReconnectIntervalGeneratorFactory(Provider<Config> provider) {
        this.a = provider;
    }

    public static MessengerClientModule_ProvideReconnectIntervalGeneratorFactory create(Provider<Config> provider) {
        return new MessengerClientModule_ProvideReconnectIntervalGeneratorFactory(provider);
    }

    public static ReconnectIntervalGenerator provideReconnectIntervalGenerator(Config config) {
        return (ReconnectIntervalGenerator) Preconditions.checkNotNullFromProvides(MessengerClientModule.provideReconnectIntervalGenerator(config));
    }

    @Override // javax.inject.Provider
    public ReconnectIntervalGenerator get() {
        return provideReconnectIntervalGenerator(this.a.get());
    }
}
