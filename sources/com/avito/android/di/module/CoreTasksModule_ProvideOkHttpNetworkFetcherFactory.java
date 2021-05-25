package com.avito.android.di.module;

import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class CoreTasksModule_ProvideOkHttpNetworkFetcherFactory implements Factory<OkHttpNetworkFetcher> {
    public final Provider<OkHttpClient> a;

    public CoreTasksModule_ProvideOkHttpNetworkFetcherFactory(Provider<OkHttpClient> provider) {
        this.a = provider;
    }

    public static CoreTasksModule_ProvideOkHttpNetworkFetcherFactory create(Provider<OkHttpClient> provider) {
        return new CoreTasksModule_ProvideOkHttpNetworkFetcherFactory(provider);
    }

    public static OkHttpNetworkFetcher provideOkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        return (OkHttpNetworkFetcher) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideOkHttpNetworkFetcher(okHttpClient));
    }

    @Override // javax.inject.Provider
    public OkHttpNetworkFetcher get() {
        return provideOkHttpNetworkFetcher(this.a.get());
    }
}
