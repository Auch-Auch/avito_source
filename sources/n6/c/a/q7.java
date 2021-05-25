package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class q7 extends Lambda implements Function1<P8, Function1<? super P9, ? extends Function1<? super P10, ? extends R>>> {
    public final /* synthetic */ r7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q7(r7 r7Var, Object obj) {
        super(1);
        this.a = r7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new p7(this, obj);
    }
}
