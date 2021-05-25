package a2.a.a.k0.b.b;

import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ ReasonDetailsViewModelImpl a;
    public final /* synthetic */ String b;

    public c(ReasonDetailsViewModelImpl reasonDetailsViewModelImpl, String str) {
        this.a = reasonDetailsViewModelImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getSnackbarChanges().setValue(this.a.v.getErrorOccurred());
        ReasonDetailsViewModelImpl.access$cancelOrder(this.a, this.b);
    }
}
