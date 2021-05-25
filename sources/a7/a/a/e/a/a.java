package a7.a.a.e.a;

import android.widget.RelativeLayout;
import ru.avito.component.payments.method.PaymentMethodListCard;
public final class a implements Runnable {
    public final /* synthetic */ PaymentMethodListCard a;
    public final /* synthetic */ RelativeLayout.LayoutParams b;

    public a(PaymentMethodListCard paymentMethodListCard, RelativeLayout.LayoutParams layoutParams) {
        this.a = paymentMethodListCard;
        this.b = layoutParams;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b.setLayoutParams(this.b);
    }
}
