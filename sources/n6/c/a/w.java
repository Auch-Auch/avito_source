package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class w extends Lambda implements Function1<P13, R> {
    public final /* synthetic */ x a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(x xVar, Object obj) {
        super(1);
        this.a = xVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P13 p13) {
        x xVar = this.a;
        y yVar = xVar.a;
        z zVar = yVar.a;
        a0 a0Var = zVar.a;
        b0 b0Var = a0Var.a;
        c0 c0Var = b0Var.a;
        d0 d0Var = c0Var.a;
        e0 e0Var = d0Var.a;
        f0 f0Var = e0Var.a;
        g0 g0Var = f0Var.a;
        h0 h0Var = g0Var.a;
        return (R) h0Var.a.a.invoke(h0Var.b, g0Var.b, f0Var.b, e0Var.b, d0Var.b, c0Var.b, b0Var.b, a0Var.b, zVar.b, yVar.b, xVar.b, this.b, p13);
    }
}
