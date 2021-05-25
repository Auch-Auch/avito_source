package com.avito.android.payment.webview;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class WebPaymentActivity_MembersInjector implements MembersInjector<WebPaymentActivity> {
    public final Provider<WebPaymentPresenter> a;
    public final Provider<WebViewStatePresenter> b;
    public final Provider<DialogRouter> c;
    public final Provider<Analytics> d;

    public WebPaymentActivity_MembersInjector(Provider<WebPaymentPresenter> provider, Provider<WebViewStatePresenter> provider2, Provider<DialogRouter> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<WebPaymentActivity> create(Provider<WebPaymentPresenter> provider, Provider<WebViewStatePresenter> provider2, Provider<DialogRouter> provider3, Provider<Analytics> provider4) {
        return new WebPaymentActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.payment.webview.WebPaymentActivity.analytics")
    public static void injectAnalytics(WebPaymentActivity webPaymentActivity, Analytics analytics) {
        webPaymentActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.payment.webview.WebPaymentActivity.dialogRouter")
    public static void injectDialogRouter(WebPaymentActivity webPaymentActivity, DialogRouter dialogRouter) {
        webPaymentActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.payment.webview.WebPaymentActivity.presenter")
    public static void injectPresenter(WebPaymentActivity webPaymentActivity, WebPaymentPresenter webPaymentPresenter) {
        webPaymentActivity.presenter = webPaymentPresenter;
    }

    @InjectedFieldSignature("com.avito.android.payment.webview.WebPaymentActivity.webViewPresenterState")
    public static void injectWebViewPresenterState(WebPaymentActivity webPaymentActivity, WebViewStatePresenter webViewStatePresenter) {
        webPaymentActivity.webViewPresenterState = webViewStatePresenter;
    }

    public void injectMembers(WebPaymentActivity webPaymentActivity) {
        injectPresenter(webPaymentActivity, this.a.get());
        injectWebViewPresenterState(webPaymentActivity, this.b.get());
        injectDialogRouter(webPaymentActivity, this.c.get());
        injectAnalytics(webPaymentActivity, this.d.get());
    }
}
