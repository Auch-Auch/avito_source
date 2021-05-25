package arrow.syntax.function;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"IP", "R", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class CompositionKt$forwardCompose$3 extends Lambda implements Function0<R> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function1 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositionKt$forwardCompose$3(Function0 function0, Function1 function1) {
        super(0);
        this.a = function0;
        this.b = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final R invoke() {
        return (R) this.b.invoke(this.a.invoke());
    }
}
