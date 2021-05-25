package a2.a.a.g1.e.c;

import android.view.View;
import com.avito.android.inline_filters.dialog.range.RangeFilterDialog;
import com.avito.android.util.Keyboards;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RangeFilterDialog a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(RangeFilterDialog rangeFilterDialog, View view, Function0 function0) {
        super(0);
        this.a = rangeFilterDialog;
        this.b = view;
        this.c = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        View view = this.b;
        if (view != null) {
            Keyboards.hideKeyboardWithAttempt$default(view, 0, 10, 1, null);
        }
        this.c.invoke();
        this.a.performDismiss();
        return Unit.INSTANCE;
    }
}
