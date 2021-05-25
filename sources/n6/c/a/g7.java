package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class g7 extends Lambda implements Function1<P9, R> {
    public final /* synthetic */ h7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g7(h7 h7Var, Object obj) {
        super(1);
        this.a = h7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P9 p9) {
        h7 h7Var = this.a;
        i7 i7Var = h7Var.a;
        j7 j7Var = i7Var.a;
        k7 k7Var = j7Var.a;
        l7 l7Var = k7Var.a;
        m7 m7Var = l7Var.a;
        n7 n7Var = m7Var.a;
        return (R) n7Var.a.a.invoke(n7Var.b, m7Var.b, l7Var.b, k7Var.b, j7Var.b, i7Var.b, h7Var.b, this.b, p9);
    }
}
