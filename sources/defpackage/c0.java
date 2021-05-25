package defpackage;

import a2.a.a.e3.e.c;
import android.view.View;
import com.avito.android.paid_services.routing.PaidServicesRouter;
/* compiled from: java-style lambda group */
/* renamed from: c0  reason: default package */
public final class c0 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public c0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            PaidServicesRouter paidServicesRouter = ((c) this.b).a.e;
            if (paidServicesRouter != null) {
                PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter, null, 1, null);
            }
        } else if (i == 1) {
            ((c) this.b).a.requireActivity().onBackPressed();
        } else {
            throw null;
        }
    }
}
