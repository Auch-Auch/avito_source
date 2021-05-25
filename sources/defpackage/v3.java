package defpackage;

import android.view.View;
import com.avito.android.tariff.edit_info.viewmodel.BottomSheetParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: java-style lambda group */
/* renamed from: v3  reason: default package */
public final class v3 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public v3(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            Function1<Unit, Unit> primaryAction = ((BottomSheetParams) this.c).getPrimaryAction();
            if (primaryAction != null) {
                primaryAction.invoke(Unit.INSTANCE);
            }
        } else if (i == 1) {
            Function1<Unit, Unit> secondaryAction = ((BottomSheetParams) this.c).getSecondaryAction();
            if (secondaryAction != null) {
                secondaryAction.invoke(Unit.INSTANCE);
            }
        } else {
            throw null;
        }
    }
}
