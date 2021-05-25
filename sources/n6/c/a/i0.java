package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class i0 extends Lambda implements Function1<P14, R> {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(j0 j0Var, Object obj) {
        super(1);
        this.a = j0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P14 p14) {
        j0 j0Var = this.a;
        k0 k0Var = j0Var.a;
        l0 l0Var = k0Var.a;
        m0 m0Var = l0Var.a;
        n0 n0Var = m0Var.a;
        o0 o0Var = n0Var.a;
        p0 p0Var = o0Var.a;
        q0 q0Var = p0Var.a;
        r0 r0Var = q0Var.a;
        s0 s0Var = r0Var.a;
        t0 t0Var = s0Var.a;
        u0 u0Var = t0Var.a;
        return (R) u0Var.a.a.invoke(u0Var.b, t0Var.b, s0Var.b, r0Var.b, q0Var.b, p0Var.b, o0Var.b, n0Var.b, m0Var.b, l0Var.b, k0Var.b, j0Var.b, this.b, p14);
    }
}
