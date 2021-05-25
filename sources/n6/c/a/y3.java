package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class y3 extends Lambda implements Function1<P19, Function1<? super P20, ? extends R>> {
    public final /* synthetic */ z3 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y3(z3 z3Var, Object obj) {
        super(1);
        this.a = z3Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new x3(this, obj);
    }
}
