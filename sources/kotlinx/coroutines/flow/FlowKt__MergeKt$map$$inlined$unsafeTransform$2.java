package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__MergeKt$map$$inlined$unsafeTransform$2 implements Flow<R> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ Function2 b;

    public FlowKt__MergeKt$map$$inlined$unsafeTransform$2(Flow flow, Function2 function2) {
        this.a = flow;
        this.b = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.a.collect(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.2
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0063  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x00a4 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r12
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1
                    r0.<init>(r10, r12)
                L_0x0018:
                    java.lang.Object r12 = r0.a
                    java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x0063
                    if (r2 == r4) goto L_0x0045
                    if (r2 != r3) goto L_0x003d
                    java.lang.Object r11 = r0.j
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r11 = r0.h
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                    java.lang.Object r11 = r0.f
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1) r11
                    java.lang.Object r11 = r0.d
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2) r11
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00a5
                L_0x003d:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0045:
                    java.lang.Object r11 = r0.k
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r2 = r0.j
                    kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                    java.lang.Object r4 = r0.i
                    java.lang.Object r5 = r0.h
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    java.lang.Object r6 = r0.g
                    java.lang.Object r7 = r0.f
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1) r7
                    java.lang.Object r8 = r0.e
                    java.lang.Object r9 = r0.d
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2) r9
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x008e
                L_0x0063:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r3
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2 r2 = r2
                    kotlin.jvm.functions.Function2 r2 = r2.b
                    r0.d = r10
                    r0.e = r11
                    r0.f = r0
                    r0.g = r11
                    r0.h = r0
                    r0.i = r11
                    r0.j = r12
                    r0.k = r12
                    r0.b = r4
                    java.lang.Object r2 = r2.invoke(r11, r0)
                    if (r2 != r1) goto L_0x0085
                    return r1
                L_0x0085:
                    r9 = r10
                    r4 = r11
                    r6 = r4
                    r8 = r6
                    r11 = r12
                    r5 = r0
                    r7 = r5
                    r12 = r2
                    r2 = r11
                L_0x008e:
                    r0.d = r9
                    r0.e = r8
                    r0.f = r7
                    r0.g = r6
                    r0.h = r5
                    r0.i = r4
                    r0.j = r2
                    r0.b = r3
                    java.lang.Object r11 = r11.emit(r12, r0)
                    if (r11 != r1) goto L_0x00a5
                    return r1
                L_0x00a5:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public Object emit$$forInline(Object obj, @NotNull Continuation continuation2) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation2) { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$.inlined.unsafeTransform.2.2.1
                    public /* synthetic */ Object a;
                    public int b;
                    public final /* synthetic */ AnonymousClass2 c;
                    public Object d;
                    public Object e;
                    public Object f;
                    public Object g;
                    public Object h;
                    public Object i;
                    public Object j;
                    public Object k;

                    {
                        this.c = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj2) {
                        this.a = obj2;
                        this.b |= Integer.MIN_VALUE;
                        return this.c.emit(null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector2 = r3;
                Object invoke = this.b.invoke(obj, continuation2);
                InlineMarker.mark(0);
                Object emit = flowCollector2.emit(invoke, continuation2);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                return emit;
            }
        }, continuation);
        if (collect == a.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object collect$$forInline(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.1
            public /* synthetic */ Object a;
            public int b;
            public final /* synthetic */ FlowKt__MergeKt$map$$inlined$unsafeTransform$2 c;

            {
                this.c = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return this.c.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        Flow flow = this.a;
        AnonymousClass2 r1 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r12
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1
                    r0.<init>(r10, r12)
                L_0x0018:
                    java.lang.Object r12 = r0.a
                    java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x0063
                    if (r2 == r4) goto L_0x0045
                    if (r2 != r3) goto L_0x003d
                    java.lang.Object r11 = r0.j
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r11 = r0.h
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                    java.lang.Object r11 = r0.f
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1) r11
                    java.lang.Object r11 = r0.d
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2) r11
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00a5
                L_0x003d:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0045:
                    java.lang.Object r11 = r0.k
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r2 = r0.j
                    kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                    java.lang.Object r4 = r0.i
                    java.lang.Object r5 = r0.h
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    java.lang.Object r6 = r0.g
                    java.lang.Object r7 = r0.f
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.AnonymousClass1) r7
                    java.lang.Object r8 = r0.e
                    java.lang.Object r9 = r0.d
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2) r9
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x008e
                L_0x0063:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r3
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2 r2 = r2
                    kotlin.jvm.functions.Function2 r2 = r2.b
                    r0.d = r10
                    r0.e = r11
                    r0.f = r0
                    r0.g = r11
                    r0.h = r0
                    r0.i = r11
                    r0.j = r12
                    r0.k = r12
                    r0.b = r4
                    java.lang.Object r2 = r2.invoke(r11, r0)
                    if (r2 != r1) goto L_0x0085
                    return r1
                L_0x0085:
                    r9 = r10
                    r4 = r11
                    r6 = r4
                    r8 = r6
                    r11 = r12
                    r5 = r0
                    r7 = r5
                    r12 = r2
                    r2 = r11
                L_0x008e:
                    r0.d = r9
                    r0.e = r8
                    r0.f = r7
                    r0.g = r6
                    r0.h = r5
                    r0.i = r4
                    r0.j = r2
                    r0.b = r3
                    java.lang.Object r11 = r11.emit(r12, r0)
                    if (r11 != r1) goto L_0x00a5
                    return r1
                L_0x00a5:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public Object emit$$forInline(Object obj, @NotNull Continuation continuation2) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation2) { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$.inlined.unsafeTransform.2.2.1
                    public /* synthetic */ Object a;
                    public int b;
                    public final /* synthetic */ AnonymousClass2 c;
                    public Object d;
                    public Object e;
                    public Object f;
                    public Object g;
                    public Object h;
                    public Object i;
                    public Object j;
                    public Object k;

                    {
                        this.c = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj2) {
                        this.a = obj2;
                        this.b |= Integer.MIN_VALUE;
                        return this.c.emit(null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector2 = flowCollector;
                Object invoke = this.b.invoke(obj, continuation2);
                InlineMarker.mark(0);
                Object emit = flowCollector2.emit(invoke, continuation2);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                return emit;
            }
        };
        InlineMarker.mark(0);
        flow.collect(r1, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
