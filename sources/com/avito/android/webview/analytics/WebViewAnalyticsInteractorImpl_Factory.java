package com.avito.android.webview.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WebViewAnalyticsInteractorImpl_Factory implements Factory<WebViewAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public WebViewAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static WebViewAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new WebViewAnalyticsInteractorImpl_Factory(provider);
    }

    public static WebViewAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new WebViewAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public WebViewAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
