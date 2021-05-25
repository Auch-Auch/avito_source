package com.avito.android.webview.di;

import android.webkit.CookieManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class WebViewModule_ProvideCookieManager$webview_releaseFactory implements Factory<CookieManager> {

    public static final class a {
        public static final WebViewModule_ProvideCookieManager$webview_releaseFactory a = new WebViewModule_ProvideCookieManager$webview_releaseFactory();
    }

    public static WebViewModule_ProvideCookieManager$webview_releaseFactory create() {
        return a.a;
    }

    public static CookieManager provideCookieManager$webview_release() {
        return (CookieManager) Preconditions.checkNotNullFromProvides(WebViewModule.provideCookieManager$webview_release());
    }

    @Override // javax.inject.Provider
    public CookieManager get() {
        return provideCookieManager$webview_release();
    }
}
