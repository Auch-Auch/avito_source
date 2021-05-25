package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class o7 extends Lambda implements Function1<P10, R> {
    public final /* synthetic */ p7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o7(p7 p7Var, Object obj) {
        super(1);
        this.a = p7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P10 p10) {
        p7 p7Var = this.a;
        q7 q7Var = p7Var.a;
        r7 r7Var = q7Var.a;
        s7 s7Var = r7Var.a;
        t7 t7Var = s7Var.a;
        u7 u7Var = t7Var.a;
        v7 v7Var = u7Var.a;
        w7 w7Var = v7Var.a;
        return (R) w7Var.a.a.invoke(w7Var.b, v7Var.b, u7Var.b, t7Var.b, s7Var.b, r7Var.b, q7Var.b, p7Var.b, this.b, p10);
    }
}
