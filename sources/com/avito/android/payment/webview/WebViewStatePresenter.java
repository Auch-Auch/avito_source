package com.avito.android.payment.webview;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.ui.view.PowerWebViewWrapper;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/payment/webview/WebViewStatePresenter;", "", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "powerWebView", "", "attachView", "(Lcom/avito/android/ui/view/PowerWebViewWrapper;)V", "detachView", "()V", "", "url", "loadUrl", "(Ljava/lang/String;)V", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getFinalDeepLink", "()Lio/reactivex/Observable;", "finalDeepLink", "Lcom/avito/android/payment/webview/WebViewState;", "getLoadingState", "loadingState", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface WebViewStatePresenter {
    void attachView(@NotNull PowerWebViewWrapper powerWebViewWrapper);

    void detachView();

    @NotNull
    Observable<DeepLink> getFinalDeepLink();

    @NotNull
    Observable<WebViewState> getLoadingState();

    void loadUrl(@NotNull String str);
}
