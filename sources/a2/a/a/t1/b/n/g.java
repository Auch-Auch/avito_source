package a2.a.a.t1.b.n;

import com.avito.android.payment.form.status.PaymentStatusFormViewImpl;
import com.avito.android.ui_components.R;
import io.reactivex.functions.Consumer;
public final class g<T> implements Consumer<Integer> {
    public final /* synthetic */ PaymentStatusFormViewImpl a;

    public g(PaymentStatusFormViewImpl paymentStatusFormViewImpl) {
        this.a = paymentStatusFormViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        int intValue = (num.intValue() - this.a.m.getResources().getDimensionPixelSize(R.dimen.vas_item_fixed_width)) / 2;
        this.a.c.setPadding(intValue, 0, intValue, 0);
    }
}
