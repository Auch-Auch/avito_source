package com.avito.android.payment.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/payment/webview/PaymentWebViewStateWatcherImpl;", "Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", "Landroid/webkit/WebView;", "webView", "", "url", "Landroid/graphics/Bitmap;", "favicon", "", "onStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "", "newProgress", "onProgressChanged", "(Landroid/webkit/WebView;I)V", CommonKt.TAG_ERROR_CODE, "description", "failingUrl", "onError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "sslError", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentWebViewStateWatcherImpl implements PaymentWebViewStateWatcher {
    public final Analytics a;

    public PaymentWebViewStateWatcherImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.yatatsu.powerwebview.LoadStateWatcher
    public void onError(@NotNull WebView webView, int i, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Analytics analytics = this.a;
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        String userAgentString = settings.getUserAgentString();
        Intrinsics.checkNotNullExpressionValue(userAgentString, "webView.settings.userAgentString");
        analytics.track(new PaymentWebViewErrorEvent(i, str, userAgentString, str2));
    }

    @Override // com.yatatsu.powerwebview.LoadStateWatcher
    public void onFinished(@NotNull WebView webView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.yatatsu.powerwebview.LoadStateWatcher
    public void onProgressChanged(@NotNull WebView webView, int i) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.yatatsu.powerwebview.SslErrorHandlerDelegate
    public void onReceivedSslError(@NotNull WebView webView, @NotNull SslErrorHandler sslErrorHandler, @NotNull SslError sslError) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(sslErrorHandler, "handler");
        Intrinsics.checkNotNullParameter(sslError, "sslError");
        Analytics analytics = this.a;
        int primaryError = sslError.getPrimaryError();
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        String userAgentString = settings.getUserAgentString();
        Intrinsics.checkNotNullExpressionValue(userAgentString, "webView.settings.userAgentString");
        analytics.track(new PaymentWebViewErrorEvent(primaryError, "SSL error", userAgentString, sslError.getUrl()));
    }

    @Override // com.yatatsu.powerwebview.LoadStateWatcher
    public void onStarted(@NotNull WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }
}
