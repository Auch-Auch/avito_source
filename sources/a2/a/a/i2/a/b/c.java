package a2.a.a.i2.a.b;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.PaymentIntentFactory;
import com.avito.android.delivery.DeliveryActivityInteractionConstants;
import com.avito.android.remote.model.delivery.DeliveryFlowResult;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ DeliveryCourierSummaryFragment a;

    public c(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment) {
        this.a = deliveryCourierSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.setResult(-1, new Intent().putExtra(DeliveryActivityInteractionConstants.DELIVERY_KEY_FLOW_RESULT, new DeliveryFlowResult(true)));
            }
            DeliveryCourierSummaryFragment deliveryCourierSummaryFragment = this.a;
            deliveryCourierSummaryFragment.startActivityForResult(PaymentIntentFactory.DefaultImpls.webPaymentIntent$default(deliveryCourierSummaryFragment.getIntentFactory(), str2, null, 2, null), 1);
        }
    }
}
