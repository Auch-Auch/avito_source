package a2.a.a.z.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class f implements Runnable {
    public final /* synthetic */ Function0 a;

    public f(Function0 function0) {
        this.a = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
