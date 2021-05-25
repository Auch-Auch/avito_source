package a2.a.a.q3.f;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.vas_performance.ui.VisualVasFragment;
public final class p0 implements View.OnClickListener {
    public final /* synthetic */ VisualVasFragment a;
    public final /* synthetic */ boolean b;

    public p0(VisualVasFragment visualVasFragment, boolean z) {
        this.a = visualVasFragment;
        this.b = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b) {
            PaidServicesRouter.DefaultImpls.finishFlow$default(VisualVasFragment.access$getRouter$p(this.a), null, 1, null);
            return;
        }
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
