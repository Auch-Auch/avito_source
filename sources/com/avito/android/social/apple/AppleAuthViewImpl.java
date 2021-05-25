package com.avito.android.social.apple;

import a2.g.r.g;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.social.R;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u00103\u001a\u00020\u000b\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\b4\u00105J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\b2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R*\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthViewImpl;", "Lcom/avito/android/social/apple/AppleAuthView;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroid/view/View$OnClickListener;", "", "url", "Lcom/avito/android/social/apple/AppleAuthRequestConfig;", Navigation.CONFIG, "", "loadUrl", "(Ljava/lang/String;Lcom/avito/android/social/apple/AppleAuthRequestConfig;)V", "Landroid/view/View;", VKApiConst.VERSION, "onClick", "(Landroid/view/View;)V", "onRefresh", "()V", "Lkotlin/Function1;", "Lcom/avito/android/social/apple/AppleAuthResult;", "callback", "setAuthCallback", "(Lkotlin/jvm/functions/Function1;)V", "c", "Landroid/view/View;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/webkit/WebView;", AuthSource.SEND_ABUSE, "Landroid/webkit/WebView;", "webView", AuthSource.BOOKING_ORDER, "progressView", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getCloseAction", "()Lkotlin/jvm/functions/Function0;", "setCloseAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "e", "getRefreshAction", "setRefreshAction", "refreshAction", "Lcom/avito/android/social/apple/AppleAuthWebViewClient;", g.a, "Lcom/avito/android/social/apple/AppleAuthWebViewClient;", "webClient", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "d", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/social/apple/AppleAuthWebViewClient;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class AppleAuthViewImpl implements AppleAuthView, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    public WebView a;
    public View b;
    public View c;
    public SwipeRefreshLayout d;
    @Nullable
    public Function0<Unit> e;
    @Nullable
    public Function0<Unit> f;
    public final AppleAuthWebViewClient g;

    public AppleAuthViewImpl(@NotNull View view, @NotNull AppleAuthWebViewClient appleAuthWebViewClient) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appleAuthWebViewClient, "webClient");
        this.g = appleAuthWebViewClient;
        View findViewById = view.findViewById(R.id.web_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(social_R.id.web_view)");
        this.a = (WebView) findViewById;
        View findViewById2 = view.findViewById(R.id.progress_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(social_R.id.progress_view)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.button_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(social_R.id.button_close)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.swipe_refresh_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(social….id.swipe_refresh_layout)");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById4;
        this.d = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.c.setOnClickListener(this);
        appleAuthWebViewClient.setProgressView(this.b);
        WebView webView = this.a;
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        Objects.requireNonNull(appleAuthWebViewClient, "null cannot be cast to non-null type android.webkit.WebViewClient");
        webView.setWebViewClient((WebViewClient) appleAuthWebViewClient);
    }

    @Override // com.avito.android.social.apple.AppleAuthView
    @Nullable
    public Function0<Unit> getCloseAction() {
        return this.f;
    }

    @Override // com.avito.android.social.apple.AppleAuthView
    @Nullable
    public Function0<Unit> getRefreshAction() {
        return this.e;
    }

    @Override // com.avito.android.social.apple.AppleAuthView
    public void loadUrl(@NotNull String str, @NotNull AppleAuthRequestConfig appleAuthRequestConfig) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(appleAuthRequestConfig, Navigation.CONFIG);
        this.g.setConfig(appleAuthRequestConfig);
        this.a.loadUrl(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Function0<Unit> closeAction = getCloseAction();
        if (closeAction != null) {
            closeAction.invoke();
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.d.setRefreshing(false);
        Function0<Unit> refreshAction = getRefreshAction();
        if (refreshAction != null) {
            refreshAction.invoke();
        }
    }

    @Override // com.avito.android.social.apple.AppleAuthView
    public void setAuthCallback(@Nullable Function1<? super AppleAuthResult, Unit> function1) {
        this.g.setCallback(function1);
    }

    @Override // com.avito.android.social.apple.AppleAuthView
    public void setCloseAction(@Nullable Function0<Unit> function0) {
        this.f = function0;
    }

    @Override // com.avito.android.social.apple.AppleAuthView
    public void setRefreshAction(@Nullable Function0<Unit> function0) {
        this.e = function0;
    }
}
