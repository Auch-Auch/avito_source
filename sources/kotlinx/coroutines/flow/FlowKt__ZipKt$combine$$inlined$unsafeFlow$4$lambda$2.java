package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2", f = "Zip.kt", i = {0, 0, 1, 1}, l = {292, 292}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
    public FlowCollector b;
    public Object[] c;
    public Object d;
    public Object e;
    public Object f;
    public int g;
    public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2(Continuation continuation, FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 flowKt__ZipKt$combine$$inlined$unsafeFlow$4) {
        super(3, continuation);
        this.h = flowKt__ZipKt$combine$$inlined$unsafeFlow$4;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @NotNull Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2(continuation, this.h);
        flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2.b = flowCollector;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2.c = tArr;
        return flowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2) create((FlowCollector) obj, (Object[]) obj2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object[] objArr;
        FlowCollector flowCollector2;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.g;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector2 = this.b;
            Object[] objArr2 = this.c;
            Function2 function2 = this.h.b;
            this.d = flowCollector2;
            this.e = objArr2;
            this.f = flowCollector2;
            this.g = 1;
            Object invoke = function2.invoke(objArr2, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
            objArr = objArr2;
            obj = invoke;
        } else if (i == 1) {
            flowCollector2 = (FlowCollector) this.f;
            objArr = (Object[]) this.e;
            flowCollector = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Object[] objArr3 = (Object[]) this.e;
            FlowCollector flowCollector3 = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.d = flowCollector;
        this.e = objArr;
        this.g = 2;
        if (flowCollector2.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = this.b;
        Object invoke = this.h.b.invoke(this.c, this);
        InlineMarker.mark(0);
        flowCollector.emit(invoke, this);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
