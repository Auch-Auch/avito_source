package u6.a.h0;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
public final class o0 extends Lambda implements Function2<E, R, Pair<? extends E, ? extends R>> {
    public static final o0 a = new o0();

    public o0() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return TuplesKt.to(obj, obj2);
    }
}
