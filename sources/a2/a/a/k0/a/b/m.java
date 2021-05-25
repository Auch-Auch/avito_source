package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
public final class m<T> implements Observer<Marker> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public m(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Marker marker) {
        Marker marker2 = marker;
        if (marker2 != null) {
            this.a.getPointInfoViewModel().onMarkerClicked(marker2);
        }
    }
}
