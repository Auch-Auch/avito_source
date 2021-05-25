package ru.avito.messenger.internal.di;

import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.google.gson.JsonElement;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.internal.gson.GsonDeserializer;
import ru.avito.messenger.internal.log.Logger;
public final class HttpMessengerTransportModule_ProvideHttpMessengerApiFactory implements Factory<MessengerApi> {
    public final HttpMessengerTransportModule a;
    public final Provider<Class<? extends MessengerApi>> b;
    public final Provider<JsonRpcClient<JsonElement>> c;
    public final Provider<GsonDeserializer> d;
    public final Provider<Logger> e;

    public HttpMessengerTransportModule_ProvideHttpMessengerApiFactory(HttpMessengerTransportModule httpMessengerTransportModule, Provider<Class<? extends MessengerApi>> provider, Provider<JsonRpcClient<JsonElement>> provider2, Provider<GsonDeserializer> provider3, Provider<Logger> provider4) {
        this.a = httpMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static HttpMessengerTransportModule_ProvideHttpMessengerApiFactory create(HttpMessengerTransportModule httpMessengerTransportModule, Provider<Class<? extends MessengerApi>> provider, Provider<JsonRpcClient<JsonElement>> provider2, Provider<GsonDeserializer> provider3, Provider<Logger> provider4) {
        return new HttpMessengerTransportModule_ProvideHttpMessengerApiFactory(httpMessengerTransportModule, provider, provider2, provider3, provider4);
    }

    public static MessengerApi provideHttpMessengerApi(HttpMessengerTransportModule httpMessengerTransportModule, Class<? extends MessengerApi> cls, JsonRpcClient<JsonElement> jsonRpcClient, GsonDeserializer gsonDeserializer, Logger logger) {
        return (MessengerApi) Preconditions.checkNotNullFromProvides(httpMessengerTransportModule.provideHttpMessengerApi(cls, jsonRpcClient, gsonDeserializer, logger));
    }

    @Override // javax.inject.Provider
    public MessengerApi get() {
        return provideHttpMessengerApi(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
