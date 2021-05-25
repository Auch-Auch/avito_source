package com.avito.android.di.module;

import com.avito.android.util.OkHttpInjector;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class AvitoAnalyticsModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    public final AvitoAnalyticsModule a;
    public final Provider<OkHttpClient> b;
    public final Provider<OkHttpInjector> c;

    public AvitoAnalyticsModule_ProvideOkHttpClientFactory(AvitoAnalyticsModule avitoAnalyticsModule, Provider<OkHttpClient> provider, Provider<OkHttpInjector> provider2) {
        this.a = avitoAnalyticsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static AvitoAnalyticsModule_ProvideOkHttpClientFactory create(AvitoAnalyticsModule avitoAnalyticsModule, Provider<OkHttpClient> provider, Provider<OkHttpInjector> provider2) {
        return new AvitoAnalyticsModule_ProvideOkHttpClientFactory(avitoAnalyticsModule, provider, provider2);
    }

    public static OkHttpClient provideOkHttpClient(AvitoAnalyticsModule avitoAnalyticsModule, Lazy<OkHttpClient> lazy, OkHttpInjector okHttpInjector) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(avitoAnalyticsModule.provideOkHttpClient(lazy, okHttpInjector));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideOkHttpClient(this.a, DoubleCheck.lazy(this.b), this.c.get());
    }
}
