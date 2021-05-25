package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class t6 extends Lambda implements Function1<P7, R> {
    public final /* synthetic */ u6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t6(u6 u6Var, Object obj) {
        super(1);
        this.a = u6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P7 p7) {
        u6 u6Var = this.a;
        v6 v6Var = u6Var.a;
        w6 w6Var = v6Var.a;
        x6 x6Var = w6Var.a;
        y6 y6Var = x6Var.a;
        return (R) y6Var.a.a.invoke(y6Var.b, x6Var.b, w6Var.b, v6Var.b, u6Var.b, this.b, p7);
    }
}
