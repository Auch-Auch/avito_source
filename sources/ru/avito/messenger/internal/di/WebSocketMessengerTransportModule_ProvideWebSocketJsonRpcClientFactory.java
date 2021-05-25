package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.WebsocketMessageParser;
public final class WebSocketMessengerTransportModule_ProvideWebSocketJsonRpcClientFactory implements Factory<JsonRpcClient<JsonElement>> {
    public final WebSocketMessengerTransportModule a;
    public final Provider<LegacyRxWebSocket> b;
    public final Provider<WebsocketMessageParser<MessengerResponse>> c;
    public final Provider<Gson> d;
    public final Provider<Config> e;
    public final Provider<Logger> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<ErrorTracker> h;

    public WebSocketMessengerTransportModule_ProvideWebSocketJsonRpcClientFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<LegacyRxWebSocket> provider, Provider<WebsocketMessageParser<MessengerResponse>> provider2, Provider<Gson> provider3, Provider<Config> provider4, Provider<Logger> provider5, Provider<SchedulersFactory> provider6, Provider<ErrorTracker> provider7) {
        this.a = webSocketMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static WebSocketMessengerTransportModule_ProvideWebSocketJsonRpcClientFactory create(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<LegacyRxWebSocket> provider, Provider<WebsocketMessageParser<MessengerResponse>> provider2, Provider<Gson> provider3, Provider<Config> provider4, Provider<Logger> provider5, Provider<SchedulersFactory> provider6, Provider<ErrorTracker> provider7) {
        return new WebSocketMessengerTransportModule_ProvideWebSocketJsonRpcClientFactory(webSocketMessengerTransportModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static JsonRpcClient<JsonElement> provideWebSocketJsonRpcClient(WebSocketMessengerTransportModule webSocketMessengerTransportModule, LegacyRxWebSocket legacyRxWebSocket, WebsocketMessageParser<MessengerResponse> websocketMessageParser, Gson gson, Config config, Logger logger, SchedulersFactory schedulersFactory, ErrorTracker errorTracker) {
        return (JsonRpcClient) Preconditions.checkNotNullFromProvides(webSocketMessengerTransportModule.provideWebSocketJsonRpcClient(legacyRxWebSocket, websocketMessageParser, gson, config, logger, schedulersFactory, errorTracker));
    }

    @Override // javax.inject.Provider
    public JsonRpcClient<JsonElement> get() {
        return provideWebSocketJsonRpcClient(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
