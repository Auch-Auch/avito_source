package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class n3 extends Lambda implements Function1<P11, Function1<? super P12, ? extends Function1<? super P13, ? extends Function1<? super P14, ? extends Function1<? super P15, ? extends Function1<? super P16, ? extends Function1<? super P17, ? extends Function1<? super P18, ? extends Function1<? super P19, ? extends R>>>>>>>>> {
    public final /* synthetic */ o3 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n3(o3 o3Var, Object obj) {
        super(1);
        this.a = o3Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new m3(this, obj);
    }
}
