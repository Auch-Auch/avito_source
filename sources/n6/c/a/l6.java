package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class l6 extends Lambda implements Function1<P4, Function1<? super P5, ? extends R>> {
    public final /* synthetic */ m6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l6(m6 m6Var, Object obj) {
        super(1);
        this.a = m6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new k6(this, obj);
    }
}
