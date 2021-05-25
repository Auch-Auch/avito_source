package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class y extends Lambda implements Function1<P11, Function1<? super P12, ? extends Function1<? super P13, ? extends R>>> {
    public final /* synthetic */ z a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(z zVar, Object obj) {
        super(1);
        this.a = zVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new x(this, obj);
    }
}
