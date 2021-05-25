package androidx.lifecycle;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class FlowLiveDataConversions$asLiveData$1 extends SuspendLambda implements Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object b;
    public int c;
    public final /* synthetic */ Flow d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asLiveData$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.d = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.d, continuation);
        flowLiveDataConversions$asLiveData$1.b = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.d, continuation2);
        flowLiveDataConversions$asLiveData$1.b = obj;
        return flowLiveDataConversions$asLiveData$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = this.d;
            FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 flowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 = new FlowCollector<T>((LiveDataScope) this.b) { // from class: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1
                public final /* synthetic */ LiveDataScope a;

                {
                    this.a = r1;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj2, @NotNull Continuation continuation) {
                    Object emit = this.a.emit(obj2, continuation);
                    if (emit == a.getCOROUTINE_SUSPENDED()) {
                        return emit;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.c = 1;
            if (flow.collect(flowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
