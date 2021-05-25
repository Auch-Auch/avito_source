package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class m1 extends Lambda implements Function1<P13, Function1<? super P14, ? extends Function1<? super P15, ? extends Function1<? super P16, ? extends R>>>> {
    public final /* synthetic */ n1 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m1(n1 n1Var, Object obj) {
        super(1);
        this.a = n1Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new l1(this, obj);
    }
}
