package com.avito.android.analytics.inhouse_transport;

import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
public final class InHouseCommonSendingModule_ProvideInHouseGzipHttpClientFactory implements Factory<OkHttpClient> {
    public final Provider<BuildInfo> a;
    public final Provider<Set<Interceptor>> b;

    public InHouseCommonSendingModule_ProvideInHouseGzipHttpClientFactory(Provider<BuildInfo> provider, Provider<Set<Interceptor>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InHouseCommonSendingModule_ProvideInHouseGzipHttpClientFactory create(Provider<BuildInfo> provider, Provider<Set<Interceptor>> provider2) {
        return new InHouseCommonSendingModule_ProvideInHouseGzipHttpClientFactory(provider, provider2);
    }

    public static OkHttpClient provideInHouseGzipHttpClient(BuildInfo buildInfo, Set<Interceptor> set) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(InHouseCommonSendingModule.provideInHouseGzipHttpClient(buildInfo, set));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideInHouseGzipHttpClient(this.a.get(), this.b.get());
    }
}
