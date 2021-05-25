package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class p5 extends Lambda implements Function1<P19, Function1<? super P20, ? extends Function1<? super P21, ? extends Function1<? super P22, ? extends R>>>> {
    public final /* synthetic */ q5 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p5(q5 q5Var, Object obj) {
        super(1);
        this.a = q5Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new o5(this, obj);
    }
}
