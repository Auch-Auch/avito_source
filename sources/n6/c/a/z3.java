package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class z3 extends Lambda implements Function1<P18, Function1<? super P19, ? extends Function1<? super P20, ? extends R>>> {
    public final /* synthetic */ a4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z3(a4 a4Var, Object obj) {
        super(1);
        this.a = a4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new y3(this, obj);
    }
}
