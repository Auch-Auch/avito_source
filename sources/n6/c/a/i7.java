package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class i7 extends Lambda implements Function1<P7, Function1<? super P8, ? extends Function1<? super P9, ? extends R>>> {
    public final /* synthetic */ j7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i7(j7 j7Var, Object obj) {
        super(1);
        this.a = j7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new h7(this, obj);
    }
}
