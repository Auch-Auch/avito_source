package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class m6 extends Lambda implements Function1<P3, Function1<? super P4, ? extends Function1<? super P5, ? extends R>>> {
    public final /* synthetic */ n6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m6(n6 n6Var, Object obj) {
        super(1);
        this.a = n6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new l6(this, obj);
    }
}
