package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class q6 extends Lambda implements Function1<P4, Function1<? super P5, ? extends Function1<? super P6, ? extends R>>> {
    public final /* synthetic */ r6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q6(r6 r6Var, Object obj) {
        super(1);
        this.a = r6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new p6(this, obj);
    }
}
