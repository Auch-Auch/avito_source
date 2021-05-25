package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class j1 extends Lambda implements Function1<P16, R> {
    public final /* synthetic */ k1 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, Object obj) {
        super(1);
        this.a = k1Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P16 p16) {
        k1 k1Var = this.a;
        l1 l1Var = k1Var.a;
        m1 m1Var = l1Var.a;
        n1 n1Var = m1Var.a;
        o1 o1Var = n1Var.a;
        p1 p1Var = o1Var.a;
        q1 q1Var = p1Var.a;
        r1 r1Var = q1Var.a;
        s1 s1Var = r1Var.a;
        t1 t1Var = s1Var.a;
        u1 u1Var = t1Var.a;
        v1 v1Var = u1Var.a;
        w1 w1Var = v1Var.a;
        x1 x1Var = w1Var.a;
        return (R) x1Var.a.a.invoke(x1Var.b, w1Var.b, v1Var.b, u1Var.b, t1Var.b, s1Var.b, r1Var.b, q1Var.b, p1Var.b, o1Var.b, n1Var.b, m1Var.b, l1Var.b, k1Var.b, this.b, p16);
    }
}
