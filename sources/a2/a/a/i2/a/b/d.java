package a2.a.a.i2.a.b;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.delivery.DeliveryActivityInteractionConstants;
import com.avito.android.remote.model.delivery.DeliveryFlowResult;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment;
public final class d<T> implements Observer<Boolean> {
    public final /* synthetic */ DeliveryCourierSummaryFragment a;

    public d(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment) {
        this.a = deliveryCourierSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.setResult(-1, new Intent().putExtra(DeliveryActivityInteractionConstants.DELIVERY_KEY_FLOW_RESULT, new DeliveryFlowResult(bool2.booleanValue())));
            }
            FragmentActivity activity2 = this.a.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }
}
