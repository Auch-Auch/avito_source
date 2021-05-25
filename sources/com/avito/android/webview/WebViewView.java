package com.avito.android.webview;

import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0014\u001a\u00020\u00022#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/webview/WebViewView;", "", "", "stopLoadingContent", "()V", "showLoading", "showContent", "showLoadingProblem", "", "url", "Landroid/webkit/WebViewClient;", "webViewClient", "Lcom/avito/android/webview/WebAppInterface;", WebViewViewKt.JAVA_SCRIP_INTERFACE_NAME, "loadContent", "(Ljava/lang/String;Landroid/webkit/WebViewClient;Lcom/avito/android/webview/WebAppInterface;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "", "canScrollDown", "()Z", "canGoBack", "goBack", "Lcom/avito/android/webview/WebViewWithScrollListener;", "getWebView", "()Lcom/avito/android/webview/WebViewWithScrollListener;", "webView", "Presenter", "webview_release"}, k = 1, mv = {1, 4, 2})
public interface WebViewView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/webview/WebViewView$Presenter;", "", "", "onCloseClicked", "()V", "onRefresh", "", "isFullScreen", "()Z", "webview_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter {
        boolean isFullScreen();

        void onCloseClicked();

        void onRefresh();
    }

    boolean canGoBack();

    boolean canScrollDown();

    @NotNull
    WebViewWithScrollListener getWebView();

    void goBack();

    void loadContent(@NotNull String str, @NotNull WebViewClient webViewClient, @NotNull WebAppInterface webAppInterface);

    void setOnScrollListener(@Nullable Function1<? super String, Unit> function1);

    void showContent();

    void showLoading();

    void showLoadingProblem();

    void stopLoadingContent();
}
