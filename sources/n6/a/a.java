package n6.a;

import arrow.core.Eval;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class a extends Lambda implements Function1<Object, Eval<? extends A>> {
    public final /* synthetic */ Eval.FlatMap a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Eval eval, Eval.FlatMap flatMap, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, b bVar) {
        super(1);
        this.a = flatMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return this.a.run(obj);
    }
}
