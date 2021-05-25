package a2.a.a.t1.g;

import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Unit, DialogState> {
    public final /* synthetic */ WebPaymentPresenterImpl a;
    public final /* synthetic */ DialogState b;

    public c(WebPaymentPresenterImpl webPaymentPresenterImpl, DialogState dialogState) {
        this.a = webPaymentPresenterImpl;
        this.b = dialogState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public DialogState apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.a.n.onDialogPositive(this.b);
    }
}
