package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class x4 extends Lambda implements Function1<P16, Function1<? super P17, ? extends Function1<? super P18, ? extends Function1<? super P19, ? extends Function1<? super P20, ? extends Function1<? super P21, ? extends R>>>>>> {
    public final /* synthetic */ y4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x4(y4 y4Var, Object obj) {
        super(1);
        this.a = y4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new w4(this, obj);
    }
}
