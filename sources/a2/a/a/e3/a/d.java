package a2.a.a.e3.a;

import android.view.View;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.remote.model.Action;
import com.avito.android.tariff.change.ChangeConfirmationDialogFragment;
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ Action b;

    public d(e eVar, Action action) {
        this.a = eVar;
        this.b = action;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Action.Confirmation confirmation = this.b.getConfirmation();
        if (confirmation != null) {
            ChangeConfirmationDialogFragment.Companion.newInstance(confirmation, this.b.getDeepLink()).show(this.a.a.getChildFragmentManager(), "change_confirmation");
            return;
        }
        PaidServicesRouter paidServicesRouter = this.a.a.g;
        if (paidServicesRouter != null) {
            paidServicesRouter.navigate(this.b.getDeepLink());
        }
    }
}
