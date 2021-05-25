package a2.a.a.g1.e.d;

import com.avito.android.inline_filters.dialog.select.GroupSelectFilterDialog;
import com.avito.android.util.Keyboards;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ GroupSelectFilterDialog a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(GroupSelectFilterDialog groupSelectFilterDialog, Function0 function0) {
        super(0);
        this.a = groupSelectFilterDialog;
        this.b = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.invoke();
        Keyboards.hideKeyboardWithAttempt$default(this.a.c, 0, 0, 3, null);
        this.a.e.unbind();
        this.a.performDismiss();
        return Unit.INSTANCE;
    }
}
