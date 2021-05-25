package a2.a.a.t1.g;

import com.avito.android.payment.webview.WebViewState;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Predicate<WebViewState> {
    public static final j a = new j();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(WebViewState webViewState) {
        WebViewState webViewState2 = webViewState;
        Intrinsics.checkNotNullParameter(webViewState2, "it");
        return webViewState2 == WebViewState.ERROR;
    }
}
