package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a7 extends Lambda implements Function1<P7, Function1<? super P8, ? extends R>> {
    public final /* synthetic */ b7 a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a7(b7 b7Var, Object obj) {
        super(1);
        this.a = b7Var;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new z6(this, obj);
    }
}
