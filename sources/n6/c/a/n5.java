package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class n5 extends Lambda implements Function1<P21, Function1<? super P22, ? extends R>> {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n5(o5 o5Var, Object obj) {
        super(1);
        this.a = o5Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new m5(this, obj);
    }
}
