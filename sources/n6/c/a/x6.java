package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class x6 extends Lambda implements Function1<P3, Function1<? super P4, ? extends Function1<? super P5, ? extends Function1<? super P6, ? extends Function1<? super P7, ? extends R>>>>> {
    public final /* synthetic */ y6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x6(y6 y6Var, Object obj) {
        super(1);
        this.a = y6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new w6(this, obj);
    }
}
