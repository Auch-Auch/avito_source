package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c7 extends Lambda implements Function1<P5, Function1<? super P6, ? extends Function1<? super P7, ? extends Function1<? super P8, ? extends R>>>> {
    public final /* synthetic */ d7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c7(d7 d7Var, Object obj) {
        super(1);
        this.a = d7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new b7(this, obj);
    }
}
