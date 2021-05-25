package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class h3 extends Lambda implements Function1<P17, Function1<? super P18, ? extends Function1<? super P19, ? extends R>>> {
    public final /* synthetic */ i3 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h3(i3 i3Var, Object obj) {
        super(1);
        this.a = i3Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new g3(this, obj);
    }
}
