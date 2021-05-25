package defpackage;

import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import com.avito.android.util.Keyboards;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: q5  reason: default package */
public final class q5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q5(int i, Object obj, Object obj2) {
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
            ((Function0) this.c).invoke();
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((Function0) this.c).invoke();
            Keyboards.hideKeyboardWithAttempt$default(((MultiselectFilterDialog) this.b).c, 0, 0, 3, null);
            ((MultiselectFilterDialog) this.b).performDismiss();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
