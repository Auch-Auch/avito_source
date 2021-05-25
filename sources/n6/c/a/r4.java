package n6.c.a;

import arrow.syntax.function.CurryingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class r4 extends Lambda implements Function1<P2, Function1<? super P3, ? extends R>> {
    public final /* synthetic */ CurryingKt.n a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r4(CurryingKt.n nVar, Object obj) {
        super(1);
        this.a = nVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new q4(this, obj);
    }
}
