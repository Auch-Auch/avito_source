package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", i = {0, 0, 1, 1, 1, 1}, l = {190, 216}, m = "invokeSuspend", n = {"$this$transformLatest", "it", "$this$transformLatest", "it", "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
    public FlowCollector b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public int h;
    public final /* synthetic */ Function2 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.i = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super R> flowCollector, T t, @NotNull Continuation<? super Unit> continuation) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.i, continuation);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.b = flowCollector;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.c = t;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return ((FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1) create((FlowCollector) obj, obj2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object obj2;
        FlowCollector flowCollector2;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i2 = this.h;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector2 = this.b;
            Object obj3 = this.c;
            Function2 function2 = this.i;
            this.d = flowCollector2;
            this.e = obj3;
            this.f = flowCollector2;
            this.h = 1;
            Object invoke = function2.invoke(obj3, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
            obj2 = obj3;
            obj = invoke;
        } else if (i2 == 1) {
            flowCollector2 = (FlowCollector) this.f;
            obj2 = this.e;
            flowCollector = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            Flow flow = (Flow) this.g;
            FlowCollector flowCollector3 = (FlowCollector) this.f;
            FlowCollector flowCollector4 = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow flow2 = (Flow) obj;
        this.d = flowCollector;
        this.e = obj2;
        this.f = flowCollector2;
        this.g = flow2;
        this.h = 2;
        if (flow2.collect(flowCollector2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
