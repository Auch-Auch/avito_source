package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class p7 extends Lambda implements Function1<P9, Function1<? super P10, ? extends R>> {
    public final /* synthetic */ q7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p7(q7 q7Var, Object obj) {
        super(1);
        this.a = q7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new o7(this, obj);
    }
}
