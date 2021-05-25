package a2.a.a.k0.a.b;

import androidx.lifecycle.Observer;
import com.avito.android.AuthIntentFactory;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import kotlin.Unit;
public final class e<T> implements Observer<Unit> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public e(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.getMapViewModel().showProgress();
            DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment = this.a;
            deliveryRdsStartOrderingFragment.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(deliveryRdsStartOrderingFragment.getIntentFactory(), null, "d", null, 5, null), 3);
        }
    }
}
