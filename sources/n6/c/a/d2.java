package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d2 extends Lambda implements Function1<P12, Function1<? super P13, ? extends Function1<? super P14, ? extends Function1<? super P15, ? extends Function1<? super P16, ? extends Function1<? super P17, ? extends R>>>>>> {
    public final /* synthetic */ e2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d2(e2 e2Var, Object obj) {
        super(1);
        this.a = e2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new c2(this, obj);
    }
}
