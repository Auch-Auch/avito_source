package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class h7 extends Lambda implements Function1<P8, Function1<? super P9, ? extends R>> {
    public final /* synthetic */ i7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h7(i7 i7Var, Object obj) {
        super(1);
        this.a = i7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new g7(this, obj);
    }
}
