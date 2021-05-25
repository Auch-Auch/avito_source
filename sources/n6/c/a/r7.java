package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class r7 extends Lambda implements Function1<P7, Function1<? super P8, ? extends Function1<? super P9, ? extends Function1<? super P10, ? extends R>>>> {
    public final /* synthetic */ s7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r7(s7 s7Var, Object obj) {
        super(1);
        this.a = s7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new q7(this, obj);
    }
}
