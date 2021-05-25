package a2.a.a.t1.b.n;

import com.avito.android.payment.form.status.PaymentStatusFormViewImpl;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PaymentStatusFormViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(PaymentStatusFormViewImpl paymentStatusFormViewImpl) {
        super(0);
        this.a = paymentStatusFormViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PublishRelay publishRelay = this.a.d;
        Unit unit = Unit.INSTANCE;
        publishRelay.accept(unit);
        return unit;
    }
}
