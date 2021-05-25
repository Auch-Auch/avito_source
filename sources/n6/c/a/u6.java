package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class u6 extends Lambda implements Function1<P6, Function1<? super P7, ? extends R>> {
    public final /* synthetic */ v6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u6(v6 v6Var, Object obj) {
        super(1);
        this.a = v6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new t6(this, obj);
    }
}
