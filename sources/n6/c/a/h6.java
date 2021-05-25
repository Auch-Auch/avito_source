package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class h6 extends Lambda implements Function1<P4, R> {
    public final /* synthetic */ i6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h6(i6 i6Var, Object obj) {
        super(1);
        this.a = i6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P4 p4) {
        i6 i6Var = this.a;
        j6 j6Var = i6Var.a;
        return (R) j6Var.a.a.invoke(j6Var.b, i6Var.b, this.b, p4);
    }
}
