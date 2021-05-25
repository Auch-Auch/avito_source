package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.ReconnectIntervalGenerator;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.WebsocketMessageParser;
public final class MessengerClientModule_ProvideConnectionHolderFactory implements Factory<MessengerConnectionHolder<MessengerApi>> {
    public final Provider<LegacyRxWebSocket> a;
    public final Provider<MessengerApi> b;
    public final Provider<WebsocketMessageParser<MessengerResponse>> c;
    public final Provider<ReconnectIntervalGenerator> d;
    public final Provider<Config> e;
    public final Provider<MessengerConfigStorage> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<Logger> h;
    public final Provider<ErrorTracker> i;

    public MessengerClientModule_ProvideConnectionHolderFactory(Provider<LegacyRxWebSocket> provider, Provider<MessengerApi> provider2, Provider<WebsocketMessageParser<MessengerResponse>> provider3, Provider<ReconnectIntervalGenerator> provider4, Provider<Config> provider5, Provider<MessengerConfigStorage> provider6, Provider<SchedulersFactory> provider7, Provider<Logger> provider8, Provider<ErrorTracker> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static MessengerClientModule_ProvideConnectionHolderFactory create(Provider<LegacyRxWebSocket> provider, Provider<MessengerApi> provider2, Provider<WebsocketMessageParser<MessengerResponse>> provider3, Provider<ReconnectIntervalGenerator> provider4, Provider<Config> provider5, Provider<MessengerConfigStorage> provider6, Provider<SchedulersFactory> provider7, Provider<Logger> provider8, Provider<ErrorTracker> provider9) {
        return new MessengerClientModule_ProvideConnectionHolderFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static MessengerConnectionHolder<MessengerApi> provideConnectionHolder(LegacyRxWebSocket legacyRxWebSocket, MessengerApi messengerApi, WebsocketMessageParser<MessengerResponse> websocketMessageParser, ReconnectIntervalGenerator reconnectIntervalGenerator, Config config, MessengerConfigStorage messengerConfigStorage, SchedulersFactory schedulersFactory, Logger logger, ErrorTracker errorTracker) {
        return (MessengerConnectionHolder) Preconditions.checkNotNullFromProvides(MessengerClientModule.provideConnectionHolder(legacyRxWebSocket, messengerApi, websocketMessageParser, reconnectIntervalGenerator, config, messengerConfigStorage, schedulersFactory, logger, errorTracker));
    }

    @Override // javax.inject.Provider
    public MessengerConnectionHolder<MessengerApi> get() {
        return provideConnectionHolder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
