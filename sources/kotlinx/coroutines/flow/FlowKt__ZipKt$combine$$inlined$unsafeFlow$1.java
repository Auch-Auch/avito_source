package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u6.a.j0.l0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 implements Flow<R> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ Flow b;
    public final /* synthetic */ Function3 c;

    public static final class a extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        public FlowCollector b;
        public Object[] c;
        public Object d;
        public Object e;
        public Object f;
        public int g;
        public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Continuation continuation, FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1) {
            super(3, continuation);
            this.h = flowKt__ZipKt$combine$$inlined$unsafeFlow$1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object[] objArr, Continuation<? super Unit> continuation) {
            a aVar = new a(continuation, this.h);
            aVar.b = (FlowCollector) obj;
            aVar.c = objArr;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            FlowCollector flowCollector;
            Object[] objArr;
            FlowCollector flowCollector2;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.g;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector2 = this.b;
                Object[] objArr2 = this.c;
                Function3 function3 = this.h.c;
                Object obj2 = objArr2[0];
                Object obj3 = objArr2[1];
                this.d = flowCollector2;
                this.e = objArr2;
                this.f = flowCollector2;
                this.g = 1;
                InlineMarker.mark(6);
                Object invoke = function3.invoke(obj2, obj3, this);
                InlineMarker.mark(7);
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
    }

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(Flow flow, Flow flow2, Function3 function3) {
        this.a = flow;
        this.b = flow2;
        this.c = function3;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object combineInternal = CombineKt.combineInternal(flowCollector, new Flow[]{this.a, this.b}, l0.a, new a(null, this), continuation);
        if (combineInternal == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }
}
