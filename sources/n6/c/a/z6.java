package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class z6 extends Lambda implements Function1<P8, R> {
    public final /* synthetic */ a7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z6(a7 a7Var, Object obj) {
        super(1);
        this.a = a7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P8 p8) {
        a7 a7Var = this.a;
        b7 b7Var = a7Var.a;
        c7 c7Var = b7Var.a;
        d7 d7Var = c7Var.a;
        e7 e7Var = d7Var.a;
        f7 f7Var = e7Var.a;
        return (R) f7Var.a.a.invoke(f7Var.b, e7Var.b, d7Var.b, c7Var.b, b7Var.b, a7Var.b, this.b, p8);
    }
}
