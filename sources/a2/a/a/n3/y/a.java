package a2.a.a.n3.y;

import com.avito.android.util.rx.ErrorAndDuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<ErrorAndDuration, Unit> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Function1 function1) {
        super(1);
        this.a = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ErrorAndDuration errorAndDuration) {
        ErrorAndDuration errorAndDuration2 = errorAndDuration;
        Intrinsics.checkNotNullParameter(errorAndDuration2, "e");
        if (errorAndDuration2.getDurationMs() != -1) {
            this.a.invoke(errorAndDuration2);
        }
        return Unit.INSTANCE;
    }
}
