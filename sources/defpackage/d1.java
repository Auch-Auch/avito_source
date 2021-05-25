package defpackage;

import android.view.View;
import com.avito.android.tariff.fees_methods.viewmodel.HighDemandBottomSheetParams;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: d1  reason: default package */
public final class d1 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public d1(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((HighDemandBottomSheetParams) this.c).getPrimaryAction().invoke(Unit.INSTANCE);
        } else if (i == 1) {
            ((HighDemandBottomSheetParams) this.c).getSecondaryAction().invoke(Unit.INSTANCE);
        } else {
            throw null;
        }
    }
}
