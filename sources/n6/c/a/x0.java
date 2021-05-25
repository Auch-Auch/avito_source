package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class x0 extends Lambda implements Function1<P13, Function1<? super P14, ? extends Function1<? super P15, ? extends R>>> {
    public final /* synthetic */ y0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x0(y0 y0Var, Object obj) {
        super(1);
        this.a = y0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new w0(this, obj);
    }
}
