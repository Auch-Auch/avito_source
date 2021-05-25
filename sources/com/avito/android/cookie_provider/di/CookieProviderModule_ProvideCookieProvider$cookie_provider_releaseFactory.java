package com.avito.android.cookie_provider.di;

import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.GeoHeaderProvider;
import com.avito.android.remote.interceptor.SessionHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory implements Factory<CookieProvider> {
    public final Provider<GeoHeaderProvider> a;
    public final Provider<SessionHeaderProvider> b;
    public final Provider<DateHeaderProvider> c;
    public final Provider<DeviceIdHeaderProvider> d;
    public final Provider<SupportFeaturesHeaderProvider> e;
    public final Provider<UserAgentHeaderProvider> f;
    public final Provider<CookieExpiredTime> g;

    public CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory(Provider<GeoHeaderProvider> provider, Provider<SessionHeaderProvider> provider2, Provider<DateHeaderProvider> provider3, Provider<DeviceIdHeaderProvider> provider4, Provider<SupportFeaturesHeaderProvider> provider5, Provider<UserAgentHeaderProvider> provider6, Provider<CookieExpiredTime> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory create(Provider<GeoHeaderProvider> provider, Provider<SessionHeaderProvider> provider2, Provider<DateHeaderProvider> provider3, Provider<DeviceIdHeaderProvider> provider4, Provider<SupportFeaturesHeaderProvider> provider5, Provider<UserAgentHeaderProvider> provider6, Provider<CookieExpiredTime> provider7) {
        return new CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CookieProvider provideCookieProvider$cookie_provider_release(GeoHeaderProvider geoHeaderProvider, SessionHeaderProvider sessionHeaderProvider, DateHeaderProvider dateHeaderProvider, DeviceIdHeaderProvider deviceIdHeaderProvider, SupportFeaturesHeaderProvider supportFeaturesHeaderProvider, UserAgentHeaderProvider userAgentHeaderProvider, CookieExpiredTime cookieExpiredTime) {
        return (CookieProvider) Preconditions.checkNotNullFromProvides(CookieProviderModule.provideCookieProvider$cookie_provider_release(geoHeaderProvider, sessionHeaderProvider, dateHeaderProvider, deviceIdHeaderProvider, supportFeaturesHeaderProvider, userAgentHeaderProvider, cookieExpiredTime));
    }

    @Override // javax.inject.Provider
    public CookieProvider get() {
        return provideCookieProvider$cookie_provider_release(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
