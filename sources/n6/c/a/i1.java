package n6.c.a;

import arrow.syntax.function.CurryingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class i1 extends Lambda implements Function1<P2, Function1<? super P3, ? extends Function1<? super P4, ? extends Function1<? super P5, ? extends Function1<? super P6, ? extends Function1<? super P7, ? extends Function1<? super P8, ? extends Function1<? super P9, ? extends Function1<? super P10, ? extends Function1<? super P11, ? extends Function1<? super P12, ? extends Function1<? super P13, ? extends Function1<? super P14, ? extends Function1<? super P15, ? extends R>>>>>>>>>>>>>> {
    public final /* synthetic */ CurryingKt.e a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i1(CurryingKt.e eVar, Object obj) {
        super(1);
        this.a = eVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new h1(this, obj);
    }
}
