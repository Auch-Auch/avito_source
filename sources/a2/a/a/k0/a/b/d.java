package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.remote.model.delivery.Overlay;
public final class d<T> implements Observer<Overlay> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public d(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Overlay overlay) {
        this.a.getPointInfoViewModel().onNewOverlay(overlay);
    }
}
