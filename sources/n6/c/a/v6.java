package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class v6 extends Lambda implements Function1<P5, Function1<? super P6, ? extends Function1<? super P7, ? extends R>>> {
    public final /* synthetic */ w6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v6(w6 w6Var, Object obj) {
        super(1);
        this.a = w6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new u6(this, obj);
    }
}
