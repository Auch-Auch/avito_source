package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class k1 extends Lambda implements Function1<P15, Function1<? super P16, ? extends R>> {
    public final /* synthetic */ l1 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k1(l1 l1Var, Object obj) {
        super(1);
        this.a = l1Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new j1(this, obj);
    }
}
