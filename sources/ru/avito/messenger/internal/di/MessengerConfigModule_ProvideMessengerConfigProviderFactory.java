package ru.avito.messenger.internal.di;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.config.MessengerConfigProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
public final class MessengerConfigModule_ProvideMessengerConfigProviderFactory implements Factory<MessengerConfigProvider> {
    public final MessengerConfigModule a;
    public final Provider<MessengerConfigStorage> b;
    public final Provider<SchedulersFactory> c;

    public MessengerConfigModule_ProvideMessengerConfigProviderFactory(MessengerConfigModule messengerConfigModule, Provider<MessengerConfigStorage> provider, Provider<SchedulersFactory> provider2) {
        this.a = messengerConfigModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessengerConfigModule_ProvideMessengerConfigProviderFactory create(MessengerConfigModule messengerConfigModule, Provider<MessengerConfigStorage> provider, Provider<SchedulersFactory> provider2) {
        return new MessengerConfigModule_ProvideMessengerConfigProviderFactory(messengerConfigModule, provider, provider2);
    }

    public static MessengerConfigProvider provideMessengerConfigProvider(MessengerConfigModule messengerConfigModule, MessengerConfigStorage messengerConfigStorage, SchedulersFactory schedulersFactory) {
        return (MessengerConfigProvider) Preconditions.checkNotNullFromProvides(messengerConfigModule.provideMessengerConfigProvider(messengerConfigStorage, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public MessengerConfigProvider get() {
        return provideMessengerConfigProvider(this.a, this.b.get(), this.c.get());
    }
}
