package a2.a.a.k0.e;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class g0 implements Runnable {
    public final /* synthetic */ Function0 a;

    public g0(Function0 function0) {
        this.a = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
