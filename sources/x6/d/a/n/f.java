package x6.d.a.n;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<Function1<? super Unit, ? extends T>, T> {
    public static final f a = new f();

    public f() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Function1 function1 = (Function1) obj;
        Intrinsics.checkParameterIsNotNull(function1, "it");
        return function1.invoke(Unit.INSTANCE);
    }
}
