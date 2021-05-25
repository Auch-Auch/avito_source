package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b7 extends Lambda implements Function1<P6, Function1<? super P7, ? extends Function1<? super P8, ? extends R>>> {
    public final /* synthetic */ c7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b7(c7 c7Var, Object obj) {
        super(1);
        this.a = c7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new a7(this, obj);
    }
}
