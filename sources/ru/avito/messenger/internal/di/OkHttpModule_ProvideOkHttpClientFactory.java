package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.messenger.internal.Config;
public final class OkHttpModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    public final OkHttpModule a;
    public final Provider<Config> b;

    public OkHttpModule_ProvideOkHttpClientFactory(OkHttpModule okHttpModule, Provider<Config> provider) {
        this.a = okHttpModule;
        this.b = provider;
    }

    public static OkHttpModule_ProvideOkHttpClientFactory create(OkHttpModule okHttpModule, Provider<Config> provider) {
        return new OkHttpModule_ProvideOkHttpClientFactory(okHttpModule, provider);
    }

    public static OkHttpClient provideOkHttpClient(OkHttpModule okHttpModule, Config config) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(okHttpModule.provideOkHttpClient(config));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideOkHttpClient(this.a, this.b.get());
    }
}
