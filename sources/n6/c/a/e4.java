package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e4 extends Lambda implements Function1<P13, Function1<? super P14, ? extends Function1<? super P15, ? extends Function1<? super P16, ? extends Function1<? super P17, ? extends Function1<? super P18, ? extends Function1<? super P19, ? extends Function1<? super P20, ? extends R>>>>>>>> {
    public final /* synthetic */ f4 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e4(f4 f4Var, Object obj) {
        super(1);
        this.a = f4Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new d4(this, obj);
    }
}
