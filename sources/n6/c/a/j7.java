package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class j7 extends Lambda implements Function1<P6, Function1<? super P7, ? extends Function1<? super P8, ? extends Function1<? super P9, ? extends R>>>> {
    public final /* synthetic */ k7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j7(k7 k7Var, Object obj) {
        super(1);
        this.a = k7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new i7(this, obj);
    }
}
