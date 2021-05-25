package a2.a.a.t1.g;

import com.avito.android.payment.webview.ScreenState;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<Unit, ScreenState> {
    public final /* synthetic */ WebPaymentPresenterImpl a;
    public final /* synthetic */ ScreenState b;

    public e(WebPaymentPresenterImpl webPaymentPresenterImpl, ScreenState screenState) {
        this.a = webPaymentPresenterImpl;
        this.b = screenState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.a.n.onRetry(this.b);
    }
}
