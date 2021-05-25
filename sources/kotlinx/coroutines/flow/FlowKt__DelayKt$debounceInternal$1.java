package kotlinx.coroutines.flow;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {354, 358}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", ResidentialComplexModuleKt.VALUES, "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", ResidentialComplexModuleKt.VALUES, "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
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
    public final /* synthetic */ Function1 l;

    public static final class a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ Ref.LongRef d;
        public final /* synthetic */ FlowCollector e;
        public final /* synthetic */ Ref.ObjectRef f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Continuation continuation, Ref.ObjectRef objectRef, Ref.LongRef longRef, FlowCollector flowCollector, Ref.ObjectRef objectRef2) {
            super(1, continuation);
            this.c = objectRef;
            this.d = longRef;
            this.e = flowCollector;
            this.f = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new a(continuation, this.c, this.d, this.e, this.f);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return new a(continuation, this.c, this.d, this.e, this.f).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.e;
                Symbol symbol = NullSurrogateKt.NULL;
                T t = this.c.element;
                if (t == symbol) {
                    t = null;
                }
                this.b = 1;
                if (flowCollector.emit(t, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.c.element = null;
            return Unit.INSTANCE;
        }
    }

    public static final class b extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ Ref.LongRef f;
        public final /* synthetic */ FlowCollector g;
        public final /* synthetic */ Ref.ObjectRef h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Continuation continuation, Ref.ObjectRef objectRef, Ref.LongRef longRef, FlowCollector flowCollector, Ref.ObjectRef objectRef2) {
            super(2, continuation);
            this.e = objectRef;
            this.f = longRef;
            this.g = flowCollector;
            this.h = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(continuation, this.e, this.f, this.g, this.h);
            bVar.b = obj;
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            b bVar = new b(continuation, this.e, this.f, this.g, this.h);
            bVar.b = obj;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                T t = (T) this.b;
                if (t == null) {
                    T t2 = this.e.element;
                    if (t2 != null) {
                        FlowCollector flowCollector = this.g;
                        if (t2 == NullSurrogateKt.NULL) {
                            t2 = null;
                        }
                        this.c = t;
                        this.d = 1;
                        if (flowCollector.emit(t2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    this.e.element = t;
                    return Unit.INSTANCE;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.e.element = (T) NullSurrogateKt.DONE;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(Flow flow, Function1 function1, Continuation continuation) {
        super(3, continuation);
        this.k = flow;
        this.l = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.k, this.l, continuation);
        flowKt__DelayKt$debounceInternal$1.b = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.c = (FlowCollector) obj;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00f6 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r12v9, types: [kotlinx.coroutines.selects.SelectBuilder] */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|28|31|32|33|(8:35|36|37|38|39|40|41|42)(1:48)|49|50|51|52|58|(1:60)|(0)(2:63|64)|62) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:35|36|37|38|39|40|41|42) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0112, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0113, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0137, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0139, code lost:
        r0 = th;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013c, code lost:
        r5 = r11;
        r18 = r12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f6 A[SYNTHETIC, Splitter:B:35:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011c A[Catch:{ all -> 0x0112, all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0152  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
        // Method dump skipped, instructions count: 353
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
