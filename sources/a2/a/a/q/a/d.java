package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
public final class d<T> implements Observer<DeepLink> {
    public final /* synthetic */ CheckoutFragment a;

    public d(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        PaidServicesRouter paidServicesRouter;
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null && (paidServicesRouter = this.a.h) != null) {
            paidServicesRouter.navigate(deepLink2);
        }
    }
}
