package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__LimitKt$drop$$inlined$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ int b;

    public FlowKt__LimitKt$drop$$inlined$unsafeFlow$1(Flow flow, int i) {
        this.a = flow;
        this.b = i;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        Object collect = this.a.collect(new FlowCollector<T>(flowCollector, intRef, this) { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1$lambda$1
            public final /* synthetic */ FlowCollector a;
            public final /* synthetic */ Ref.IntRef b;
            public final /* synthetic */ FlowKt__LimitKt$drop$$inlined$unsafeFlow$1 c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull Continuation continuation2) {
                Ref.IntRef intRef2 = this.b;
                int i = intRef2.element;
                if (i >= this.c.b) {
                    Object emit = this.a.emit(obj, continuation2);
                    if (emit == a.getCOROUTINE_SUSPENDED()) {
                        return emit;
                    }
                } else {
                    intRef2.element = i + 1;
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
