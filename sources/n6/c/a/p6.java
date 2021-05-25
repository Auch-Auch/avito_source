package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class p6 extends Lambda implements Function1<P5, Function1<? super P6, ? extends R>> {
    public final /* synthetic */ q6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p6(q6 q6Var, Object obj) {
        super(1);
        this.a = q6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new o6(this, obj);
    }
}
