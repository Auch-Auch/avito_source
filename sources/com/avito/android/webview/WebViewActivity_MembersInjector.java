package com.avito.android.webview;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class WebViewActivity_MembersInjector implements MembersInjector<WebViewActivity> {
    public final Provider<WebViewPresenter> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<Analytics> c;
    public final Provider<WebViewAnalyticsInteractor> d;

    public WebViewActivity_MembersInjector(Provider<WebViewPresenter> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<WebViewAnalyticsInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<WebViewActivity> create(Provider<WebViewPresenter> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<WebViewAnalyticsInteractor> provider4) {
        return new WebViewActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.webview.WebViewActivity.analytics")
    public static void injectAnalytics(WebViewActivity webViewActivity, Analytics analytics) {
        webViewActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.webview.WebViewActivity.analyticsInteractor")
    public static void injectAnalyticsInteractor(WebViewActivity webViewActivity, WebViewAnalyticsInteractor webViewAnalyticsInteractor) {
        webViewActivity.analyticsInteractor = webViewAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.webview.WebViewActivity.intentFactory")
    public static void injectIntentFactory(WebViewActivity webViewActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        webViewActivity.intentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.webview.WebViewActivity.presenter")
    public static void injectPresenter(WebViewActivity webViewActivity, WebViewPresenter webViewPresenter) {
        webViewActivity.presenter = webViewPresenter;
    }

    public void injectMembers(WebViewActivity webViewActivity) {
        injectPresenter(webViewActivity, this.a.get());
        injectIntentFactory(webViewActivity, this.b.get());
        injectAnalytics(webViewActivity, this.c.get());
        injectAnalyticsInteractor(webViewActivity, this.d.get());
    }
}
