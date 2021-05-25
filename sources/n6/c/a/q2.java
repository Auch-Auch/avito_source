package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class q2 extends Lambda implements Function1<P16, Function1<? super P17, ? extends Function1<? super P18, ? extends R>>> {
    public final /* synthetic */ r2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q2(r2 r2Var, Object obj) {
        super(1);
        this.a = r2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new p2(this, obj);
    }
}
