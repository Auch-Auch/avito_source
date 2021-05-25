package defpackage;

import android.view.View;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.paid_services.routing.PaidServicesRouter;
/* compiled from: java-style lambda group */
/* renamed from: b1  reason: default package */
public final class b1 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public b1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            PaidServicesRouter paidServicesRouter = ((CheckoutFragment) this.b).h;
            if (paidServicesRouter != null) {
                PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter, null, 1, null);
            }
        } else if (i == 1) {
            ((CheckoutFragment) this.b).requireActivity().onBackPressed();
        } else {
            throw null;
        }
    }
}
