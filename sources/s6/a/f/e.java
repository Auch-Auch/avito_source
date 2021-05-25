package s6.a.f;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class e implements Consumer {
    public final /* synthetic */ Function1 a;

    public e(Function1 function1) {
        this.a = function1;
    }

    /* JADX WARN: Failed to parse method signature: (TT)V */
    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkExpressionValueIsNotNull(this.a.invoke(obj), "invoke(...)");
    }
}
