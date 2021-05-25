package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import java.util.List;
public final class c<T> implements Observer<List<? extends Marker>> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public c(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Marker> list) {
        List<? extends Marker> list2 = list;
        if (list2 != null) {
            this.a.getMapViewModel().onNewMarkers(list2);
        }
    }
}
