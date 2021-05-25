package defpackage;

import android.view.View;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
/* compiled from: java-style lambda group */
/* renamed from: u2  reason: default package */
public final class u2 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public u2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((SoaWithPriceSheetDialogFragment) this.b).getViewModel().onCloseClicked();
        } else if (i == 1) {
            ((SoaWithPriceSheetDialogFragment) this.b).getViewModel().onBackClicked();
        } else {
            throw null;
        }
    }
}
