package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class j0 extends Lambda implements Function1<P13, Function1<? super P14, ? extends R>> {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(k0 k0Var, Object obj) {
        super(1);
        this.a = k0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new i0(this, obj);
    }
}
