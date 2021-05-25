package a2.a.a.t1.b.n;

import com.avito.android.payment.form.status.PaymentStatusFormViewKt;
import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<ViewLayoutChangeEvent, Integer> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Integer apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
        Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
        return Integer.valueOf(PaymentStatusFormViewKt.access$newWidth(viewLayoutChangeEvent2));
    }
}
