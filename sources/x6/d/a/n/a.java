package x6.d.a.n;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Function1<? super A, ? extends T>, T> {
    public final /* synthetic */ Object a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Object obj) {
        super(1);
        this.a = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Function1 function1 = (Function1) obj;
        Intrinsics.checkParameterIsNotNull(function1, "it");
        return function1.invoke(this.a);
    }
}
