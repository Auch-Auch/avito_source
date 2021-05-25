package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class o5 extends Lambda implements Function1<P20, Function1<? super P21, ? extends Function1<? super P22, ? extends R>>> {
    public final /* synthetic */ p5 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o5(p5 p5Var, Object obj) {
        super(1);
        this.a = p5Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new n5(this, obj);
    }
}
