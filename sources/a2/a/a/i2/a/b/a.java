package a2.a.a.i2.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment;
public final class a<T> implements Observer<DeepLink> {
    public final /* synthetic */ DeliveryCourierSummaryFragment a;

    public a(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment) {
        this.a = deliveryCourierSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null) {
            DeliveryCourierSummaryFragment deliveryCourierSummaryFragment = this.a;
            deliveryCourierSummaryFragment.startActivity(deliveryCourierSummaryFragment.getDeepLinkIntentFactory().getIntent(deepLink2));
        }
    }
}
