package a2.a.a.t1.g;

import com.avito.android.payment.webview.ScreenState;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import com.avito.android.payment.webview.WebViewState;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<WebViewState, ScreenState> {
    public final /* synthetic */ WebPaymentPresenterImpl a;
    public final /* synthetic */ ScreenState b;

    public h(WebPaymentPresenterImpl webPaymentPresenterImpl, ScreenState screenState) {
        this.a = webPaymentPresenterImpl;
        this.b = screenState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState apply(WebViewState webViewState) {
        WebViewState webViewState2 = webViewState;
        Intrinsics.checkNotNullParameter(webViewState2, "it");
        return this.a.n.onWebViewStateChanged(this.b, webViewState2);
    }
}
