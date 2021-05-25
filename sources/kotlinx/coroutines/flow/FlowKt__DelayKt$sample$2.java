package kotlinx.coroutines.flow;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0, 0}, l = {355}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", ResidentialComplexModuleKt.VALUES, "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public CoroutineScope b;
    public FlowCollector c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public int j;
    public final /* synthetic */ Flow k;
    public final /* synthetic */ long l;

    public static final class a extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
        public Object b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ ReceiveChannel d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ FlowCollector f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Continuation continuation, Ref.ObjectRef objectRef, ReceiveChannel receiveChannel, Ref.ObjectRef objectRef2, FlowCollector flowCollector) {
            super(2, continuation);
            this.c = objectRef;
            this.d = receiveChannel;
            this.e = objectRef2;
            this.f = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(continuation, this.c, this.d, this.e, this.f);
            aVar.b = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            a aVar = new a(continuation, this.c, this.d, this.e, this.f);
            aVar.b = obj;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            T t = (T) this.b;
            if (t == null) {
                this.d.cancel((CancellationException) new ChildCancelledException());
                this.e.element = (T) NullSurrogateKt.DONE;
            } else {
                this.e.element = t;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        public Unit b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ Ref.ObjectRef f;
        public final /* synthetic */ ReceiveChannel g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ FlowCollector i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Continuation continuation, Ref.ObjectRef objectRef, ReceiveChannel receiveChannel, Ref.ObjectRef objectRef2, FlowCollector flowCollector) {
            super(2, continuation);
            this.f = objectRef;
            this.g = receiveChannel;
            this.h = objectRef2;
            this.i = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(continuation, this.f, this.g, this.h, this.i);
            bVar.b = (Unit) obj;
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((b) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i2 = this.e;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Unit unit = this.b;
                Ref.ObjectRef objectRef = this.h;
                T t = objectRef.element;
                if (t == null) {
                    return Unit.INSTANCE;
                }
                T t2 = null;
                objectRef.element = null;
                FlowCollector flowCollector = this.i;
                if (t != NullSurrogateKt.NULL) {
                    t2 = t;
                }
                this.c = unit;
                this.d = t;
                this.e = 1;
                if (flowCollector.emit(t2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 1) {
                Unit unit2 = (Unit) this.c;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2(Flow flow, long j2, Continuation continuation) {
        super(3, continuation);
        this.k = flow;
        this.l = j2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.k, this.l, continuation);
        flowKt__DelayKt$sample$2.b = coroutineScope;
        flowKt__DelayKt$sample$2.c = (FlowCollector) obj;
        return flowKt__DelayKt$sample$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:9|(2:10|11)|12|13|14|19|(1:21)|(1:23)|24|7|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00af, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0071  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
        /*
        // Method dump skipped, instructions count: 205
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
