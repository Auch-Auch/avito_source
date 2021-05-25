package a2.a.a.n3.z;

import com.avito.android.util.rx3.ErrorAndDuration;
import com.avito.android.util.rx3.RetryWhenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<ErrorAndDuration, Unit> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Function1 function1) {
        super(1);
        this.a = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ErrorAndDuration errorAndDuration) {
        ErrorAndDuration errorAndDuration2 = errorAndDuration;
        Intrinsics.checkNotNullParameter(errorAndDuration2, "e");
        if (errorAndDuration2.getDurationMs() != RetryWhenKt.access$getNO_MORE_DELAYS$p()) {
            this.a.invoke(errorAndDuration2);
        }
        return Unit.INSTANCE;
    }
}
