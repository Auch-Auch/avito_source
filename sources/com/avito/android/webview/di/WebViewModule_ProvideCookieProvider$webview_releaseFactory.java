package com.avito.android.webview.di;

import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.remote.interceptor.SessionCookieProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WebViewModule_ProvideCookieProvider$webview_releaseFactory implements Factory<CookieProvider> {
    public final Provider<SessionCookieProvider> a;
    public final Provider<CookieExpiredTime> b;

    public WebViewModule_ProvideCookieProvider$webview_releaseFactory(Provider<SessionCookieProvider> provider, Provider<CookieExpiredTime> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static WebViewModule_ProvideCookieProvider$webview_releaseFactory create(Provider<SessionCookieProvider> provider, Provider<CookieExpiredTime> provider2) {
        return new WebViewModule_ProvideCookieProvider$webview_releaseFactory(provider, provider2);
    }

    public static CookieProvider provideCookieProvider$webview_release(SessionCookieProvider sessionCookieProvider, CookieExpiredTime cookieExpiredTime) {
        return (CookieProvider) Preconditions.checkNotNullFromProvides(WebViewModule.provideCookieProvider$webview_release(sessionCookieProvider, cookieExpiredTime));
    }

    @Override // javax.inject.Provider
    public CookieProvider get() {
        return provideCookieProvider$webview_release(this.a.get(), this.b.get());
    }
}
