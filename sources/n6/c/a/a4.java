package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a4 extends Lambda implements Function1<P17, Function1<? super P18, ? extends Function1<? super P19, ? extends Function1<? super P20, ? extends R>>>> {
    public final /* synthetic */ b4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a4(b4 b4Var, Object obj) {
        super(1);
        this.a = b4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new z3(this, obj);
    }
}
