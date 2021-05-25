package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b1 extends Lambda implements Function1<P9, Function1<? super P10, ? extends Function1<? super P11, ? extends Function1<? super P12, ? extends Function1<? super P13, ? extends Function1<? super P14, ? extends Function1<? super P15, ? extends R>>>>>>> {
    public final /* synthetic */ c1 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b1(c1 c1Var, Object obj) {
        super(1);
        this.a = c1Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new a1(this, obj);
    }
}
