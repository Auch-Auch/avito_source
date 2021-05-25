package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<P9, Function1<? super P10, ? extends Function1<? super P11, ? extends R>>> {
    public final /* synthetic */ e a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, Object obj) {
        super(1);
        this.a = eVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new c(this, obj);
    }
}
