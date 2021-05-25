package com.avito.android.social.esia;

import a2.g.r.g;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.social.R;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00105\u001a\u00020\u001f\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b6\u00107J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010!R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010%8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthViewImpl;", "Lcom/avito/android/social/esia/EsiaAuthView;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "", "url", "Lcom/avito/android/social/esia/EsiaAuthConfig;", Navigation.CONFIG, "", "loadUrl", "(Ljava/lang/String;Lcom/avito/android/social/esia/EsiaAuthConfig;)V", "Lkotlin/Function1;", "Lcom/avito/android/social/esia/EsiaAuthResult;", "callback", "setAuthCallback", "(Lkotlin/jvm/functions/Function1;)V", "onRefresh", "()V", "", "canGoBack", "()Z", "goBack", "Landroid/webkit/WebView;", AuthSource.SEND_ABUSE, "Landroid/webkit/WebView;", "webView", "Lio/reactivex/rxjava3/core/Observable;", "f", "Lio/reactivex/rxjava3/core/Observable;", "getButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "progressView", "c", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getRefreshAction", "()Lkotlin/jvm/functions/Function0;", "setRefreshAction", "(Lkotlin/jvm/functions/Function0;)V", "refreshAction", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "d", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Lcom/avito/android/social/esia/EsiaWebViewClient;", g.a, "Lcom/avito/android/social/esia/EsiaWebViewClient;", "webClient", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/social/esia/EsiaWebViewClient;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class EsiaAuthViewImpl implements EsiaAuthView, SwipeRefreshLayout.OnRefreshListener {
    public final WebView a;
    public final View b;
    public View c;
    public SwipeRefreshLayout d;
    @Nullable
    public Function0<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    public final EsiaWebViewClient g;

    public EsiaAuthViewImpl(@NotNull View view, @NotNull EsiaWebViewClient esiaWebViewClient) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(esiaWebViewClient, "webClient");
        this.g = esiaWebViewClient;
        View findViewById = view.findViewById(R.id.web_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.web_view)");
        WebView webView = (WebView) findViewById;
        this.a = webView;
        View findViewById2 = view.findViewById(R.id.progress_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.progress_view)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.button_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.button_close)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.swipe_refresh_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.swipe_refresh_layout)");
        this.d = (SwipeRefreshLayout) findViewById4;
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookies(null);
        instance.flush();
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        webView.setWebViewClient(esiaWebViewClient);
        esiaWebViewClient.setProgressView(findViewById2);
        this.d.setOnRefreshListener(this);
        this.f = RxView.clicks(this.c);
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    public boolean canGoBack() {
        return this.a.canGoBack();
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.f;
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    @Nullable
    public Function0<Unit> getRefreshAction() {
        return this.e;
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    public void goBack() {
        this.a.goBack();
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    public void loadUrl(@NotNull String str, @NotNull EsiaAuthConfig esiaAuthConfig) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(esiaAuthConfig, Navigation.CONFIG);
        this.g.setConfig(esiaAuthConfig);
        this.a.loadUrl(str);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.d.setRefreshing(false);
        Function0<Unit> refreshAction = getRefreshAction();
        if (refreshAction != null) {
            refreshAction.invoke();
        }
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    public void setAuthCallback(@Nullable Function1<? super EsiaAuthResult, Unit> function1) {
        this.g.setCallback(function1);
    }

    @Override // com.avito.android.social.esia.EsiaAuthView
    public void setRefreshAction(@Nullable Function0<Unit> function0) {
        this.e = function0;
    }
}
