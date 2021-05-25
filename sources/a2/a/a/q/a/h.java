package a2.a.a.q.a;

import android.view.MenuItem;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.paid_services.routing.PaidServicesRouter;
public final class h implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ CheckoutFragment a;

    public h(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        PaidServicesRouter paidServicesRouter = this.a.h;
        if (paidServicesRouter != null) {
            PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter, null, 1, null);
        }
        return true;
    }
}
