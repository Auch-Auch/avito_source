package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.connection_quality.BandwidthSamplerInterceptor;
import com.avito.android.remote.interceptor.ApiAnalyticsInterceptor;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.remote.interceptor.DateInterceptor;
import com.avito.android.remote.interceptor.HeadersInterceptor;
import com.avito.android.remote.interceptor.RequestParamsInterceptor;
import com.avito.android.remote.interceptor.ServerTimeInterceptor;
import com.avito.android.remote.interceptor.SessionInterceptor;
import com.avito.android.remote.interceptor.SupportedFeaturesInterceptor;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.remote.interceptors.FirewallErrorInterceptor;
import com.avito.android.util.OkHttpInjector;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CertificatePinner;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
public final class ApiModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    public final ApiModule a;
    public final Provider<Features> b;
    public final Provider<CertificatePinner> c;
    public final Provider<SessionInterceptor> d;
    public final Provider<RequestParamsInterceptor> e;
    public final Provider<CertificatePinningInterceptor> f;
    public final Provider<DateInterceptor> g;
    public final Provider<BandwidthSamplerInterceptor> h;
    public final Provider<ServerTimeInterceptor> i;
    public final Provider<OkHttpClient> j;
    public final Provider<SupportedFeaturesInterceptor> k;
    public final Provider<UserAgentInterceptor> l;
    public final Provider<FirewallErrorInterceptor> m;
    public final Provider<ApiAnalyticsInterceptor> n;
    public final Provider<HeadersInterceptor> o;
    public final Provider<CookieJar> p;
    public final Provider<OkHttpInjector> q;

    public ApiModule_ProvideOkHttpClientFactory(ApiModule apiModule, Provider<Features> provider, Provider<CertificatePinner> provider2, Provider<SessionInterceptor> provider3, Provider<RequestParamsInterceptor> provider4, Provider<CertificatePinningInterceptor> provider5, Provider<DateInterceptor> provider6, Provider<BandwidthSamplerInterceptor> provider7, Provider<ServerTimeInterceptor> provider8, Provider<OkHttpClient> provider9, Provider<SupportedFeaturesInterceptor> provider10, Provider<UserAgentInterceptor> provider11, Provider<FirewallErrorInterceptor> provider12, Provider<ApiAnalyticsInterceptor> provider13, Provider<HeadersInterceptor> provider14, Provider<CookieJar> provider15, Provider<OkHttpInjector> provider16) {
        this.a = apiModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
    }

    public static ApiModule_ProvideOkHttpClientFactory create(ApiModule apiModule, Provider<Features> provider, Provider<CertificatePinner> provider2, Provider<SessionInterceptor> provider3, Provider<RequestParamsInterceptor> provider4, Provider<CertificatePinningInterceptor> provider5, Provider<DateInterceptor> provider6, Provider<BandwidthSamplerInterceptor> provider7, Provider<ServerTimeInterceptor> provider8, Provider<OkHttpClient> provider9, Provider<SupportedFeaturesInterceptor> provider10, Provider<UserAgentInterceptor> provider11, Provider<FirewallErrorInterceptor> provider12, Provider<ApiAnalyticsInterceptor> provider13, Provider<HeadersInterceptor> provider14, Provider<CookieJar> provider15, Provider<OkHttpInjector> provider16) {
        return new ApiModule_ProvideOkHttpClientFactory(apiModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static OkHttpClient provideOkHttpClient(ApiModule apiModule, Features features, CertificatePinner certificatePinner, SessionInterceptor sessionInterceptor, RequestParamsInterceptor requestParamsInterceptor, CertificatePinningInterceptor certificatePinningInterceptor, DateInterceptor dateInterceptor, BandwidthSamplerInterceptor bandwidthSamplerInterceptor, ServerTimeInterceptor serverTimeInterceptor, OkHttpClient okHttpClient, SupportedFeaturesInterceptor supportedFeaturesInterceptor, UserAgentInterceptor userAgentInterceptor, FirewallErrorInterceptor firewallErrorInterceptor, ApiAnalyticsInterceptor apiAnalyticsInterceptor, HeadersInterceptor headersInterceptor, CookieJar cookieJar, OkHttpInjector okHttpInjector) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(apiModule.provideOkHttpClient(features, certificatePinner, sessionInterceptor, requestParamsInterceptor, certificatePinningInterceptor, dateInterceptor, bandwidthSamplerInterceptor, serverTimeInterceptor, okHttpClient, supportedFeaturesInterceptor, userAgentInterceptor, firewallErrorInterceptor, apiAnalyticsInterceptor, headersInterceptor, cookieJar, okHttpInjector));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideOkHttpClient(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get());
    }
}
