package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class p extends Lambda implements Function1<P8, Function1<? super P9, ? extends Function1<? super P10, ? extends Function1<? super P11, ? extends Function1<? super P12, ? extends R>>>>> {
    public final /* synthetic */ q a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(q qVar, Object obj) {
        super(1);
        this.a = qVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new o(this, obj);
    }
}
