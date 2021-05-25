package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class z1 extends Lambda implements Function1<P16, Function1<? super P17, ? extends R>> {
    public final /* synthetic */ a2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z1(a2 a2Var, Object obj) {
        super(1);
        this.a = a2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new y1(this, obj);
    }
}
