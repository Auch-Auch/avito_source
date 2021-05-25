package defpackage;

import android.view.View;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogItemViewImpl;
import com.avito.android.tariff.edit_info.item.alert_dialog.TariffAlertActionItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: java-style lambda group */
/* renamed from: m1  reason: default package */
public final class m1 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public m1(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            Function1 function1 = ((AlertDialogItemViewImpl) this.c).t;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke((TariffAlertActionItem) this.b);
            }
        } else if (i == 1) {
            Function1 function12 = ((AlertDialogItemViewImpl) this.c).t;
            if (function12 != null) {
                Unit unit2 = (Unit) function12.invoke((TariffAlertActionItem) this.b);
            }
        } else {
            throw null;
        }
    }
}
