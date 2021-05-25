package a2.a.a.n3;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class f implements Action {
    public final /* synthetic */ Function0 a;

    public f(Function0 function0) {
        this.a = function0;
    }

    @Override // io.reactivex.functions.Action
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
