package a2.a.a.t1.b;

import com.avito.android.payment.form.PaymentGenericFormPresenterImpl;
import com.avito.android.remote.model.PretendResult;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class i<T> implements Consumer<PretendResult> {
    public final /* synthetic */ PaymentGenericFormPresenterImpl a;

    public i(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
        this.a = paymentGenericFormPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(PretendResult pretendResult) {
        this.a.h.accept(Unit.INSTANCE);
    }
}
