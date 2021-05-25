package a2.a.a.k0.e;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
public final class a<T> implements Observer<DeepLink> {
    public final /* synthetic */ DeliveryRdsSummaryFragment a;

    public a(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment) {
        this.a = deliveryRdsSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null) {
            DeliveryRdsSummaryFragment deliveryRdsSummaryFragment = this.a;
            deliveryRdsSummaryFragment.startActivity(deliveryRdsSummaryFragment.getDeepLinkIntentFactory().getIntent(deepLink2));
        }
    }
}
