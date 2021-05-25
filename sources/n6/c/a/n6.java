package n6.c.a;

import arrow.syntax.function.CurryingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class n6 extends Lambda implements Function1<P2, Function1<? super P3, ? extends Function1<? super P4, ? extends Function1<? super P5, ? extends R>>>> {
    public final /* synthetic */ CurryingKt.p a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n6(CurryingKt.p pVar, Object obj) {
        super(1);
        this.a = pVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new m6(this, obj);
    }
}
