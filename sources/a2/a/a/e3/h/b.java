package a2.a.a.e3.h;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.tariff.region.RegionFragment;
public final class b<T> implements Observer<DeepLink> {
    public final /* synthetic */ RegionFragment a;

    public b(RegionFragment regionFragment) {
        this.a = regionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        PaidServicesRouter paidServicesRouter;
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null && (paidServicesRouter = this.a.g) != null) {
            paidServicesRouter.navigate(deepLink2);
        }
    }
}
