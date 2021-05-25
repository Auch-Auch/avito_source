package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class v0 extends Lambda implements Function1<P15, R> {
    public final /* synthetic */ w0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v0(w0 w0Var, Object obj) {
        super(1);
        this.a = w0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P15 p15) {
        w0 w0Var = this.a;
        x0 x0Var = w0Var.a;
        y0 y0Var = x0Var.a;
        z0 z0Var = y0Var.a;
        a1 a1Var = z0Var.a;
        b1 b1Var = a1Var.a;
        c1 c1Var = b1Var.a;
        d1 d1Var = c1Var.a;
        e1 e1Var = d1Var.a;
        f1 f1Var = e1Var.a;
        g1 g1Var = f1Var.a;
        h1 h1Var = g1Var.a;
        i1 i1Var = h1Var.a;
        return (R) i1Var.a.a.invoke(i1Var.b, h1Var.b, g1Var.b, f1Var.b, e1Var.b, d1Var.b, c1Var.b, b1Var.b, a1Var.b, z0Var.b, y0Var.b, x0Var.b, w0Var.b, this.b, p15);
    }
}
