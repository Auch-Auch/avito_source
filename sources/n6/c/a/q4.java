package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class q4 extends Lambda implements Function1<P3, R> {
    public final /* synthetic */ r4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q4(r4 r4Var, Object obj) {
        super(1);
        this.a = r4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P3 p3) {
        r4 r4Var = this.a;
        return (R) r4Var.a.a.invoke(r4Var.b, this.b, p3);
    }
}
