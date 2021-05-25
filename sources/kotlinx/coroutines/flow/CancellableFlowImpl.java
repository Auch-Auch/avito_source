package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
public final class CancellableFlowImpl<T> implements CancellableFlow<T> {
    public final Flow<T> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl(@NotNull Flow<? extends T> flow) {
        this.a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.a.collect(new FlowCollector<T>(flowCollector) { // from class: kotlinx.coroutines.flow.CancellableFlowImpl$collect$$inlined$collect$1
            public final /* synthetic */ FlowCollector a;

            {
                this.a = r1;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull Continuation continuation2) {
                JobKt.ensureActive(continuation2.getContext());
                Object emit = this.a.emit(obj, continuation2);
                if (emit == a.getCOROUTINE_SUSPENDED()) {
                    return emit;
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        if (collect == a.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
