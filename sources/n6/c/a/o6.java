package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class o6 extends Lambda implements Function1<P6, R> {
    public final /* synthetic */ p6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o6(p6 p6Var, Object obj) {
        super(1);
        this.a = p6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P6 p62) {
        p6 p6Var = this.a;
        q6 q6Var = p6Var.a;
        r6 r6Var = q6Var.a;
        s6 s6Var = r6Var.a;
        return (R) s6Var.a.a.invoke(s6Var.b, r6Var.b, q6Var.b, p6Var.b, this.b, p62);
    }
}
