package com.avito.android.analytics.clickstream;

import com.avito.android.util.BuildInfo;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class ClickStreamCommonSendingModule_ProvideClickStreamApiFactory implements Factory<ClickStreamApi> {
    public final Provider<BuildInfo> a;
    public final Provider<OkHttpClient> b;

    public ClickStreamCommonSendingModule_ProvideClickStreamApiFactory(Provider<BuildInfo> provider, Provider<OkHttpClient> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ClickStreamCommonSendingModule_ProvideClickStreamApiFactory create(Provider<BuildInfo> provider, Provider<OkHttpClient> provider2) {
        return new ClickStreamCommonSendingModule_ProvideClickStreamApiFactory(provider, provider2);
    }

    public static ClickStreamApi provideClickStreamApi(BuildInfo buildInfo, Lazy<OkHttpClient> lazy) {
        return (ClickStreamApi) Preconditions.checkNotNullFromProvides(ClickStreamCommonSendingModule.provideClickStreamApi(buildInfo, lazy));
    }

    @Override // javax.inject.Provider
    public ClickStreamApi get() {
        return provideClickStreamApi(this.a.get(), DoubleCheck.lazy(this.b));
    }
}
