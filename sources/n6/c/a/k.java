package n6.c.a;

import arrow.syntax.function.CurryingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class k extends Lambda implements Function1<P2, Function1<? super P3, ? extends Function1<? super P4, ? extends Function1<? super P5, ? extends Function1<? super P6, ? extends Function1<? super P7, ? extends Function1<? super P8, ? extends Function1<? super P9, ? extends Function1<? super P10, ? extends Function1<? super P11, ? extends R>>>>>>>>>> {
    public final /* synthetic */ CurryingKt.a a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(CurryingKt.a aVar, Object obj) {
        super(1);
        this.a = aVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new j(this, obj);
    }
}
