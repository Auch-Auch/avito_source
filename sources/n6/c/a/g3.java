package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class g3 extends Lambda implements Function1<P18, Function1<? super P19, ? extends R>> {
    public final /* synthetic */ h3 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g3(h3 h3Var, Object obj) {
        super(1);
        this.a = h3Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new f3(this, obj);
    }
}
