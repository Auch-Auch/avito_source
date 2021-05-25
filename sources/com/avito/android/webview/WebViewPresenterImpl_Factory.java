package com.avito.android.webview;

import android.net.Uri;
import android.webkit.CookieManager;
import com.avito.android.CalledFrom;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WebViewPresenterImpl_Factory implements Factory<WebViewPresenterImpl> {
    public final Provider<DeepLinkFactory> a;
    public final Provider<Uri> b;
    public final Provider<Boolean> c;
    public final Provider<Boolean> d;
    public final Provider<CalledFrom> e;
    public final Provider<CookieManager> f;
    public final Provider<CookieProvider> g;
    public final Provider<WebViewAnalyticsInteractor> h;

    public WebViewPresenterImpl_Factory(Provider<DeepLinkFactory> provider, Provider<Uri> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<CalledFrom> provider5, Provider<CookieManager> provider6, Provider<CookieProvider> provider7, Provider<WebViewAnalyticsInteractor> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static WebViewPresenterImpl_Factory create(Provider<DeepLinkFactory> provider, Provider<Uri> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<CalledFrom> provider5, Provider<CookieManager> provider6, Provider<CookieProvider> provider7, Provider<WebViewAnalyticsInteractor> provider8) {
        return new WebViewPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static WebViewPresenterImpl newInstance(DeepLinkFactory deepLinkFactory, Uri uri, boolean z, boolean z2, CalledFrom calledFrom, CookieManager cookieManager, CookieProvider cookieProvider, WebViewAnalyticsInteractor webViewAnalyticsInteractor) {
        return new WebViewPresenterImpl(deepLinkFactory, uri, z, z2, calledFrom, cookieManager, cookieProvider, webViewAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public WebViewPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get().booleanValue(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
