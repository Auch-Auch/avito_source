package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class x extends Lambda implements Function1<P12, Function1<? super P13, ? extends R>> {
    public final /* synthetic */ y a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(y yVar, Object obj) {
        super(1);
        this.a = yVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new w(this, obj);
    }
}
