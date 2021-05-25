package a2.a.a.k0.e;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.PaymentIntentFactory;
import com.avito.android.delivery.DeliveryActivityInteractionConstants;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
import com.avito.android.remote.model.delivery.DeliveryFlowResult;
public final class b<T> implements Observer<String> {
    public final /* synthetic */ DeliveryRdsSummaryFragment a;

    public b(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment) {
        this.a = deliveryRdsSummaryFragment;
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
            DeliveryRdsSummaryFragment deliveryRdsSummaryFragment = this.a;
            deliveryRdsSummaryFragment.startActivityForResult(PaymentIntentFactory.DefaultImpls.webPaymentIntent$default(deliveryRdsSummaryFragment.getIntentFactory(), str2, null, 2, null), 1);
        }
    }
}
