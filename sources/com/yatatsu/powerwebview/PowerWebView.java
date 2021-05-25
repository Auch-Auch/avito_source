package com.yatatsu.powerwebview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.ConsoleMessage;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001d0B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bA\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00101R\u001c\u00108\u001a\u0002058\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u001d\u00106\u0012\u0004\b7\u0010\u000eR$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/yatatsu/powerwebview/PowerWebView;", "Landroid/webkit/WebView;", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "Lcom/yatatsu/powerwebview/LoadStateWatcher;", "watcher", "addLoadStateWatcher", "(Lcom/yatatsu/powerwebview/LoadStateWatcher;)V", "removeLoadStateWatcher", "destroy", "()V", "", "url", "loadUrl", "(Ljava/lang/String;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "intercept$powerwebview_release", "(Landroid/net/Uri;)Z", "intercept", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/yatatsu/powerwebview/SslErrorHandlerDelegate;", "d", "Lcom/yatatsu/powerwebview/SslErrorHandlerDelegate;", "getSslErrorHandlerDelegate", "()Lcom/yatatsu/powerwebview/SslErrorHandlerDelegate;", "setSslErrorHandlerDelegate", "(Lcom/yatatsu/powerwebview/SslErrorHandlerDelegate;)V", "sslErrorHandlerDelegate", "Lcom/yatatsu/powerwebview/HttpErrorHandlerDelegate;", "f", "Lcom/yatatsu/powerwebview/HttpErrorHandlerDelegate;", "getHttpErrorHandlerDelegate", "()Lcom/yatatsu/powerwebview/HttpErrorHandlerDelegate;", "setHttpErrorHandlerDelegate", "(Lcom/yatatsu/powerwebview/HttpErrorHandlerDelegate;)V", "httpErrorHandlerDelegate", "Ljava/util/concurrent/CopyOnWriteArrayList;", AuthSource.BOOKING_ORDER, "Ljava/util/concurrent/CopyOnWriteArrayList;", "loadStateWatchers", "c", "interceptors", "", "I", "getPowerWebViewState$annotations", "powerWebViewState", "Lcom/yatatsu/powerwebview/HttpAuthHandlerDelegate;", "e", "Lcom/yatatsu/powerwebview/HttpAuthHandlerDelegate;", "getHttpAuthHandlerDelegate", "()Lcom/yatatsu/powerwebview/HttpAuthHandlerDelegate;", "setHttpAuthHandlerDelegate", "(Lcom/yatatsu/powerwebview/HttpAuthHandlerDelegate;)V", "httpAuthHandlerDelegate", "<init>", "(Landroid/content/Context;)V", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
public class PowerWebView extends WebView {
    public int a;
    public final CopyOnWriteArrayList<LoadStateWatcher> b = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<PowerWebViewInterceptor> c = new CopyOnWriteArrayList<>();
    @Nullable
    public SslErrorHandlerDelegate d;
    @Nullable
    public HttpAuthHandlerDelegate e;
    @Nullable
    public HttpErrorHandlerDelegate f;

    public final class a extends WebChromeClient {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(@NotNull ConsoleMessage consoleMessage) {
            HttpErrorHandlerDelegate httpErrorHandlerDelegate;
            Intrinsics.checkNotNullParameter(consoleMessage, "consoleMessage");
            if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR && (httpErrorHandlerDelegate = PowerWebView.this.getHttpErrorHandlerDelegate()) != null) {
                httpErrorHandlerDelegate.onReceivedJsError(String.valueOf(consoleMessage.lineNumber()) + ": " + consoleMessage.message());
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(@NotNull WebView webView, int i) {
            Intrinsics.checkNotNullParameter(webView, "view");
            super.onProgressChanged(webView, i);
            if (PowerWebView.this.a == 1) {
                Iterator it = PowerWebView.this.b.iterator();
                while (it.hasNext()) {
                    ((LoadStateWatcher) it.next()).onProgressChanged(webView, i);
                }
            }
        }
    }

    public final class b extends WebViewClient {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            super.onPageFinished(webView, str);
            if (PowerWebView.this.a == 1) {
                Iterator it = PowerWebView.this.b.iterator();
                while (it.hasNext()) {
                    LoadStateWatcher loadStateWatcher = (LoadStateWatcher) it.next();
                    loadStateWatcher.onProgressChanged(webView, 100);
                    loadStateWatcher.onFinished(webView, str);
                }
            }
            PowerWebView.this.a = 0;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            super.onPageStarted(webView, str, bitmap);
            if (PowerWebView.this.a == 0) {
                PowerWebView.this.a = 1;
                Iterator it = PowerWebView.this.b.iterator();
                while (it.hasNext()) {
                    ((LoadStateWatcher) it.next()).onStarted(webView, str, bitmap);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NotNull WebView webView, int i, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "description");
            Intrinsics.checkNotNullParameter(str2, "failingUrl");
            super.onReceivedError(webView, i, str, str2);
            PowerWebView.this.a = 2;
            Iterator it = PowerWebView.this.b.iterator();
            while (it.hasNext()) {
                ((LoadStateWatcher) it.next()).onError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(@NotNull WebView webView, @NotNull HttpAuthHandler httpAuthHandler, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(httpAuthHandler, "handler");
            Intrinsics.checkNotNullParameter(str, "host");
            Intrinsics.checkNotNullParameter(str2, "realm");
            if (PowerWebView.this.getHttpAuthHandlerDelegate() != null) {
                HttpAuthHandlerDelegate httpAuthHandlerDelegate = PowerWebView.this.getHttpAuthHandlerDelegate();
                Intrinsics.checkNotNull(httpAuthHandlerDelegate);
                httpAuthHandlerDelegate.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                return;
            }
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest, @NotNull WebResourceResponse webResourceResponse) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(webResourceRequest, "request");
            Intrinsics.checkNotNullParameter(webResourceResponse, "errorResponse");
            HttpErrorHandlerDelegate httpErrorHandlerDelegate = PowerWebView.this.getHttpErrorHandlerDelegate();
            if (httpErrorHandlerDelegate != null) {
                httpErrorHandlerDelegate.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@NotNull WebView webView, @NotNull SslErrorHandler sslErrorHandler, @NotNull SslError sslError) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(sslErrorHandler, "handler");
            Intrinsics.checkNotNullParameter(sslError, "error");
            if (PowerWebView.this.getSslErrorHandlerDelegate() != null) {
                SslErrorHandlerDelegate sslErrorHandlerDelegate = PowerWebView.this.getSslErrorHandlerDelegate();
                Intrinsics.checkNotNull(sslErrorHandlerDelegate);
                sslErrorHandlerDelegate.onReceivedSslError(webView, sslErrorHandler, sslError);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            if (!TextUtils.isEmpty(str)) {
                PowerWebView powerWebView = PowerWebView.this;
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
                if (powerWebView.intercept$powerwebview_release(parse)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PowerWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, null);
    }

    private static /* synthetic */ void getPowerWebViewState$annotations() {
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArray;
        setWebViewClient(new b());
        setWebChromeClient(new a());
        if (attributeSet != null) {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.PowerWebView);
            Intrinsics.checkNotNullExpressionValue(typedArray, "context.obtainStyledAttr…R.styleable.PowerWebView)");
        } else {
            typedArray = context.obtainStyledAttributes(R.styleable.PowerWebView);
            Intrinsics.checkNotNullExpressionValue(typedArray, "context.obtainStyledAttr…R.styleable.PowerWebView)");
        }
        boolean z = typedArray.getBoolean(R.styleable.PowerWebView_allow_content_access, true);
        boolean z2 = typedArray.getBoolean(R.styleable.PowerWebView_allow_file_access, true);
        boolean z3 = typedArray.getBoolean(R.styleable.PowerWebView_allow_file_access_from_file_urls, true);
        boolean z4 = typedArray.getBoolean(R.styleable.PowerWebView_allow_universal_access_from_file_urls, false);
        boolean z5 = typedArray.getBoolean(R.styleable.PowerWebView_app_cache_enabled, false);
        boolean z7 = typedArray.getBoolean(R.styleable.PowerWebView_block_network_image, false);
        boolean z8 = typedArray.getBoolean(R.styleable.PowerWebView_block_network_loads, false);
        boolean z9 = typedArray.getBoolean(R.styleable.PowerWebView_built_in_zoom_controls, false);
        int i = typedArray.getInt(R.styleable.PowerWebView_cache_mode, -1);
        boolean z10 = typedArray.getBoolean(R.styleable.PowerWebView_database_enabled, false);
        boolean z11 = typedArray.getBoolean(R.styleable.PowerWebView_display_zoom_controls, false);
        boolean z12 = typedArray.getBoolean(R.styleable.PowerWebView_dom_storage_enabled, false);
        boolean z13 = typedArray.getBoolean(R.styleable.PowerWebView_geolocation_enabled, true);
        boolean z14 = typedArray.getBoolean(R.styleable.PowerWebView_java_script_can_open_windows_automatically, false);
        boolean z15 = typedArray.getBoolean(R.styleable.PowerWebView_java_script_enabled, true);
        boolean z16 = typedArray.getBoolean(R.styleable.PowerWebView_load_with_overview_mode, false);
        boolean z17 = typedArray.getBoolean(R.styleable.PowerWebView_loads_images_automatically, true);
        boolean z18 = typedArray.getBoolean(R.styleable.PowerWebView_need_initial_focus, false);
        boolean z19 = typedArray.getBoolean(R.styleable.PowerWebView_save_form_data, true);
        boolean z20 = typedArray.getBoolean(R.styleable.PowerWebView_support_multiple_windows, false);
        boolean z21 = typedArray.getBoolean(R.styleable.PowerWebView_support_zoom, true);
        boolean z22 = typedArray.getBoolean(R.styleable.PowerWebView_use_wide_view_port, true);
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "setting");
        settings.setAllowContentAccess(z);
        settings.setAllowFileAccess(z2);
        settings.setAppCacheEnabled(z5);
        settings.setBlockNetworkImage(z7);
        settings.setBlockNetworkLoads(z8);
        settings.setBuiltInZoomControls(z9);
        settings.setCacheMode(i);
        settings.setDatabaseEnabled(z10);
        settings.setDisplayZoomControls(z11);
        settings.setDomStorageEnabled(z12);
        settings.setGeolocationEnabled(z13);
        settings.setJavaScriptCanOpenWindowsAutomatically(z14);
        settings.setJavaScriptEnabled(z15);
        settings.setLoadWithOverviewMode(z16);
        settings.setLoadsImagesAutomatically(z17);
        settings.setNeedInitialFocus(z18);
        settings.setSaveFormData(z19);
        settings.setSupportMultipleWindows(z20);
        settings.setSupportZoom(z21);
        settings.setUseWideViewPort(z22);
        settings.setAllowFileAccessFromFileURLs(z3);
        settings.setAllowUniversalAccessFromFileURLs(z4);
        typedArray.recycle();
        removeJavascriptInterface("searchBoxJavaBridge_");
    }

    public final void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.c.add(powerWebViewInterceptor);
    }

    public final void addLoadStateWatcher(@NotNull LoadStateWatcher loadStateWatcher) {
        Intrinsics.checkNotNullParameter(loadStateWatcher, "watcher");
        this.b.add(loadStateWatcher);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        stopLoading();
        setWebChromeClient(null);
        setWebViewClient(null);
        this.d = null;
        this.e = null;
        this.b.clear();
        this.c.clear();
        super.destroy();
    }

    @Nullable
    public final HttpAuthHandlerDelegate getHttpAuthHandlerDelegate() {
        return this.e;
    }

    @Nullable
    public final HttpErrorHandlerDelegate getHttpErrorHandlerDelegate() {
        return this.f;
    }

    @Nullable
    public final SslErrorHandlerDelegate getSslErrorHandlerDelegate() {
        return this.d;
    }

    public final boolean intercept$powerwebview_release(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Iterator<PowerWebViewInterceptor> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().intercept(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebView
    public void loadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        if (!intercept$powerwebview_release(parse)) {
            super.loadUrl(str);
        }
    }

    public final void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.c.remove(powerWebViewInterceptor);
    }

    public final void removeLoadStateWatcher(@NotNull LoadStateWatcher loadStateWatcher) {
        Intrinsics.checkNotNullParameter(loadStateWatcher, "watcher");
        this.b.remove(loadStateWatcher);
    }

    public final void setHttpAuthHandlerDelegate(@Nullable HttpAuthHandlerDelegate httpAuthHandlerDelegate) {
        this.e = httpAuthHandlerDelegate;
    }

    public final void setHttpErrorHandlerDelegate(@Nullable HttpErrorHandlerDelegate httpErrorHandlerDelegate) {
        this.f = httpErrorHandlerDelegate;
    }

    public final void setSslErrorHandlerDelegate(@Nullable SslErrorHandlerDelegate sslErrorHandlerDelegate) {
        this.d = sslErrorHandlerDelegate;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PowerWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }
}
