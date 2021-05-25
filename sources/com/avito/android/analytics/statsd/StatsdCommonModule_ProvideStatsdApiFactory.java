package com.avito.android.analytics.statsd;

import com.avito.android.StatsdToggles;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class StatsdCommonModule_ProvideStatsdApiFactory implements Factory<StatsdApi> {
    public final Provider<StatsdToggles> a;
    public final Provider<BuildInfo> b;
    public final Provider<OkHttpClient> c;
    public final Provider<OkHttpClient> d;

    public StatsdCommonModule_ProvideStatsdApiFactory(Provider<StatsdToggles> provider, Provider<BuildInfo> provider2, Provider<OkHttpClient> provider3, Provider<OkHttpClient> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static StatsdCommonModule_ProvideStatsdApiFactory create(Provider<StatsdToggles> provider, Provider<BuildInfo> provider2, Provider<OkHttpClient> provider3, Provider<OkHttpClient> provider4) {
        return new StatsdCommonModule_ProvideStatsdApiFactory(provider, provider2, provider3, provider4);
    }

    public static StatsdApi provideStatsdApi(StatsdToggles statsdToggles, BuildInfo buildInfo, OkHttpClient okHttpClient, OkHttpClient okHttpClient2) {
        return (StatsdApi) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideStatsdApi(statsdToggles, buildInfo, okHttpClient, okHttpClient2));
    }

    @Override // javax.inject.Provider
    public StatsdApi get() {
        return provideStatsdApi(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
