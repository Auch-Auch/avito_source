package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class ep extends WebViewClient {
    private final eq a;

    public ep(@NonNull eq eqVar) {
        this.a = eqVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.d();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
        this.a.a(webView.getContext(), str);
        return true;
    }
}
