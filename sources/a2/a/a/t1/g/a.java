package a2.a.a.t1.g;

import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import com.avito.android.payment.webview.WebViewState;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<WebViewState, DialogState> {
    public final /* synthetic */ WebPaymentPresenterImpl a;
    public final /* synthetic */ DialogState b;

    public a(WebPaymentPresenterImpl webPaymentPresenterImpl, DialogState dialogState) {
        this.a = webPaymentPresenterImpl;
        this.b = dialogState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public DialogState apply(WebViewState webViewState) {
        WebViewState webViewState2 = webViewState;
        Intrinsics.checkNotNullParameter(webViewState2, "it");
        return this.a.n.onWebViewStateChanged(this.b, webViewState2);
    }
}
