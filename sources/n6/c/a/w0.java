package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class w0 extends Lambda implements Function1<P14, Function1<? super P15, ? extends R>> {
    public final /* synthetic */ x0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w0(x0 x0Var, Object obj) {
        super(1);
        this.a = x0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new v0(this, obj);
    }
}
