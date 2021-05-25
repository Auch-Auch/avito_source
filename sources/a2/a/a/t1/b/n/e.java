package a2.a.a.t1.b.n;

import com.avito.android.payment.form.status.PaymentStatusFormViewKt;
import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Predicate<ViewLayoutChangeEvent> {
    public static final e a = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
        Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
        return PaymentStatusFormViewKt.access$oldWidth(viewLayoutChangeEvent2) != PaymentStatusFormViewKt.access$newWidth(viewLayoutChangeEvent2);
    }
}
