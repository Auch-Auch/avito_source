package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class y0 extends Lambda implements Function1<P12, Function1<? super P13, ? extends Function1<? super P14, ? extends Function1<? super P15, ? extends R>>>> {
    public final /* synthetic */ z0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y0(z0 z0Var, Object obj) {
        super(1);
        this.a = z0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new x0(this, obj);
    }
}
