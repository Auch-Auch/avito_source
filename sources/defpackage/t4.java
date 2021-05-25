package defpackage;

import android.content.DialogInterface;
import com.avito.android.in_app_calls.ui.dialogs.PermissionDialogsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: t4  reason: default package */
public final class t4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t4(int i, Object obj, Object obj2) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            ((PermissionDialogsKt.a) this.b).b.invoke();
            ((DialogInterface) this.c).dismiss();
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((PermissionDialogsKt.a) this.b).c.invoke();
            ((DialogInterface) this.c).dismiss();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
