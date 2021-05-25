package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$5"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1 implements FlowCollector<T> {
    public final /* synthetic */ FlowCollector a;
    public final /* synthetic */ FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5 b;

    public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1(FlowCollector flowCollector, FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5 flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5) {
        this.a = flowCollector;
        this.b = flowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object obj, @NotNull Continuation continuation) {
        return this.b.b.invoke(this.a, obj, continuation);
    }

    @Nullable
    public Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1.1
            public /* synthetic */ Object a;
            public int b;
            public final /* synthetic */ FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1 c;

            {
                this.c = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.a = obj2;
                this.b |= Integer.MIN_VALUE;
                return this.c.emit(null, this);
            }
        };
        InlineMarker.mark(5);
        return this.b.b.invoke(this.a, obj, continuation);
    }
}
