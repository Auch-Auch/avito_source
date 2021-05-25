package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements Flow<Object> {
    public final /* synthetic */ Flow a;

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(Flow flow) {
        this.a = flow;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.a;
        Intrinsics.needClassReification();
        Object collect = flow.collect(new FlowCollector<Object>(flowCollector, this) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.2
            public final /* synthetic */ FlowCollector a;

            {
                this.a = r1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L_0x0041
                    if (r2 != r3) goto L_0x0039
                    java.lang.Object r6 = r0.i
                    kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                    java.lang.Object r6 = r0.g
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                    java.lang.Object r6 = r0.e
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                    java.lang.Object r6 = r0.c
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x006f
                L_0x0039:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0041:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r5.a
                    r2 = 3
                    java.lang.String r4 = "R"
                    kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r4)
                    boolean r2 = r6 instanceof java.lang.Object
                    java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
                    boolean r2 = r2.booleanValue()
                    if (r2 == 0) goto L_0x0072
                    r0.c = r5
                    r0.d = r6
                    r0.e = r0
                    r0.f = r6
                    r0.g = r0
                    r0.h = r6
                    r0.i = r7
                    r0.b = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x006f
                    return r1
                L_0x006f:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    goto L_0x0074
                L_0x0072:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                L_0x0074:
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public Object emit$$forInline(Object obj, @NotNull Continuation continuation2) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation2) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$.inlined.filter.1.2.1
                    public /* synthetic */ Object a;
                    public int b;
                    public Object c;
                    public Object d;
                    public Object e;
                    public Object f;
                    public Object g;
                    public Object h;
                    public Object i;
                    public final /* synthetic */ AnonymousClass2 j;

                    {
                        this.j = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj2) {
                        this.a = obj2;
                        this.b |= Integer.MIN_VALUE;
                        return this.j.emit(null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector2 = this.a;
                Intrinsics.reifiedOperationMarker(3, "R");
                if (!(obj instanceof Object)) {
                    return Unit.INSTANCE;
                }
                InlineMarker.mark(0);
                Object emit = flowCollector2.emit(obj, continuation2);
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
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.1
            public /* synthetic */ Object a;
            public int b;
            public final /* synthetic */ FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 c;

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
        Intrinsics.needClassReification();
        AnonymousClass2 r1 = new FlowCollector<Object>(flowCollector, this) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.2
            public final /* synthetic */ FlowCollector a;

            {
                this.a = r1;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L_0x0041
                    if (r2 != r3) goto L_0x0039
                    java.lang.Object r6 = r0.i
                    kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                    java.lang.Object r6 = r0.g
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                    java.lang.Object r6 = r0.e
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                    java.lang.Object r6 = r0.c
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x006f
                L_0x0039:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0041:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r5.a
                    r2 = 3
                    java.lang.String r4 = "R"
                    kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r4)
                    boolean r2 = r6 instanceof java.lang.Object
                    java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
                    boolean r2 = r2.booleanValue()
                    if (r2 == 0) goto L_0x0072
                    r0.c = r5
                    r0.d = r6
                    r0.e = r0
                    r0.f = r6
                    r0.g = r0
                    r0.h = r6
                    r0.i = r7
                    r0.b = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x006f
                    return r1
                L_0x006f:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    goto L_0x0074
                L_0x0072:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                L_0x0074:
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Nullable
            public Object emit$$forInline(Object obj, @NotNull Continuation continuation2) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation2) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$.inlined.filter.1.2.1
                    public /* synthetic */ Object a;
                    public int b;
                    public Object c;
                    public Object d;
                    public Object e;
                    public Object f;
                    public Object g;
                    public Object h;
                    public Object i;
                    public final /* synthetic */ AnonymousClass2 j;

                    {
                        this.j = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj2) {
                        this.a = obj2;
                        this.b |= Integer.MIN_VALUE;
                        return this.j.emit(null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector2 = this.a;
                Intrinsics.reifiedOperationMarker(3, "R");
                if (!(obj instanceof Object)) {
                    return Unit.INSTANCE;
                }
                InlineMarker.mark(0);
                Object emit = flowCollector2.emit(obj, continuation2);
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
