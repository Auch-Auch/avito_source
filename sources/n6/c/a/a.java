package n6.c.a;

import arrow.syntax.function.CurryingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<P2, R> {
    public final /* synthetic */ CurryingKt.k a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CurryingKt.k kVar, Object obj) {
        super(1);
        this.a = kVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P2 p2) {
        return (R) this.a.a.invoke(this.b, p2);
    }
}
