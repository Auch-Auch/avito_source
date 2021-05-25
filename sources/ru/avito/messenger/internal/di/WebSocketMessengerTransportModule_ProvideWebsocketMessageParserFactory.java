package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.websocket.WebsocketMessageParser;
public final class WebSocketMessengerTransportModule_ProvideWebsocketMessageParserFactory implements Factory<WebsocketMessageParser<MessengerResponse>> {
    public final WebSocketMessengerTransportModule a;
    public final Provider<Gson> b;
    public final Provider<ErrorTracker> c;

    public WebSocketMessengerTransportModule_ProvideWebsocketMessageParserFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<Gson> provider, Provider<ErrorTracker> provider2) {
        this.a = webSocketMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
    }

    public static WebSocketMessengerTransportModule_ProvideWebsocketMessageParserFactory create(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<Gson> provider, Provider<ErrorTracker> provider2) {
        return new WebSocketMessengerTransportModule_ProvideWebsocketMessageParserFactory(webSocketMessengerTransportModule, provider, provider2);
    }

    public static WebsocketMessageParser<MessengerResponse> provideWebsocketMessageParser(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Gson gson, ErrorTracker errorTracker) {
        return (WebsocketMessageParser) Preconditions.checkNotNullFromProvides(webSocketMessengerTransportModule.provideWebsocketMessageParser(gson, errorTracker));
    }

    @Override // javax.inject.Provider
    public WebsocketMessageParser<MessengerResponse> get() {
        return provideWebsocketMessageParser(this.a, this.b.get(), this.c.get());
    }
}
