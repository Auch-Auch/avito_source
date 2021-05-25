package arrow.syntax.function;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\t\u0010\b\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"P1", "P2", "IP", "R", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class CompositionKt$forwardCompose$1 extends Lambda implements Function2<P1, P2, R> {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ Function1 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositionKt$forwardCompose$1(Function2 function2, Function1 function1) {
        super(2);
        this.a = function2;
        this.b = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final R invoke(P1 p1, P2 p2) {
        return (R) this.b.invoke(this.a.invoke(p1, p2));
    }
}
