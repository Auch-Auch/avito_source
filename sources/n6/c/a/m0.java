package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class m0 extends Lambda implements Function1<P10, Function1<? super P11, ? extends Function1<? super P12, ? extends Function1<? super P13, ? extends Function1<? super P14, ? extends R>>>>> {
    public final /* synthetic */ n0 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m0(n0 n0Var, Object obj) {
        super(1);
        this.a = n0Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new l0(this, obj);
    }
}
