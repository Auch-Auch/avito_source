package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
public final class a<T> implements Observer<DeliveryRdsPointInfoView.State> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public a(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeliveryRdsPointInfoView.State state) {
        DeliveryRdsPointInfoView.State state2 = state;
        if (state2 != null) {
            DeliveryRdsStartOrderingFragment.access$getPointInfoView$p(this.a).render(state2);
        }
    }
}
