package ru.avito.messenger.internal.di;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.websocket.RequestProvider;
import ru.avito.websocket.WebSocketFactory;
public final class WebSocketMessengerTransportModule_ProvideWebSocketFactoryFactory implements Factory<WebSocketFactory> {
    public final WebSocketMessengerTransportModule a;
    public final Provider<OkHttpClient> b;
    public final Provider<RequestProvider> c;

    public WebSocketMessengerTransportModule_ProvideWebSocketFactoryFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<OkHttpClient> provider, Provider<RequestProvider> provider2) {
        this.a = webSocketMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
    }

    public static WebSocketMessengerTransportModule_ProvideWebSocketFactoryFactory create(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<OkHttpClient> provider, Provider<RequestProvider> provider2) {
        return new WebSocketMessengerTransportModule_ProvideWebSocketFactoryFactory(webSocketMessengerTransportModule, provider, provider2);
    }

    public static WebSocketFactory provideWebSocketFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Lazy<OkHttpClient> lazy, RequestProvider requestProvider) {
        return (WebSocketFactory) Preconditions.checkNotNullFromProvides(webSocketMessengerTransportModule.provideWebSocketFactory(lazy, requestProvider));
    }

    @Override // javax.inject.Provider
    public WebSocketFactory get() {
        return provideWebSocketFactory(this.a, DoubleCheck.lazy(this.b), this.c.get());
    }
}
