package s6.a.e.e;

import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class d implements Action {
    public final /* synthetic */ Function0 a;

    public d(Function0 function0) {
        this.a = function0;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.a.invoke(), "invoke(...)");
    }
}
