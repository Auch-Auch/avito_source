package a2.a.a.e3.e;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
public final class b<T> implements Observer<DeepLink> {
    public final /* synthetic */ FeesMethodsFragment a;

    public b(FeesMethodsFragment feesMethodsFragment) {
        this.a = feesMethodsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        PaidServicesRouter paidServicesRouter;
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null && (paidServicesRouter = this.a.e) != null) {
            paidServicesRouter.navigate(deepLink2);
        }
    }
}
