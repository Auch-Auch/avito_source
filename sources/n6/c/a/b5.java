package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b5 extends Lambda implements Function1<P12, Function1<? super P13, ? extends Function1<? super P14, ? extends Function1<? super P15, ? extends Function1<? super P16, ? extends Function1<? super P17, ? extends Function1<? super P18, ? extends Function1<? super P19, ? extends Function1<? super P20, ? extends Function1<? super P21, ? extends R>>>>>>>>>> {
    public final /* synthetic */ c5 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b5(c5 c5Var, Object obj) {
        super(1);
        this.a = c5Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new a5(this, obj);
    }
}
