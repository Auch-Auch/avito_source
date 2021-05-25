package a2.a.a.k0.a.b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
public final class q implements View.OnClickListener {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public q(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
