package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.paid_services.routing.PaidServicesRouter;
public final class g<T> implements Observer<DialogInfo> {
    public final /* synthetic */ CheckoutFragment a;

    public g(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DialogInfo dialogInfo) {
        PaidServicesRouter paidServicesRouter;
        DialogInfo dialogInfo2 = dialogInfo;
        if (dialogInfo2 != null && (paidServicesRouter = this.a.h) != null) {
            paidServicesRouter.finishFlowWithResult(dialogInfo2, -1);
        }
    }
}
