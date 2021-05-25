package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
public final class fe extends ep {
    @Nullable
    private String a;

    public fe(@NonNull eq eqVar) {
        super(eqVar);
    }

    @RequiresApi(api = 11)
    private static WebResourceResponse b(@NonNull String str) {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(str.getBytes()));
    }

    public final void a(@NonNull String str) {
        this.a = str;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(@NonNull WebView webView, @NonNull String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    private static boolean a(@NonNull Uri uri) {
        return "mraid.js".equals(uri.getLastPathSegment());
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public final WebResourceResponse shouldInterceptRequest(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        Uri url;
        if (TextUtils.isEmpty(this.a) || (url = webResourceRequest.getUrl()) == null || !a(url)) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return b(this.a);
    }
}
