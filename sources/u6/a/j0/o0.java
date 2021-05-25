package u6.a.j0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
public final class o0<T> extends AbstractFlow<T> {
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public o0(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @Nullable
    public Object collectSafely(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object invoke = this.a.invoke(flowCollector, continuation);
        if (invoke == a.getCOROUTINE_SUSPENDED()) {
            return invoke;
        }
        return Unit.INSTANCE;
    }
}
