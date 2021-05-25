package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
public final class q extends ac {

    public final class a extends WebChromeClient {
        private final WeakReference<Context> b;

        public a(Context context) {
            this.b = new WeakReference<>(context);
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i) {
            c a3 = q.a(this.b);
            if (a3 != null) {
                a3.a(webView, i);
            }
        }
    }

    public final class b extends WebViewClient {
        private final WeakReference<Context> b;

        public b(Context context) {
            this.b = new WeakReference<>(context);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c a3 = q.a(this.b);
            if (a3 != null) {
                a3.i();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            c a3 = q.a(this.b);
            if (a3 != null) {
                a3.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str) || (!ee.b(str) && ee.c(str))) {
                return false;
            }
            return ee.a(webView.getContext(), str, false);
        }
    }

    public interface c {
        void a(WebView webView, int i);

        void h();

        void i();
    }

    public q(Context context) {
        super(context);
        a_(context);
    }

    public static c a(WeakReference<Context> weakReference) {
        if (weakReference.get() instanceof c) {
            return (c) weakReference.get();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.ac
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a_(Context context) {
        super.a_(context);
        setBackgroundColor(-1);
        setInitialScale(1);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        b_();
        setScrollbarFadingEnabled(true);
        setDrawingCacheEnabled(true);
        setWebChromeClient(new a(context));
        setWebViewClient(new b(context));
    }
}
