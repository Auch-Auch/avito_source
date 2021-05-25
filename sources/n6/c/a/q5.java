package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class q5 extends Lambda implements Function1<P18, Function1<? super P19, ? extends Function1<? super P20, ? extends Function1<? super P21, ? extends Function1<? super P22, ? extends R>>>>> {
    public final /* synthetic */ r5 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q5(r5 r5Var, Object obj) {
        super(1);
        this.a = r5Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new p5(this, obj);
    }
}
