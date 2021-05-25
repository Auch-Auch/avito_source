package com.avito.android.imv;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.webview.WebViewPresenter;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ImvWebViewBottomSheetActivity_MembersInjector implements MembersInjector<ImvWebViewBottomSheetActivity> {
    public final Provider<WebViewPresenter> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<Analytics> c;
    public final Provider<WebViewAnalyticsInteractor> d;

    public ImvWebViewBottomSheetActivity_MembersInjector(Provider<WebViewPresenter> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<WebViewAnalyticsInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ImvWebViewBottomSheetActivity> create(Provider<WebViewPresenter> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<WebViewAnalyticsInteractor> provider4) {
        return new ImvWebViewBottomSheetActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.imv.ImvWebViewBottomSheetActivity.analytics")
    public static void injectAnalytics(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity, Analytics analytics) {
        imvWebViewBottomSheetActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.imv.ImvWebViewBottomSheetActivity.analyticsInteractor")
    public static void injectAnalyticsInteractor(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity, WebViewAnalyticsInteractor webViewAnalyticsInteractor) {
        imvWebViewBottomSheetActivity.analyticsInteractor = webViewAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.imv.ImvWebViewBottomSheetActivity.intentFactory")
    public static void injectIntentFactory(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        imvWebViewBottomSheetActivity.intentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.imv.ImvWebViewBottomSheetActivity.presenter")
    public static void injectPresenter(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity, WebViewPresenter webViewPresenter) {
        imvWebViewBottomSheetActivity.presenter = webViewPresenter;
    }

    public void injectMembers(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity) {
        injectPresenter(imvWebViewBottomSheetActivity, this.a.get());
        injectIntentFactory(imvWebViewBottomSheetActivity, this.b.get());
        injectAnalytics(imvWebViewBottomSheetActivity, this.c.get());
        injectAnalyticsInteractor(imvWebViewBottomSheetActivity, this.d.get());
    }
}
