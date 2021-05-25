package n6.a;

import arrow.core.Eval;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Object, Eval<? extends A>> {
    public final /* synthetic */ Eval a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Eval eval) {
        super(1);
        this.a = eval;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return ((Eval.FlatMap) this.a).run(obj);
    }
}
