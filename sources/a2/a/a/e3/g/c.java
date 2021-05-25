package a2.a.a.e3.g;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.tariff.landing.TariffLandingFragment;
public final class c<T> implements Observer<DeepLink> {
    public final /* synthetic */ TariffLandingFragment a;

    public c(TariffLandingFragment tariffLandingFragment) {
        this.a = tariffLandingFragment;
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
