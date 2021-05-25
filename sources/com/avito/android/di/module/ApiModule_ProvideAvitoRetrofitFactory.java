package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.util.BuildInfo;
import com.google.gson.Gson;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
public final class ApiModule_ProvideAvitoRetrofitFactory implements Factory<Retrofit> {
    public final ApiModule a;
    public final Provider<Features> b;
    public final Provider<Gson> c;
    public final Provider<Analytics> d;
    public final Provider<GraphitePrefix> e;
    public final Provider<BuildInfo> f;
    public final Provider<OkHttpClient> g;
    public final Provider<Gson> h;
    public final Provider<CallAdapter.Factory> i;

    public ApiModule_ProvideAvitoRetrofitFactory(ApiModule apiModule, Provider<Features> provider, Provider<Gson> provider2, Provider<Analytics> provider3, Provider<GraphitePrefix> provider4, Provider<BuildInfo> provider5, Provider<OkHttpClient> provider6, Provider<Gson> provider7, Provider<CallAdapter.Factory> provider8) {
        this.a = apiModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
    }

    public static ApiModule_ProvideAvitoRetrofitFactory create(ApiModule apiModule, Provider<Features> provider, Provider<Gson> provider2, Provider<Analytics> provider3, Provider<GraphitePrefix> provider4, Provider<BuildInfo> provider5, Provider<OkHttpClient> provider6, Provider<Gson> provider7, Provider<CallAdapter.Factory> provider8) {
        return new ApiModule_ProvideAvitoRetrofitFactory(apiModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Retrofit provideAvitoRetrofit(ApiModule apiModule, Features features, Gson gson, Analytics analytics, GraphitePrefix graphitePrefix, BuildInfo buildInfo, Lazy<OkHttpClient> lazy, Gson gson2, CallAdapter.Factory factory) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(apiModule.provideAvitoRetrofit(features, gson, analytics, graphitePrefix, buildInfo, lazy, gson2, factory));
    }

    @Override // javax.inject.Provider
    public Retrofit get() {
        return provideAvitoRetrofit(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), DoubleCheck.lazy(this.g), this.h.get(), this.i.get());
    }
}
