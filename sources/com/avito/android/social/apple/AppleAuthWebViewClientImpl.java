package com.avito.android.social.apple;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.social.apple.AppleAuthResult;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b.\u0010/J#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\b\u0010\fJ#\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthWebViewClientImpl;", "Landroid/webkit/WebViewClient;", "Lcom/avito/android/social/apple/AppleAuthWebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Z", "Lcom/avito/android/social/apple/AppleAuthRequestConfig;", "Lcom/avito/android/social/apple/AppleAuthRequestConfig;", "getConfig", "()Lcom/avito/android/social/apple/AppleAuthRequestConfig;", "setConfig", "(Lcom/avito/android/social/apple/AppleAuthRequestConfig;)V", Navigation.CONFIG, "Landroid/view/View;", "c", "Landroid/view/View;", "getProgressView", "()Landroid/view/View;", "setProgressView", "(Landroid/view/View;)V", "progressView", "Lkotlin/Function1;", "Lcom/avito/android/social/apple/AppleAuthResult;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "callback", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class AppleAuthWebViewClientImpl extends WebViewClient implements AppleAuthWebViewClient {
    @Nullable
    public AppleAuthRequestConfig a;
    @Nullable
    public Function1<? super AppleAuthResult, Unit> b;
    @Nullable
    public View c;

    public final boolean a(String str) {
        AppleAuthResult appleAuthResult;
        AppleAuthRequestConfig config = getConfig();
        boolean z = false;
        String str2 = null;
        if (!Intrinsics.areEqual((config == null || str == null) ? null : Boolean.valueOf(StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) config.getRedirectUrl(), false, 2, (Object) null)), Boolean.TRUE)) {
            return false;
        }
        if (str != null) {
            str2 = m.replace$default(str, "?#", "?", false, 4, (Object) null);
        }
        Uri parse = Uri.parse(str2);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url?.replace(\"?#\", \"?\"))");
        String queryParameter = parse.getQueryParameter("code");
        String queryParameter2 = parse.getQueryParameter("user");
        Function1<AppleAuthResult, Unit> callback = getCallback();
        if (callback != null) {
            if (queryParameter == null || queryParameter.length() == 0) {
                z = true;
            }
            if (z) {
                appleAuthResult = new AppleAuthResult.Failure("code is not valid");
            } else {
                appleAuthResult = new AppleAuthResult.Success(queryParameter, queryParameter2);
            }
            callback.invoke(appleAuthResult);
        }
        return true;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.social.apple.AppleAuthResult, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.social.apple.AppleAuthResult, kotlin.Unit> */
    @Override // com.avito.android.social.apple.AppleAuthWebViewClient
    @Nullable
    public Function1<AppleAuthResult, Unit> getCallback() {
        return this.b;
    }

    @Override // com.avito.android.social.apple.AppleAuthWebViewClient
    @Nullable
    public AppleAuthRequestConfig getConfig() {
        return this.a;
    }

    @Override // com.avito.android.social.apple.AppleAuthWebViewClient
    @Nullable
    public View getProgressView() {
        return this.c;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        Views.hide(getProgressView());
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        Views.show(getProgressView());
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.avito.android.social.apple.AppleAuthWebViewClient
    public void setCallback(@Nullable Function1<? super AppleAuthResult, Unit> function1) {
        this.b = function1;
    }

    @Override // com.avito.android.social.apple.AppleAuthWebViewClient
    public void setConfig(@Nullable AppleAuthRequestConfig appleAuthRequestConfig) {
        this.a = appleAuthRequestConfig;
    }

    @Override // com.avito.android.social.apple.AppleAuthWebViewClient
    public void setProgressView(@Nullable View view) {
        this.c = view;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        return a(str);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(24)
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
        Uri url;
        return a((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString());
    }
}
