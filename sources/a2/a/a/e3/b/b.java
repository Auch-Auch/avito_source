package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.tariff.count.TariffCountFragment;
public final class b<T> implements Observer<DeepLink> {
    public final /* synthetic */ TariffCountFragment a;

    public b(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        PaidServicesRouter paidServicesRouter;
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null && (paidServicesRouter = this.a.f) != null) {
            paidServicesRouter.navigate(deepLink2);
        }
    }
}
