package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {0, 0}, l = {352}, m = "invokeSuspend", n = {"$this$produce", "$this$collect$iv"}, s = {"L$0", "L$1"})
public final class FlowKt__DelayKt$sample$2$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    public ProducerScope b;
    public Object c;
    public Object d;
    public int e;
    public final /* synthetic */ FlowKt__DelayKt$sample$2 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$values$1(FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2, Continuation continuation) {
        super(2, continuation);
        this.f = flowKt__DelayKt$sample$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.f, continuation);
        flowKt__DelayKt$sample$2$values$1.b = (ProducerScope) obj;
        return flowKt__DelayKt$sample$2$values$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.f, continuation);
        flowKt__DelayKt$sample$2$values$1.b = producerScope;
        return flowKt__DelayKt$sample$2$values$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.e;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = this.b;
            Flow flow = this.f.k;
            FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1 flowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1 = new FlowCollector<T>(producerScope) { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1
                public final /* synthetic */ ProducerScope a;

                {
                    this.a = r1;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj2, @NotNull Continuation continuation) {
                    ProducerScope producerScope2 = this.a;
                    if (obj2 == null) {
                        obj2 = NullSurrogateKt.NULL;
                    }
                    Object send = producerScope2.send(obj2, continuation);
                    return send == a.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                }
            };
            this.c = producerScope;
            this.d = flow;
            this.e = 1;
            if (flow.collect(flowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Flow flow2 = (Flow) this.d;
            ProducerScope producerScope2 = (ProducerScope) this.c;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
