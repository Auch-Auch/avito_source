package u6.a.j0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {0, 0, 1, 1}, l = {214, 214}, m = "invokeSuspend", n = {"$this$transformLatest", "it", "$this$transformLatest", "it"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class x extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
    public FlowCollector b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public int g;
    public final /* synthetic */ Function2 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.h = function2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        x xVar = new x(this.h, continuation);
        xVar.b = (FlowCollector) obj;
        xVar.c = obj2;
        return xVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object obj2;
        FlowCollector flowCollector2;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.g;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector2 = this.b;
            Object obj3 = this.c;
            Function2 function2 = this.h;
            this.d = flowCollector2;
            this.e = obj3;
            this.f = flowCollector2;
            this.g = 1;
            Object invoke = function2.invoke(obj3, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
            obj2 = obj3;
            obj = invoke;
        } else if (i == 1) {
            flowCollector2 = (FlowCollector) this.f;
            obj2 = this.e;
            flowCollector = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            FlowCollector flowCollector3 = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.d = flowCollector;
        this.e = obj2;
        this.g = 2;
        if (flowCollector2.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
