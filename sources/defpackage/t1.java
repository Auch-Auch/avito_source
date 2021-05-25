package defpackage;

import a2.a.a.r.a.i;
import android.view.View;
import com.avito.android.basket_legacy.ui.Router;
/* compiled from: java-style lambda group */
/* renamed from: t1  reason: default package */
public final class t1 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public t1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((i) this.b).a.requireActivity().onBackPressed();
        } else if (i == 1) {
            Router router = ((i) this.b).a.f;
            if (router != null) {
                Router.DefaultImpls.finishFlow$default(router, false, 1, null);
            }
        } else {
            throw null;
        }
    }
}
