package a2.a.a.t1.c;

import com.avito.android.payment.lib.PaymentMethodsView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PaymentMethodsView a;
    public final /* synthetic */ boolean b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PaymentMethodsView paymentMethodsView, boolean z) {
        super(0);
        this.a = paymentMethodsView;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.n.accept(Boolean.valueOf(this.b));
        return Unit.INSTANCE;
    }
}
