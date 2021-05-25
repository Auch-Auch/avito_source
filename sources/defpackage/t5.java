package defpackage;

import a2.a.a.o1.d.w;
import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: t5  reason: default package */
public final class t5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t5(int i, Object obj, Object obj2) {
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
            w wVar = (w) this.b;
            wVar.c.startActivity(wVar.a.getImplicitIntentFactory().createAppSettingsIntent());
            ((DialogInterface) this.c).dismiss();
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((w) this.b).a.getPermissionHelper().requestPermissions(11, "android.permission.WRITE_EXTERNAL_STORAGE");
            ((DialogInterface) this.c).dismiss();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
