package u6.a.j0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2", f = "Errors.kt", i = {0, 0, 0, 0}, l = {227}, m = "invokeSuspend", n = {"$this$catch", "e", "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class r extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    public FlowCollector b;
    public Throwable c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public int h;
    public final /* synthetic */ Function1 i;
    public final /* synthetic */ Flow j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(Function1 function1, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.i = function1;
        this.j = flow;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        r rVar = new r(this.i, this.j, continuation);
        rVar.b = (FlowCollector) obj;
        rVar.c = th;
        return rVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i2 = this.h;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.b;
            Throwable th = this.c;
            if (((Boolean) this.i.invoke(th)).booleanValue()) {
                Flow flow = this.j;
                this.d = flowCollector;
                this.e = th;
                this.f = flowCollector;
                this.g = flow;
                this.h = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i2 == 1) {
            Flow flow2 = (Flow) this.g;
            FlowCollector flowCollector2 = (FlowCollector) this.f;
            Throwable th2 = (Throwable) this.e;
            FlowCollector flowCollector3 = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
