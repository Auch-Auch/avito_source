package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class r6 extends Lambda implements Function1<P3, Function1<? super P4, ? extends Function1<? super P5, ? extends Function1<? super P6, ? extends R>>>> {
    public final /* synthetic */ s6 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r6(s6 s6Var, Object obj) {
        super(1);
        this.a = s6Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new q6(this, obj);
    }
}
