package com.avito.android.webview;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Toolbars;
import com.avito.android.webview.WebViewView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.functions.Function4;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000f\u001a\u00020\b2#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006/"}, d2 = {"Lcom/avito/android/webview/WebViewViewImpl;", "Lcom/avito/android/webview/WebViewView;", "", "url", "Landroid/webkit/WebViewClient;", "webViewClient", "Lcom/avito/android/webview/WebAppInterface;", WebViewViewKt.JAVA_SCRIP_INTERFACE_NAME, "", "loadContent", "(Ljava/lang/String;Landroid/webkit/WebViewClient;Lcom/avito/android/webview/WebAppInterface;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "", "canScrollDown", "()Z", "stopLoadingContent", "()V", "showLoading", "showContent", "showLoadingProblem", "canGoBack", "goBack", "Lcom/avito/android/webview/WebViewView$Presenter;", "c", "Lcom/avito/android/webview/WebViewView$Presenter;", "presenter", "Lcom/avito/android/webview/WebViewWithScrollListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/webview/WebViewWithScrollListener;", "getWebView", "()Lcom/avito/android/webview/WebViewWithScrollListener;", "webView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/ViewGroup;", "root", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/webview/WebViewView$Presenter;Lcom/avito/android/analytics/Analytics;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewViewImpl implements WebViewView {
    @NotNull
    public final WebViewWithScrollListener a;
    public final ProgressOverlay b;
    public final WebViewView.Presenter c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WebViewViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(WebViewViewImpl webViewViewImpl) {
            super(0);
            this.a = webViewViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.c.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ WebViewViewImpl a;

        public b(WebViewViewImpl webViewViewImpl) {
            this.a = webViewViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.c.onCloseClicked();
        }
    }

    public static final class c<T1, T2, T3, T4, R> implements Function4<Integer, Integer, Integer, Integer, Unit> {
        public final /* synthetic */ WebViewViewImpl a;
        public final /* synthetic */ Function1 b;

        public c(WebViewViewImpl webViewViewImpl, Function1 function1) {
            this.a = webViewViewImpl;
            this.b = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.Function4
        public Unit apply(Integer num, Integer num2, Integer num3, Integer num4) {
            Intrinsics.checkNotNullParameter(num, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(num2, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(num3, "<anonymous parameter 2>");
            Intrinsics.checkNotNullParameter(num4, "<anonymous parameter 3>");
            Function1 function1 = this.b;
            if (function1 != null) {
                String url = this.a.getWebView().getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "webView.url");
                Unit unit = (Unit) function1.invoke(url);
            }
            return Unit.INSTANCE;
        }
    }

    public WebViewViewImpl(@NotNull ViewGroup viewGroup, @NotNull WebViewView.Presenter presenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.c = presenter;
        int i = R.id.web_view;
        View findViewById = viewGroup.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.webview.WebViewWithScrollListener");
        this.a = (WebViewWithScrollListener) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(this));
        Toolbar toolbar = (Toolbar) viewGroup.findViewById(R.id.toolbar);
        if (toolbar != null) {
            if (presenter.isFullScreen()) {
                toolbar.setVisibility(8);
            } else {
                Toolbars.setCloseIcon(toolbar);
                toolbar.setNavigationOnClickListener(new b(this));
            }
        }
        WebSettings settings = getWebView().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = getWebView().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings2, "webView.settings");
        settings2.setDomStorageEnabled(true);
    }

    @Override // com.avito.android.webview.WebViewView
    public boolean canGoBack() {
        return getWebView().canGoBack();
    }

    @Override // com.avito.android.webview.WebViewView
    public boolean canScrollDown() {
        return getWebView().canScrollVertically(1);
    }

    @Override // com.avito.android.webview.WebViewView
    @NotNull
    public WebViewWithScrollListener getWebView() {
        return this.a;
    }

    @Override // com.avito.android.webview.WebViewView
    public void goBack() {
        getWebView().goBack();
    }

    @Override // com.avito.android.webview.WebViewView
    public void loadContent(@NotNull String str, @NotNull WebViewClient webViewClient, @NotNull WebAppInterface webAppInterface) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        Intrinsics.checkNotNullParameter(webAppInterface, WebViewViewKt.JAVA_SCRIP_INTERFACE_NAME);
        getWebView().setWebViewClient(webViewClient);
        getWebView().addJavascriptInterface(webAppInterface, WebViewViewKt.JAVA_SCRIP_INTERFACE_NAME);
        getWebView().loadUrl(str);
    }

    @Override // com.avito.android.webview.WebViewView
    public void setOnScrollListener(@Nullable Function1<? super String, Unit> function1) {
        getWebView().addScrollChangeListener(new c(this, function1));
    }

    @Override // com.avito.android.webview.WebViewView
    public void showContent() {
        this.b.showContent();
    }

    @Override // com.avito.android.webview.WebViewView
    public void showLoading() {
        this.b.showLoading();
    }

    @Override // com.avito.android.webview.WebViewView
    public void showLoadingProblem() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.b, null, 1, null);
    }

    @Override // com.avito.android.webview.WebViewView
    public void stopLoadingContent() {
        getWebView().stopLoading();
    }
}
