package u6.a.j0;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0}, l = {148}, m = "reduce", n = {"$this$reduce", "operation", "accumulator", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class h0 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public h0(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return FlowKt.reduce(null, null, this);
    }
}
