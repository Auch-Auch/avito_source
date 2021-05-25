package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class v4 extends Lambda implements Function1<P18, Function1<? super P19, ? extends Function1<? super P20, ? extends Function1<? super P21, ? extends R>>>> {
    public final /* synthetic */ w4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v4(w4 w4Var, Object obj) {
        super(1);
        this.a = w4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new u4(this, obj);
    }
}
