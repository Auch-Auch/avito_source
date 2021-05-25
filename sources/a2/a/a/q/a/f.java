package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import kotlin.Unit;
public final class f<T> implements Observer<Unit> {
    public final /* synthetic */ CheckoutFragment a;

    public f(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        PaidServicesRouter paidServicesRouter = this.a.h;
        if (paidServicesRouter != null) {
            paidServicesRouter.finishFlowWithResult(null, -1);
        }
    }
}
