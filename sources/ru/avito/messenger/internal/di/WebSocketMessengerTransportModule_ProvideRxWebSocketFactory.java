package ru.avito.messenger.internal.di;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.WebSocketFactory;
public final class WebSocketMessengerTransportModule_ProvideRxWebSocketFactory implements Factory<LegacyRxWebSocket> {
    public final WebSocketMessengerTransportModule a;
    public final Provider<WebSocketFactory> b;
    public final Provider<Logger> c;
    public final Provider<Config> d;
    public final Provider<SchedulersFactory> e;

    public WebSocketMessengerTransportModule_ProvideRxWebSocketFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<WebSocketFactory> provider, Provider<Logger> provider2, Provider<Config> provider3, Provider<SchedulersFactory> provider4) {
        this.a = webSocketMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static WebSocketMessengerTransportModule_ProvideRxWebSocketFactory create(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<WebSocketFactory> provider, Provider<Logger> provider2, Provider<Config> provider3, Provider<SchedulersFactory> provider4) {
        return new WebSocketMessengerTransportModule_ProvideRxWebSocketFactory(webSocketMessengerTransportModule, provider, provider2, provider3, provider4);
    }

    public static LegacyRxWebSocket provideRxWebSocket(WebSocketMessengerTransportModule webSocketMessengerTransportModule, WebSocketFactory webSocketFactory, Logger logger, Config config, SchedulersFactory schedulersFactory) {
        return (LegacyRxWebSocket) Preconditions.checkNotNullFromProvides(webSocketMessengerTransportModule.provideRxWebSocket(webSocketFactory, logger, config, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public LegacyRxWebSocket get() {
        return provideRxWebSocket(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
