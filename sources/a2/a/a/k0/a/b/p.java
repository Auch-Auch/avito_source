package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
public final class p<T> implements Observer<Boolean> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public p(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        this.a.getMapViewModel().onMapIsReady(bool2 != null ? bool2.booleanValue() : false);
    }
}
