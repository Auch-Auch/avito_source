package a2.a.a.o1.b.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Runnable {
    public final /* synthetic */ Function0 a;

    public a(Function0 function0) {
        this.a = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
