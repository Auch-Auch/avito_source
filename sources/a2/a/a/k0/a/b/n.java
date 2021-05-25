package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import kotlin.Unit;
public final class n<T> implements Observer<Unit> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public n(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.getPointInfoViewModel().onSelectedMarkerDisappeared();
        }
    }
}
