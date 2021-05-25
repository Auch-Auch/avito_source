package ru.avito.messenger.internal.di;

import com.google.gson.Gson;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.jsonrpc.HttpApi;
public final class HttpMessengerTransportModule_ProvideHttpApiFactory implements Factory<HttpApi> {
    public final HttpMessengerTransportModule a;
    public final Provider<OkHttpClient> b;
    public final Provider<Gson> c;
    public final Provider<Config> d;

    public HttpMessengerTransportModule_ProvideHttpApiFactory(HttpMessengerTransportModule httpMessengerTransportModule, Provider<OkHttpClient> provider, Provider<Gson> provider2, Provider<Config> provider3) {
        this.a = httpMessengerTransportModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static HttpMessengerTransportModule_ProvideHttpApiFactory create(HttpMessengerTransportModule httpMessengerTransportModule, Provider<OkHttpClient> provider, Provider<Gson> provider2, Provider<Config> provider3) {
        return new HttpMessengerTransportModule_ProvideHttpApiFactory(httpMessengerTransportModule, provider, provider2, provider3);
    }

    public static HttpApi provideHttpApi(HttpMessengerTransportModule httpMessengerTransportModule, Lazy<OkHttpClient> lazy, Gson gson, Config config) {
        return (HttpApi) Preconditions.checkNotNullFromProvides(httpMessengerTransportModule.provideHttpApi(lazy, gson, config));
    }

    @Override // javax.inject.Provider
    public HttpApi get() {
        return provideHttpApi(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get());
    }
}
