package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.common.DeliveryMapView;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
public final class o<T> implements Observer<DeliveryMapView.State> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public o(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeliveryMapView.State state) {
        DeliveryMapView.State state2 = state;
        if (state2 != null) {
            DeliveryRdsStartOrderingFragment.access$getMapView$p(this.a).render(state2);
        }
    }
}
