package a2.a.a.t1.g;

import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import io.reactivex.functions.Consumer;
public final class g<T> implements Consumer<DialogState.Terminated> {
    public final /* synthetic */ WebPaymentPresenterImpl a;

    public g(WebPaymentPresenterImpl webPaymentPresenterImpl) {
        this.a = webPaymentPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(DialogState.Terminated terminated) {
        this.a.d.accept(terminated.getResult());
    }
}
