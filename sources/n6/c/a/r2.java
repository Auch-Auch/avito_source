package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class r2 extends Lambda implements Function1<P15, Function1<? super P16, ? extends Function1<? super P17, ? extends Function1<? super P18, ? extends R>>>> {
    public final /* synthetic */ s2 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r2(s2 s2Var, Object obj) {
        super(1);
        this.a = s2Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new q2(this, obj);
    }
}
