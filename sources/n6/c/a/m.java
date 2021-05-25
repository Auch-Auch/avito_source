package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class m extends Lambda implements Function1<P11, Function1<? super P12, ? extends R>> {
    public final /* synthetic */ n a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(n nVar, Object obj) {
        super(1);
        this.a = nVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new l(this, obj);
    }
}
