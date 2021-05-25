package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.RequestIdGenerator;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.RequestProvider;
public final class WebSocketMessengerTransportModule_ProvideRequestBuilderFactory implements Factory<RequestProvider> {
    public final WebSocketMessengerTransportModule a;
    public final Provider<Config> b;
    public final Provider<Logger> c;
    public final Provider<RequestIdGenerator> d;

    public WebSocketMessengerTransportModule_ProvideRequestBuilderFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<Config> provider, Provider<Logger> provider2, Provider<RequestIdGenerator> provider3) {
        this.a = webSocketMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static WebSocketMessengerTransportModule_ProvideRequestBuilderFactory create(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<Config> provider, Provider<Logger> provider2, Provider<RequestIdGenerator> provider3) {
        return new WebSocketMessengerTransportModule_ProvideRequestBuilderFactory(webSocketMessengerTransportModule, provider, provider2, provider3);
    }

    public static RequestProvider provideRequestBuilder(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Config config, Logger logger, RequestIdGenerator requestIdGenerator) {
        return (RequestProvider) Preconditions.checkNotNullFromProvides(webSocketMessengerTransportModule.provideRequestBuilder(config, logger, requestIdGenerator));
    }

    @Override // javax.inject.Provider
    public RequestProvider get() {
        return provideRequestBuilder(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
