package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class l1 extends Lambda implements Function1<P14, Function1<? super P15, ? extends Function1<? super P16, ? extends R>>> {
    public final /* synthetic */ m1 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l1(m1 m1Var, Object obj) {
        super(1);
        this.a = m1Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new k1(this, obj);
    }
}
