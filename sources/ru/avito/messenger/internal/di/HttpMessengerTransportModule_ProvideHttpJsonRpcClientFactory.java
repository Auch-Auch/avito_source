package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.JsonElement;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.jsonrpc.HttpApi;
import ru.avito.messenger.internal.log.Logger;
public final class HttpMessengerTransportModule_ProvideHttpJsonRpcClientFactory implements Factory<JsonRpcClient<JsonElement>> {
    public final HttpMessengerTransportModule a;
    public final Provider<HttpApi> b;
    public final Provider<Config> c;
    public final Provider<Logger> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<ErrorTracker> f;

    public HttpMessengerTransportModule_ProvideHttpJsonRpcClientFactory(HttpMessengerTransportModule httpMessengerTransportModule, Provider<HttpApi> provider, Provider<Config> provider2, Provider<Logger> provider3, Provider<SchedulersFactory> provider4, Provider<ErrorTracker> provider5) {
        this.a = httpMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static HttpMessengerTransportModule_ProvideHttpJsonRpcClientFactory create(HttpMessengerTransportModule httpMessengerTransportModule, Provider<HttpApi> provider, Provider<Config> provider2, Provider<Logger> provider3, Provider<SchedulersFactory> provider4, Provider<ErrorTracker> provider5) {
        return new HttpMessengerTransportModule_ProvideHttpJsonRpcClientFactory(httpMessengerTransportModule, provider, provider2, provider3, provider4, provider5);
    }

    public static JsonRpcClient<JsonElement> provideHttpJsonRpcClient(HttpMessengerTransportModule httpMessengerTransportModule, HttpApi httpApi, Config config, Logger logger, SchedulersFactory schedulersFactory, ErrorTracker errorTracker) {
        return (JsonRpcClient) Preconditions.checkNotNullFromProvides(httpMessengerTransportModule.provideHttpJsonRpcClient(httpApi, config, logger, schedulersFactory, errorTracker));
    }

    @Override // javax.inject.Provider
    public JsonRpcClient<JsonElement> get() {
        return provideHttpJsonRpcClient(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
