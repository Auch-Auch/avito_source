package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
public final class k<T> implements Observer<Boolean> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;
    public final /* synthetic */ DeliveryMapViewModel b;

    public k(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, DeliveryMapViewModel deliveryMapViewModel) {
        this.a = deliveryRdsStartOrderingFragment;
        this.b = deliveryMapViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null && bool2.booleanValue()) {
            this.a.a();
            this.b.showProgress();
        }
    }
}
