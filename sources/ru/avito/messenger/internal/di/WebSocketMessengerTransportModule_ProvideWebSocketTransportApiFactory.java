package ru.avito.messenger.internal.di;

import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.google.gson.JsonElement;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.internal.gson.GsonDeserializer;
import ru.avito.messenger.internal.jsonrpc.JsonRpcCallAnalyticsInterceptor;
import ru.avito.messenger.internal.log.Logger;
public final class WebSocketMessengerTransportModule_ProvideWebSocketTransportApiFactory implements Factory<MessengerApi> {
    public final WebSocketMessengerTransportModule a;
    public final Provider<JsonRpcClient<JsonElement>> b;
    public final Provider<GsonDeserializer> c;
    public final Provider<Logger> d;
    public final Provider<Class<? extends MessengerApi>> e;
    public final Provider<JsonRpcCallAnalyticsInterceptor> f;

    public WebSocketMessengerTransportModule_ProvideWebSocketTransportApiFactory(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<JsonRpcClient<JsonElement>> provider, Provider<GsonDeserializer> provider2, Provider<Logger> provider3, Provider<Class<? extends MessengerApi>> provider4, Provider<JsonRpcCallAnalyticsInterceptor> provider5) {
        this.a = webSocketMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static WebSocketMessengerTransportModule_ProvideWebSocketTransportApiFactory create(WebSocketMessengerTransportModule webSocketMessengerTransportModule, Provider<JsonRpcClient<JsonElement>> provider, Provider<GsonDeserializer> provider2, Provider<Logger> provider3, Provider<Class<? extends MessengerApi>> provider4, Provider<JsonRpcCallAnalyticsInterceptor> provider5) {
        return new WebSocketMessengerTransportModule_ProvideWebSocketTransportApiFactory(webSocketMessengerTransportModule, provider, provider2, provider3, provider4, provider5);
    }

    public static MessengerApi provideWebSocketTransportApi(WebSocketMessengerTransportModule webSocketMessengerTransportModule, JsonRpcClient<JsonElement> jsonRpcClient, GsonDeserializer gsonDeserializer, Logger logger, Class<? extends MessengerApi> cls, JsonRpcCallAnalyticsInterceptor jsonRpcCallAnalyticsInterceptor) {
        return (MessengerApi) Preconditions.checkNotNullFromProvides(webSocketMessengerTransportModule.provideWebSocketTransportApi(jsonRpcClient, gsonDeserializer, logger, cls, jsonRpcCallAnalyticsInterceptor));
    }

    @Override // javax.inject.Provider
    public MessengerApi get() {
        return provideWebSocketTransportApi(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
