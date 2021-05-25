package a2.a.a.k0.b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment;
public final class a implements View.OnClickListener {
    public final /* synthetic */ RdsOrderCancellationReasonsFragment a;

    public a(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment) {
        this.a = rdsOrderCancellationReasonsFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
