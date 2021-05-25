package a2.a.a.t1.b.n;

import com.avito.android.payment.form.status.PaymentStatusFormPresenterImpl;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Unit> {
    public final /* synthetic */ PaymentStatusFormPresenterImpl a;
    public final /* synthetic */ PaymentStatusFormResult.StatusForm b;

    public b(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl, PaymentStatusFormResult.StatusForm statusForm) {
        this.a = paymentStatusFormPresenterImpl;
        this.b = statusForm;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.f.accept(this.b.getAction().getLink());
    }
}
