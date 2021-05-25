package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b2 extends Lambda implements Function1<P14, Function1<? super P15, ? extends Function1<? super P16, ? extends Function1<? super P17, ? extends R>>>> {
    public final /* synthetic */ c2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b2(c2 c2Var, Object obj) {
        super(1);
        this.a = c2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new a2(this, obj);
    }
}
