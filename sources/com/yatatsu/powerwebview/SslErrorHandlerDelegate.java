package com.yatatsu.powerwebview;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yatatsu/powerwebview/SslErrorHandlerDelegate;", "", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "sslError", "", "onReceivedSslError", "(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
public interface SslErrorHandlerDelegate {
    void onReceivedSslError(@NotNull WebView webView, @NotNull SslErrorHandler sslErrorHandler, @NotNull SslError sslError);
}
