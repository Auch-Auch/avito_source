package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.vas_performance.ui.VisualVasFragment;
public final class k0<T> implements Observer<DeepLink> {
    public final /* synthetic */ VisualVasFragment a;

    public k0(VisualVasFragment visualVasFragment) {
        this.a = visualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null) {
            VisualVasFragment.access$getRouter$p(this.a).navigate(deepLink2);
        } else {
            PaidServicesRouter.DefaultImpls.finishFlow$default(VisualVasFragment.access$getRouter$p(this.a), null, 1, null);
        }
    }
}
