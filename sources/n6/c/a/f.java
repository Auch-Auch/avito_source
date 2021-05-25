package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<P7, Function1<? super P8, ? extends Function1<? super P9, ? extends Function1<? super P10, ? extends Function1<? super P11, ? extends R>>>>> {
    public final /* synthetic */ g a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar, Object obj) {
        super(1);
        this.a = gVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new e(this, obj);
    }
}
