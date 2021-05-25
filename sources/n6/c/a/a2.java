package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a2 extends Lambda implements Function1<P15, Function1<? super P16, ? extends Function1<? super P17, ? extends R>>> {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a2(b2 b2Var, Object obj) {
        super(1);
        this.a = b2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new z1(this, obj);
    }
}
