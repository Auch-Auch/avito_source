package a2.a.a.q3.f;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
public final class z implements View.OnClickListener {
    public final /* synthetic */ PerformanceVasFragment a;
    public final /* synthetic */ boolean b;

    public z(PerformanceVasFragment performanceVasFragment, boolean z) {
        this.a = performanceVasFragment;
        this.b = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b) {
            PaidServicesRouter.DefaultImpls.finishFlow$default(PerformanceVasFragment.access$getRouter$p(this.a), null, 1, null);
            return;
        }
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
