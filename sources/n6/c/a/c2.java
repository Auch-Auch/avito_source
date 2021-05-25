package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c2 extends Lambda implements Function1<P13, Function1<? super P14, ? extends Function1<? super P15, ? extends Function1<? super P16, ? extends Function1<? super P17, ? extends R>>>>> {
    public final /* synthetic */ d2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c2(d2 d2Var, Object obj) {
        super(1);
        this.a = d2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new b2(this, obj);
    }
}
