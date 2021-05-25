package n6.c.a;

import arrow.syntax.function.CurryingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class y6 extends Lambda implements Function1<P2, Function1<? super P3, ? extends Function1<? super P4, ? extends Function1<? super P5, ? extends Function1<? super P6, ? extends Function1<? super P7, ? extends R>>>>>> {
    public final /* synthetic */ CurryingKt.r a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y6(CurryingKt.r rVar, Object obj) {
        super(1);
        this.a = rVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new x6(this, obj);
    }
}
