package defpackage;

import com.avito.android.payment.webview.WebViewState;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: n0  reason: default package */
public final class n0<T, R> implements Function<PowerWebViewStateChangeEvent, WebViewState> {
    public static final n0 b = new n0(0);
    public static final n0 c = new n0(1);
    public static final n0 d = new n0(2);
    public final /* synthetic */ int a;

    public n0(int i) {
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public final WebViewState apply(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent, "it");
            return WebViewState.ERROR;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent, "it");
            return WebViewState.PRELOADING_FINISHED;
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent, "it");
            return WebViewState.PRELOADING_STARTED;
        } else {
            throw null;
        }
    }
}
