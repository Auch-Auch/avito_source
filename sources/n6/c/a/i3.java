package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class i3 extends Lambda implements Function1<P16, Function1<? super P17, ? extends Function1<? super P18, ? extends Function1<? super P19, ? extends R>>>> {
    public final /* synthetic */ j3 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i3(j3 j3Var, Object obj) {
        super(1);
        this.a = j3Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new h3(this, obj);
    }
}
