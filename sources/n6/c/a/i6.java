package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class i6 extends Lambda implements Function1<P3, Function1<? super P4, ? extends R>> {
    public final /* synthetic */ j6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i6(j6 j6Var, Object obj) {
        super(1);
        this.a = j6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new h6(this, obj);
    }
}
