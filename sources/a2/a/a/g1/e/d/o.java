package a2.a.a.g1.e.d;

import com.avito.android.inline_filters.dialog.select.SelectFilterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class o extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SelectFilterView a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(SelectFilterView selectFilterView) {
        super(0);
        this.a = selectFilterView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Function0 function0 = this.a.n;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
