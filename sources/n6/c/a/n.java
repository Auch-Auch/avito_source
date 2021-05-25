package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class n extends Lambda implements Function1<P10, Function1<? super P11, ? extends Function1<? super P12, ? extends R>>> {
    public final /* synthetic */ o a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(o oVar, Object obj) {
        super(1);
        this.a = oVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new m(this, obj);
    }
}
