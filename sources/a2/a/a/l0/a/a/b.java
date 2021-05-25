package a2.a.a.l0.a.a;

import com.avito.android.design.widget.picker.DateMonthYearController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ DateMonthYearController a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(DateMonthYearController dateMonthYearController) {
        super(1);
        this.a = dateMonthYearController;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        Object obj = this.a.g.get(num.intValue());
        Intrinsics.checkNotNullExpressionValue(obj, "yearsInts[it]");
        int intValue = ((Number) obj).intValue();
        if (this.a.getYear() != intValue) {
            this.a.b = intValue;
            DateMonthYearController.access$update(this.a);
        }
        return Unit.INSTANCE;
    }
}
