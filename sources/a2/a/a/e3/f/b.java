package a2.a.a.e3.f;

import android.view.View;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.remote.model.Action;
public final class b implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ Action b;

    public b(c cVar, Action action) {
        this.a = cVar;
        this.b = action;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PaidServicesRouter paidServicesRouter = this.a.a.e;
        if (paidServicesRouter != null) {
            paidServicesRouter.navigate(this.b.getDeepLink());
        }
    }
}
