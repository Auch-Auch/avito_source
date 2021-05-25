package com.avito.android.analytics.inhouse_transport;

import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class InHouseCommonSendingModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
    public final Provider<BuildInfo> a;

    public InHouseCommonSendingModule_ProvideHttpClientFactory(Provider<BuildInfo> provider) {
        this.a = provider;
    }

    public static InHouseCommonSendingModule_ProvideHttpClientFactory create(Provider<BuildInfo> provider) {
        return new InHouseCommonSendingModule_ProvideHttpClientFactory(provider);
    }

    public static OkHttpClient provideHttpClient(BuildInfo buildInfo) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(InHouseCommonSendingModule.provideHttpClient(buildInfo));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideHttpClient(this.a.get());
    }
}
