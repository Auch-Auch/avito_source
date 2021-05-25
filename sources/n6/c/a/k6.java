package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class k6 extends Lambda implements Function1<P5, R> {
    public final /* synthetic */ l6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k6(l6 l6Var, Object obj) {
        super(1);
        this.a = l6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P5 p5) {
        l6 l6Var = this.a;
        m6 m6Var = l6Var.a;
        n6 n6Var = m6Var.a;
        return (R) n6Var.a.a.invoke(n6Var.b, m6Var.b, l6Var.b, this.b, p5);
    }
}
