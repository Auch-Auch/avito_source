package com.avito.android.social.esia;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/social/esia/EsiaWebViewClient;", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lcom/avito/android/social/esia/EsiaAuthResult;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "callback", "Lcom/avito/android/social/esia/EsiaAuthConfig;", "Lcom/avito/android/social/esia/EsiaAuthConfig;", "getConfig", "()Lcom/avito/android/social/esia/EsiaAuthConfig;", "setConfig", "(Lcom/avito/android/social/esia/EsiaAuthConfig;)V", Navigation.CONFIG, "Landroid/view/View;", "c", "Landroid/view/View;", "getProgressView", "()Landroid/view/View;", "setProgressView", "(Landroid/view/View;)V", "progressView", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class EsiaWebViewClient extends WebViewClient {
    @Nullable
    public EsiaAuthConfig a;
    @Nullable
    public Function1<? super EsiaAuthResult, Unit> b;
    @Nullable
    public View c;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r6) {
        /*
            r5 = this;
            com.avito.android.social.esia.EsiaAuthConfig r0 = r5.a
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getRedirectUrl()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x001c
            if (r6 == 0) goto L_0x0017
            r4 = 2
            boolean r0 = kotlin.text.StringsKt__StringsKt.contains$default(r6, r0, r3, r4, r1)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 != 0) goto L_0x0020
            return r3
        L_0x0020:
            android.net.Uri r6 = android.net.Uri.parse(r6)
            java.lang.String r0 = "Uri.parse(url)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.String r0 = "code"
            java.lang.String r0 = r6.getQueryParameter(r0)
            java.lang.String r1 = "state"
            java.lang.String r6 = r6.getQueryParameter(r1)
            kotlin.jvm.functions.Function1<? super com.avito.android.social.esia.EsiaAuthResult, kotlin.Unit> r1 = r5.b
            if (r1 == 0) goto L_0x0058
            if (r0 == 0) goto L_0x0041
            int r4 = r0.length()
            if (r4 != 0) goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            if (r3 == 0) goto L_0x004c
            com.avito.android.social.esia.EsiaAuthResult$Failure r6 = new com.avito.android.social.esia.EsiaAuthResult$Failure
            java.lang.String r0 = "code is not valid"
            r6.<init>(r0)
            goto L_0x0052
        L_0x004c:
            com.avito.android.social.esia.EsiaAuthResult$Success r3 = new com.avito.android.social.esia.EsiaAuthResult$Success
            r3.<init>(r0, r6)
            r6 = r3
        L_0x0052:
            java.lang.Object r6 = r1.invoke(r6)
            kotlin.Unit r6 = (kotlin.Unit) r6
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.social.esia.EsiaWebViewClient.a(java.lang.String):boolean");
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.social.esia.EsiaAuthResult, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.social.esia.EsiaAuthResult, kotlin.Unit> */
    @Nullable
    public final Function1<EsiaAuthResult, Unit> getCallback() {
        return this.b;
    }

    @Nullable
    public final EsiaAuthConfig getConfig() {
        return this.a;
    }

    @Nullable
    public final View getProgressView() {
        return this.c;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        Views.hide(this.c);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        Views.show(this.c);
        super.onPageStarted(webView, str, bitmap);
    }

    public final void setCallback(@Nullable Function1<? super EsiaAuthResult, Unit> function1) {
        this.b = function1;
    }

    public final void setConfig(@Nullable EsiaAuthConfig esiaAuthConfig) {
        this.a = esiaAuthConfig;
    }

    public final void setProgressView(@Nullable View view) {
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
