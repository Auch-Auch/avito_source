package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class t5 extends Lambda implements Function1<P15, Function1<? super P16, ? extends Function1<? super P17, ? extends Function1<? super P18, ? extends Function1<? super P19, ? extends Function1<? super P20, ? extends Function1<? super P21, ? extends Function1<? super P22, ? extends R>>>>>>>> {
    public final /* synthetic */ u5 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t5(u5 u5Var, Object obj) {
        super(1);
        this.a = u5Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new s5(this, obj);
    }
}
