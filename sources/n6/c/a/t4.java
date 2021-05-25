package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class t4 extends Lambda implements Function1<P20, Function1<? super P21, ? extends R>> {
    public final /* synthetic */ u4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t4(u4 u4Var, Object obj) {
        super(1);
        this.a = u4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new s4(this, obj);
    }
}
