package arrow.syntax.function;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0006\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"P1", "IP", "R", "p1", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class CompositionKt$forwardCompose$2 extends Lambda implements Function1<P1, R> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function1 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositionKt$forwardCompose$2(Function1 function1, Function1 function12) {
        super(1);
        this.a = function1;
        this.b = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P1 p1) {
        return (R) this.b.invoke(this.a.invoke(p1));
    }
}
