package kotlinx.coroutines.flow;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements Flow<Long> {
    public final /* synthetic */ long[] a;

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.a = jArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super java.lang.Long> r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.AnonymousClass1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1 r2 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.AnonymousClass1) r2
            int r3 = r2.b
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.b = r3
            goto L_0x001c
        L_0x0017:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1 r2 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.a
            java.lang.Object r3 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r4 = r2.b
            r5 = 1
            if (r4 == 0) goto L_0x0058
            if (r4 != r5) goto L_0x0050
            int r4 = r2.k
            int r6 = r2.j
            java.lang.Object r7 = r2.i
            long[] r7 = (long[]) r7
            java.lang.Object r8 = r2.h
            long[] r8 = (long[]) r8
            java.lang.Object r9 = r2.g
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r10 = r2.f
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            java.lang.Object r11 = r2.e
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r12 = r2.d
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 r12 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            r6 = r3
            r3 = r2
            r2 = r11
            goto L_0x00a1
        L_0x0050:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r1)
            long[] r1 = r0.a
            int r4 = r1.length
            r6 = 0
            r12 = r0
            r9 = r1
            r10 = r9
            r6 = r3
            r8 = r4
            r7 = 0
            r1 = r17
            r3 = r2
            r4 = r3
            r2 = r1
        L_0x006a:
            if (r7 >= r8) goto L_0x00a7
            r13 = r9[r7]
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r13)
            r17 = r6
            long r5 = r11.longValue()
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r3.d = r12
            r3.e = r2
            r3.f = r4
            r3.g = r1
            r3.h = r10
            r3.i = r9
            r3.j = r8
            r3.k = r7
            r3.l = r13
            r3.m = r5
            r5 = 1
            r3.b = r5
            java.lang.Object r6 = r1.emit(r11, r3)
            r11 = r17
            if (r6 != r11) goto L_0x009c
            return r11
        L_0x009c:
            r6 = r11
            r15 = r10
            r10 = r4
            r4 = r7
            r7 = r15
        L_0x00a1:
            int r4 = r4 + r5
            r15 = r7
            r7 = r4
            r4 = r10
            r10 = r15
            goto L_0x006a
        L_0x00a7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
