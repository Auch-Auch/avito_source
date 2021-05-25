package u6.a.j0.y0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class f<T> implements FlowCollector<T> {
    public final Object a;
    public final Function2<T, Continuation<? super Unit>, Object> b;
    public final CoroutineContext c;

    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {0}, l = {224}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ FlowCollector e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FlowCollector flowCollector, Continuation continuation) {
            super(2, continuation);
            this.e = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            a aVar = new a(this.e, continuation);
            aVar.b = obj;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: kotlinx.coroutines.flow.FlowCollector */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.b;
                FlowCollector flowCollector = this.e;
                this.c = obj2;
                this.d = 1;
                if (flowCollector.emit(obj2, this) == coroutine_suspended) {
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

    public f(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        this.c = coroutineContext;
        this.a = ThreadContextKt.threadContextElements(coroutineContext);
        this.b = new a(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Object withContextUndispatched = ChannelFlowKt.withContextUndispatched(this.c, t, this.a, this.b, continuation);
        return withContextUndispatched == t6.p.a.a.getCOROUTINE_SUSPENDED() ? withContextUndispatched : Unit.INSTANCE;
    }
}
