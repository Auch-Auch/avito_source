package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 implements Flow<R> {
    public final /* synthetic */ Flow[] a;
    public final /* synthetic */ Function2 b;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$4(Flow[] flowArr, Function2 function2) {
        this.a = flowArr;
        this.b = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow[] flowArr = this.a;
        Intrinsics.needClassReification();
        Intrinsics.needClassReification();
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1(this), new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2(null, this), continuation);
        if (combineInternal == a.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$4.1
            public /* synthetic */ Object a;
            public int b;
            public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 c;

            {
                this.c = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return this.c.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        Flow[] flowArr = this.a;
        Intrinsics.needClassReification();
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1(this);
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2(null, this);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1, flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
