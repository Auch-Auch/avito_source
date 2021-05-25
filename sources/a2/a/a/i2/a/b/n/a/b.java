package a2.a.a.i2.a.b.n.a;

import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.DialogState;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ExtraItemViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ExtraItemViewImpl extraItemViewImpl) {
        super(0);
        this.a = extraItemViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.s.dismiss();
        Function1 function1 = this.a.t;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(DialogState.HIDDEN);
        }
        return Unit.INSTANCE;
    }
}
