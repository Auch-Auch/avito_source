package a2.a.a.k0.b.b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment;
public final class a implements View.OnClickListener {
    public final /* synthetic */ ReasonDetailsFragment a;

    public a(ReasonDetailsFragment reasonDetailsFragment) {
        this.a = reasonDetailsFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
