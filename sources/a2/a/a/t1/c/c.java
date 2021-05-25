package a2.a.a.t1.c;

import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class c<T, R> implements Function<PaymentSessionResult, List<? extends PaymentMethod>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends PaymentMethod> apply(PaymentSessionResult paymentSessionResult) {
        PaymentSessionResult paymentSessionResult2 = paymentSessionResult;
        Intrinsics.checkNotNullParameter(paymentSessionResult2, "it");
        return e.flatten(paymentSessionResult2.getPaymentMethods());
    }
}
