package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
public final class MessengerClientModule_ProvideMessengerClientFactory implements Factory<MessengerClient<MessengerApi>> {
    public final Provider<MessengerApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Config> c;
    public final Provider<MessengerConnectionHolder<MessengerApi>> d;
    public final Provider<ErrorTracker> e;

    public MessengerClientModule_ProvideMessengerClientFactory(Provider<MessengerApi> provider, Provider<SchedulersFactory> provider2, Provider<Config> provider3, Provider<MessengerConnectionHolder<MessengerApi>> provider4, Provider<ErrorTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MessengerClientModule_ProvideMessengerClientFactory create(Provider<MessengerApi> provider, Provider<SchedulersFactory> provider2, Provider<Config> provider3, Provider<MessengerConnectionHolder<MessengerApi>> provider4, Provider<ErrorTracker> provider5) {
        return new MessengerClientModule_ProvideMessengerClientFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessengerClient<MessengerApi> provideMessengerClient(MessengerApi messengerApi, SchedulersFactory schedulersFactory, Config config, Lazy<MessengerConnectionHolder<MessengerApi>> lazy, ErrorTracker errorTracker) {
        return (MessengerClient) Preconditions.checkNotNullFromProvides(MessengerClientModule.provideMessengerClient(messengerApi, schedulersFactory, config, lazy, errorTracker));
    }

    @Override // javax.inject.Provider
    public MessengerClient<MessengerApi> get() {
        return provideMessengerClient(this.a.get(), this.b.get(), this.c.get(), DoubleCheck.lazy(this.d), this.e.get());
    }
}
